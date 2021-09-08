package application.services;

import application.entity.Customer;
import application.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

  public Page<Customer> getAll(int page, int limit){
    return customerDAO.findAll(PageRequest.of(page, limit));
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
