package app1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "age")
  private Integer age;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable
          (name = "r_customer_account",
                  joinColumns = { @JoinColumn(name = "cus_id", referencedColumnName = "customer_id") },
                  inverseJoinColumns = { @JoinColumn(name = "acc_id", referencedColumnName = "account_id") })
  private List<Account> accounts;

//  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//  @JoinTable
//          (name = "r_customer_employer",
//                  joinColumns = { @JoinColumn(name = "person_id", referencedColumnName = "per_id") },
//                  inverseJoinColumns = { @JoinColumn(name = "employer_id", referencedColumnName = "emp_id") })
  @ManyToMany
  @JoinTable(name = "customers_employers",
          joinColumns = {@JoinColumn(name = "cus_id", referencedColumnName = "customer_id") },
          inverseJoinColumns = {@JoinColumn(name = "emp_id", referencedColumnName = "employer_id") })
  private List<Employer> employers;

  public Customer(String name, String email, Integer age) {
    this.name = name;
    this.email = email;
    this.age = age;
    this.accounts = new ArrayList<Account>();
  }

  public Customer(Long id, String name, String email, Integer age) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.age = age;
    this.accounts = new ArrayList<Account>();
  }

  @Override
  public String toString() {
    return "[Customer:" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", age=" + age +
            ", accounts=" + accounts +
            ']';
  }
}
