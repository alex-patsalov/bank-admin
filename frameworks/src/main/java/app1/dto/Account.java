package app1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.UUID;
@Data
public class Account {

  private Long id;
  private String number;
  private Currency currency;
  private Double balance;
  @JsonIgnore
  private Customer customer;

  public Account(Currency currency, Customer customer) {
    this.number = UUID.randomUUID().toString();
    this.currency = currency;
    this.balance = 0.0;
    this.customer = customer;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Long getId() {
    return id;
  }

  public String getNumber() {
    return number;
  }

  public Currency getCurrency() {
    return currency;
  }

  public Double getBalance() {
    return balance;
  }

  public Customer getCustomer() {
    return customer;
  }

  @Override
  public String toString() {
    return "[Account:" +
            "id=" + id +
            ", number='" + number + '\'' +
            ", currency=" + currency +
            ", balance=" + balance +
            ", customer=" + customer +
            ']';
  }
}
