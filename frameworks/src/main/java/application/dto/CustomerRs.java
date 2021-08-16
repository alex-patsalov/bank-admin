package application.dto;

import application.entity.Account;
import application.entity.Employer;
import lombok.Data;

import java.util.List;

@Data
public class CustomerRs {

  private String name;
  private String email;
  private Integer age;
  private String phone;
  private List<Account> accounts;
  private List<Employer> employers;

}
