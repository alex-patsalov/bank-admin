package app1.dto;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private Long id;
  private String name;
  private String email;
  private Integer age;
  private List<Account> accounts;

  public Customer(String name, String email, Integer age) {
    this.name = name;
    this.email = email;
    this.age = age;
    this.accounts = new ArrayList<Account>();
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public Integer getAge() {
    return age;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

}
