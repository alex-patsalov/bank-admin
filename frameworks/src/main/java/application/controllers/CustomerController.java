package application.controllers;

import application.dto.request.CustomerRq;
import application.dto.response.CustomerRs;
import application.entity.Account;
import application.entity.Employer;
import application.enums.Currency;
import application.entity.Customer;
import application.facade.CustomerFacade;
import application.services.AccountService;
import application.services.CustomerService;
import application.services.EmployerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("customer")
public class CustomerController {

  private final CustomerService customerService;
  private final AccountService accountService;
  private final EmployerService employerService;
  private final CustomerFacade customerFacade;

  @GetMapping()
  public CustomerRs getOne(@RequestParam("id") Integer id) {
    Optional<Customer> c = customerService.getById(id);
    return c.map(customer -> customerFacade.fromEntity(customer)).orElse(null);
  }

  @GetMapping({"all"})
  public List<CustomerRs> getAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                  @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
    return customerService.getAll(page, limit)
            .stream()
            .map(c -> customerFacade.fromEntity(c)).collect(Collectors.toList());
  }

  @PostMapping({"create"})
  public Customer createOne(@Validated @RequestBody CustomerRq c) {
    Customer cc = customerFacade.toEntity(c);
    return customerService.save(cc);
  }

  @PutMapping({"modify"})
  public void modify(@RequestParam("id") Integer id, @RequestBody CustomerRq c) {
    Optional<Customer> cId = customerService.getById(id);
    cId.ifPresent(customer -> {
      customer.setName(c.getName());
      customer.setPhone(c.getPhone());
      customer.setPassword(c.getPassword());
      customer.setEmail(c.getEmail());
      customer.setAge(c.getAge());
      customerService.save(cId.get());
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
      Account account = new Account(Currency.getByName(currency.toUpperCase().trim()), customer);
      customer.getAccounts().add(account);
      accountService.save(account);
    }
  }

  @DeleteMapping({"accounts/delete"})
  public void deleteAccount(@RequestParam("id") Integer id) {
    Optional<Account> acc = accountService.getById(id);
    if(acc.isPresent()){
      accountService.deleteById(id);
    }
  }

  @PostMapping({"setEmployer"})
  public void setEmployer(@RequestParam("cID") Integer cID, @RequestParam("eID") Integer eID){
    Optional<Customer> c = customerService.getById(cID);
    Optional<Employer> e = employerService.getById(eID);
    if(c.isPresent() && e.isPresent()) {
      c.get().getEmployers().add(e.get());
      customerService.save(c.get());
      employerService.save(e.get());
    }
  }
}
