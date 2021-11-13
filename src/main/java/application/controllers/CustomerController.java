package application.controllers;

import application.dto.request.CustomerRq;
import application.dto.response.CustomerRs;
import application.entity.Customer;
import application.facade.CustomerFacade;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("customer")
public class CustomerController {

  private final CustomerFacade customerFacade;

  @GetMapping()
  public CustomerRs getOne(@RequestParam("id") Integer id) {
    return customerFacade.getOne(id);
  }

  @GetMapping({"all"})
  public List<CustomerRs> getAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
    return customerFacade.getAll(page, limit);
  }

  @PostMapping()
  public Customer createOne(@Validated @RequestBody CustomerRq c) {
    return customerFacade.createOne(c);
  }

  @PutMapping()
  public void modify(@RequestParam("id") Integer id, @RequestBody CustomerRq c) {
    customerFacade.modify(id, c);
  }

  @DeleteMapping()
  public void deleteCustomer(@RequestParam("id") Integer id) {
    customerFacade.deleteCustomer(id);
  }

  @PostMapping({"accounts"})
  public void createAccount(@RequestParam("id") Integer id, @RequestParam("currency") String currency) {
    customerFacade.createAccount(id, currency);
  }

  @DeleteMapping({"accounts"})
  public void deleteAccount(@RequestParam("id") Integer id) {
    customerFacade.deleteAccount(id);
  }

  @PostMapping({"setEmployer"})
  public void setEmployer(@RequestParam("cID") Integer cID, @RequestParam("eID") Integer eID) {
    customerFacade.setEmployer(cID, eID);
  }
}
