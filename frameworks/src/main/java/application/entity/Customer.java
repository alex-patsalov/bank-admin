package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer")
public class Customer extends AbstractEntity {

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

  @ManyToMany(cascade = CascadeType.MERGE)
  @JoinTable(name = "customers_employers",
          joinColumns = {@JoinColumn(name = "cus_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "emp_id", referencedColumnName = "id")},
          uniqueConstraints = {@UniqueConstraint(
                  columnNames = {"cus_id", "emp_id"}
          )})
  private List<Employer> employers;
}
