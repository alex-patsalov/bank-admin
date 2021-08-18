package application.facade;

import application.dto.request.CustomerRq;
import application.dto.response.CustomerRs;
import application.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerFacade implements Facade<Customer, CustomerRs, CustomerRq>{

  private final ModelMapper mapper = new ModelMapper();

  @Override
  public CustomerRs toDtoRs(CustomerRq customerRq) {
    return mapper.map(customerRq, CustomerRs.class);
  }

  @Override
  public CustomerRs fromEntity(Customer customer) {
    return mapper.map(customer, CustomerRs.class);
  }

  @Override
  public Customer toEntity(CustomerRq customerRq){
    return mapper.map(customerRq, Customer.class);
  }

  @Override
  public CustomerRq toDtoRq(CustomerRs customerRs) {
    return mapper.map(customerRs, CustomerRq.class);
  }




}
