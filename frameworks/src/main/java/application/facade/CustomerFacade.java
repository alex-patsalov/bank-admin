package application.facade;

import application.dto.request.CustomerRq;
import application.dto.response.CustomerRs;
import application.entity.Account;
import application.entity.Customer;
import application.entity.Employer;
import application.enums.Currency;
import application.services.AccountService;
import application.services.CustomerService;
import application.services.EmployerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerFacade implements Facade<Customer, CustomerRs, CustomerRq> {

  @Autowired
  private ModelMapper mapper;
  @Autowired
  CustomerService customerService;
  @Autowired
  AccountService accountService;
  @Autowired
  EmployerService employerService;

  @Override
  public CustomerRs toDtoRs(CustomerRq customerRq) {
    return mapper.map(customerRq, CustomerRs.class);
  }

  @Override
  public CustomerRs fromEntity(Customer customer) {
    return mapper.map(customer, CustomerRs.class);
  }

  @Override
  public Customer toEntity(CustomerRq customerRq) {
    return mapper.map(customerRq, Customer.class);
  }

  @Override
  public CustomerRq toDtoRq(CustomerRs customerRs) {
    return mapper.map(customerRs, CustomerRq.class);
  }

  public CustomerRs getOne(Integer id) {
    Optional<Customer> c = customerService.getById(id);
    return c.map(customer -> this.fromEntity(customer)).orElse(null);
  }

  public List<CustomerRs> getAll(int page, int limit) {
    return customerService.getAll(page, limit)
            .stream()
            .map(c -> this.fromEntity(c)).collect(Collectors.toList());
  }

  public Customer createOne(CustomerRq c) {
    Customer cc = this.toEntity(c);
    return customerService.save(cc);
  }

  public void modify(Integer id, CustomerRq c) {
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

  public void deleteCustomer(Integer id) {
    customerService.deleteById(id);
  }

  public void createAccount(Integer id, String currency) {
    Optional<Customer> c = customerService.getById(id);
    if (c.isPresent()) {
      Customer customer = c.get();
      Account account = new Account(Currency.getByName(currency.toUpperCase().trim()), customer);
      customer.getAccounts().add(account);
      accountService.save(account);
    }
  }

  public void deleteAccount(Integer id) {
    Optional<Account> acc = accountService.getById(id);
    if (acc.isPresent()) {
      accountService.deleteById(id);
    }
  }

  public void setEmployer(Integer cID, Integer eID) {
    Optional<Customer> c = customerService.getById(cID);
    Optional<Employer> e = employerService.getById(eID);
    if (c.isPresent() && e.isPresent()) {
      c.get().getEmployers().add(e.get());
      customerService.save(c.get());
      employerService.save(e.get());
    }
  }
}
