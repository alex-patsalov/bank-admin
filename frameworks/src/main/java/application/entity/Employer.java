package application.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employer")
public class Employer extends AbstractEntity {

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "employer_id")
//  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @ManyToMany(mappedBy = "employers")
  private List<Customer> customers;


}
