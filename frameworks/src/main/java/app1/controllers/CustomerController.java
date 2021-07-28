package app1.controllers;

import app1.dto.Account;
import app1.dto.Customer;
import app1.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class CustomerController {

  private final CustomerService customerService;

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
      customerService.save(customer.get());
    }
  }

  @DeleteMapping({"customer/delete"})
  public void deleteCustomer(@RequestParam("id") long id){
    customerService.deleteById(id);
  }

//  Создать счет для конкретного пользователя
//  Удалить счет у пользователя
}
