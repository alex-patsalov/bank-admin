package app1.services;

import app1.entities.Customer;
import app1.DAO.CustomerDAO;
import app1.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService {

//  private final CustomerDAO customerDAO;
  private final CustomerRepository customerDAO;

  public Customer save(Customer customer){
    return customerDAO.save(customer);
  }

  public void saveAll(List<Customer> entities){
    customerDAO.saveAll(entities);
  }

  public Optional<Customer> getById(Integer id){
    return customerDAO.findById(id);
  }

  public Optional<Customer> getByName(String name){
    return getAll().stream().filter(c -> c.getName().equals(name)).findFirst();
  }

  public List<Customer> getAll(){
    return customerDAO.findAll();
  }

  public void deleteById(Integer id){
    customerDAO.deleteById(id);
  }

  public void delete(Customer c){
     customerDAO.delete(c);
  }

  public void deleteAll(Iterable<Customer> entities){
     customerDAO.deleteAll(entities);
  }

}
