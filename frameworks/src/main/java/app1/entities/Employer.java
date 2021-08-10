package app1.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employer")
public class Employer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employer_id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @ManyToMany(mappedBy = "employers")
  private List<Customer> customers;


}
