package app1.controllers;

import app1.dto.Account;
import app1.dto.Currency;
import app1.dto.Customer;
import app1.services.AccountService;
import app1.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@CrossOrigin /*here*/
@RequestMapping("customers")
public class CustomerController {

  private final CustomerService customerService;
  private final AccountService accountService;

  @GetMapping()
  public Optional<Customer> getOne(@RequestParam("id") long id) {
    return customerService.getById(id);
  }

  @GetMapping({"all"})
  public List<Customer> getAll() {
    return customerService.getAll();
  }

  @PostMapping({"create"})
  public Customer createOne(@RequestBody Customer c) {
    return customerService.save(c);
  }

  @PutMapping({"modify/{id}"})
  public Customer modify(@PathVariable("id") long id, @RequestBody Customer c) {
    return customerService.getById(id)
            .map(customer -> {
              customer.setName(c.getName());
              customer.setEmail(c.getEmail());
              customer.setAge(c.getAge());
              return customer;
            })
            .orElseGet(() -> {
              c.setId(id);
              return customerService.save(c);
            });
  }

  @DeleteMapping({"delete/{id}"})
  public void deleteCustomer(@PathVariable("id") long id) {
    customerService.deleteById(id);
  }

  @PostMapping({"accounts/create/{id}"})
  public void createAccount(@PathVariable long id, @RequestParam("currency") String currency) {
    Optional<Customer> c = customerService.getById(id);
    if (c.isPresent()) {
      Customer customer = c.get();
      Account account = new Account(Currency.valueOf(currency), customer);
      customer.getAccounts().add(account);
      accountService.save(account);
      System.out.println("created");
    }
  }

  @DeleteMapping({"accounts/delete/{id}"})
  public void deleteAccount(@PathVariable long id, @RequestParam("currency") String currency) {
    Optional<Customer> c = customerService.getById(id);
    if (c.isPresent()) {
      Customer customer = c.get();
      List<Account> customerAccounts = customer.getAccounts();
      List<Account> modifiedAccounts = customerAccounts.stream()
                      .filter(a -> !a.getCurrency().toString().equals(currency))
                      .collect(Collectors.toList());
      customer.setAccounts(modifiedAccounts);
      System.out.println("deleted");
    }
  }
}
