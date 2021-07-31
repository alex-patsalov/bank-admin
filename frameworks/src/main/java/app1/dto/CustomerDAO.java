package app1.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Component
public class CustomerDAO implements DAO<Customer>{

  private final List<Customer> customers = new ArrayList<>();
  private Long id = 0L;
  @Override
  public Customer save(Customer customer) {
    customer.setId(null);
    customer.setId(++id);
    customers.add(customer);
    return customer;
  }

  @Override
  public void saveAll(List<Customer> entities) {
    for (Customer c : entities){
      c.setId(null);
      c.setId(++id);
    }
    customers.addAll(entities);
  }

  @Override
  public Optional<Customer> getById(long id) {
    return customers.stream().filter(c -> c.getId() == id).findAny();
  }

  public Optional<Customer> getByName(String name){
    return customers.stream().filter(c -> c.getName().equals(name)).findFirst();
  }

  @Override
  public List<Customer> getAll() {
    return customers;
  }

  @Override
  public boolean delete(Customer customer) {
    return customers.remove(customer);
  }

  @Override
  public void deleteById(long id) {
    Optional<Customer> c = getById(id);
    c.ifPresent(cc -> delete(cc));
  }

  @Override
  public boolean deleteAll(List<Customer> entities) {
    return customers.removeAll(entities);
  }
}
