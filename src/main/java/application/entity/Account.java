package application.entity;

import application.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "account")
public class Account extends AbstractEntity {

  @Column(name = "number")
  private String number;

  @Column(name = "currency")
  @Enumerated(EnumType.STRING)
  private Currency currency;

  @Column(name = "balance")
  private Double balance;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
  @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false, updatable = false)
  private Customer customer;

  public Account(Currency currency, Customer customer) {
    this.number = UUID.randomUUID().toString();
    this.currency = currency;
    this.balance = 0.0;
    this.customer = customer;
  }
}
