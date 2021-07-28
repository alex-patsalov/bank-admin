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

@RequiredArgsConstructor
@RestController
public class CustomerController {

  private final CustomerService customerService;
  private final AccountService accountService;

  @GetMapping({"customer"})
  public Optional<Customer> getOne(@RequestParam("id") long id) {
    return customerService.getById(id);
  }

  @GetMapping({"customer/all"})
  public List<Customer> getAll() {
    return customerService.getAll();
  }

  @PostMapping({"customer/create"})
  public Customer createOne(@RequestBody Customer c) {
    return customerService.save(c);
  }

  @PutMapping({"customer/modify"})
  public void modify(@RequestParam("id") long id,
                     @RequestParam("name") Optional<String> name,
                     @RequestParam("email") Optional<String> email,
                     @RequestParam("age") Optional<Integer> age){
    Optional<Customer> customer = customerService.getById(id);
    if (customer.isPresent()){
      name.ifPresent(n -> customer.get().setName(n));
      email.ifPresent(e -> customer.get().setEmail(e));
      age.ifPresent(a -> customer.get().setAge(a));
    }
  }

  @DeleteMapping({"customer/delete"})
  public void deleteCustomer(@RequestParam("id") long id){
    customerService.deleteById(id);
  }

  @PostMapping({"customer/account/create"})
  public void createAccount(@RequestBody Account a, @RequestParam("id") long id){
    Optional<Customer> c = customerService.getById(id);
    c.ifPresent(cc -> cc.getAccounts().add(a));
    accountService.save(a);
  }

//  Создать счет для конкретного пользователя
//  Удалить счет у пользователя
}
