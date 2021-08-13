package app1.entities;

import app1.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "account_id")
  private Integer id;

  @Column(name = "number")
  private String number;

  @Column(name = "currency")
  @Enumerated(EnumType.STRING)
  private Currency currency;

  @Column(name = "balance")
  private Double balance;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="customer_id", nullable=false)
  private Customer customer;

  public Account(Currency currency, Customer customer) {
    this.number = UUID.randomUUID().toString();
    this.currency = currency;
    this.balance = 0.0;
    this.customer = customer;
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
