package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer extends AbstractEntity {

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "customer_id")
//  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "age")
  private Integer age;

  @Column(name = "phone")
  private String phone;

  @JsonIgnore
  @Column(name = "password")
  private String password;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
  private List<Account> accounts;

  @ManyToMany
  @JoinTable(name = "customers_employers",
//          joinColumns = {@JoinColumn(name = "cus_id", referencedColumnName = "customer_id")},
          joinColumns = {@JoinColumn(name = "cus_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "emp_id", referencedColumnName = "id")})
  private List<Employer> employers;

//  public Customer(String name, String email, Integer age) {
//    this.name = name;
//    this.email = email;
//    this.age = age;
//    this.accounts = new ArrayList<Account>();
//  }

//  public Customer(String name, String email, Integer age) {
////    this.id = id;
//    this.name = name;
//    this.email = email;
//    this.age = age;
//    this.accounts = new ArrayList<Account>();
//  }

//  @Override
//  public String toString() {
//    return "[Customer:" +
//            "id=" + id +
//            ", name='" + name + '\'' +
//            ", email='" + email + '\'' +
//            ", age=" + age +
//            ", accounts=" + accounts +
//            ']';
//  }
}
