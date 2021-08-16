package application.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  private Integer id;

  @Column(name = "createdAt")
  private LocalDate createdAt;

  @Column(name = "lastModifiedAt")
  private LocalDate lastModifiedAt;
}
