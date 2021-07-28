package app1.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    return Optional.ofNullable(customers.get((int) id));
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
  public boolean deleteById(long id) {
    return customers.remove(id);
  }

  @Override
  public boolean deleteAll(List<Customer> entities) {
    return customers.removeAll(entities);
  }
}
