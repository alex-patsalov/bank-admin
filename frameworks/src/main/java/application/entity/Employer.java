package application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "employer")
public class Employer extends AbstractEntity {

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @ManyToMany(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
  @JoinTable(name = "customers_employers",
          joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "employer_id", referencedColumnName = "id")},
          uniqueConstraints = {@UniqueConstraint(columnNames = {"customer_id", "employer_id"})})
  private List<Customer> customers = new ArrayList<>();
}
