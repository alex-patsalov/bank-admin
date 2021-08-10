package app1.controllers;

import app1.entities.Account;
import app1.enums.Currency;
import app1.entities.Customer;
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
@RequestMapping("customer")
public class CustomerController {

  private final CustomerService customerService;
  private final AccountService accountService;

  @GetMapping()
  public Optional<Customer> getOne(@RequestParam("id") Integer id) {
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

  @PutMapping({"modify"})
  public Customer modify(@RequestParam("id") Integer id, @RequestBody Customer c) {
    return customerService.getById(id)
            .map(customer -> {
              customer.setName(c.getName());
              customer.setEmail(c.getEmail());
              customer.setAge(c.getAge());
              return customerService.save(customer);
            })
            .orElseGet(() -> {
              c.setId(id);
              return customerService.save(c);
            });
  }

  @DeleteMapping({"delete"})
  public void deleteCustomer(@RequestParam("id") Integer id) {
    customerService.deleteById(id);
  }

  @PostMapping({"accounts/create"})
  public void createAccount(@RequestParam("id") Integer id, @RequestParam("currency") String currency) {
    Optional<Customer> c = customerService.getById(id);
    if (c.isPresent()) {
      Customer customer = c.get();
      Account account = new Account(Currency.valueOf(currency), customer);
      customer.getAccounts().add(account);
      accountService.save(account);
      System.out.println("created");
    }
  }

  @DeleteMapping({"accounts/delete"})
  public void deleteAccount(@RequestParam("id") Integer id, @RequestParam("currency") String currency) {
    Optional<Customer> c = customerService.getById(id);
    if (c.isPresent()) {
      Customer customer = c.get();
      List<Account> customerAccounts = customer.getAccounts();
      Optional<Account> account = customerAccounts
              .stream()
              .filter(a -> a.getCurrency().toString().equals(currency))
              .findAny();
      List<Account> modifiedAccounts = customerAccounts
              .stream()
              .filter(a -> !a.getCurrency().toString().equals(currency))
              .collect(Collectors.toList());
      customer.setAccounts(modifiedAccounts);
      customerService.save(customer);
      account.ifPresent(a -> accountService.delete(a));
    }
  }
}
