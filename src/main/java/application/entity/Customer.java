package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

  @Column(name = "role")
  private String role;

  @JsonIgnore
  @Column(name = "password")
  private String password;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
  private List<Account> accounts = new ArrayList<>();

  @ManyToMany(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
  @JoinTable(name = "customers_employers",
          joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "employer_id", referencedColumnName = "id")},
          uniqueConstraints = {@UniqueConstraint(columnNames = {"customer_id", "employer_id"})})
  List<Employer> employers = new ArrayList<>();

//  @Transient
//  private final String ROLES_DELIMITER = ":";
//
//  public List<String> getRoles() {
//    if (role == null || role.isEmpty()) return new ArrayList<String>();
//    return Arrays.stream(role.split(ROLES_DELIMITER)).collect(Collectors.toList());
//  }
//
//  public void setRoles(List<String> roles) {
//    this.role = String.join(ROLES_DELIMITER, roles);
//  }


}
