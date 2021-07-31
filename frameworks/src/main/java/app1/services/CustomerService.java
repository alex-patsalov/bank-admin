package app1.services;

import app1.dto.Customer;
import app1.dto.CustomerDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService {

  private final CustomerDAO customerDAO;

  public Customer save(Customer customer){
    return customerDAO.save(customer);
  }

  public void saveAll(List<Customer> entities){
    customerDAO.saveAll(entities);
  }

  public Optional<Customer> getById(long id){
    return customerDAO.getById(id);
  }

  public Optional<Customer> getByName(String name){
    return customerDAO.getByName(name);
  }

  public List<Customer> getAll(){
    return customerDAO.getAll();
  }

  public void deleteById(long id){
    customerDAO.deleteById(id);
  }

  public boolean delete(Customer c){
    return customerDAO.delete(c);
  }

  public boolean deleteAll(List<Customer> entities){
    return customerDAO.deleteAll(entities);
  }

}
