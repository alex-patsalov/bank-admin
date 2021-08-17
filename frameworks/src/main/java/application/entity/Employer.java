package application.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
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

  @ManyToMany(mappedBy = "employers")
  private List<Customer> customers;
}
