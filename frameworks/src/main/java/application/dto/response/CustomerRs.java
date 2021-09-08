package application.dto.response;

import application.entity.Employer;
import lombok.Data;

import java.util.List;

@Data
public class CustomerRs {

  private Integer id;
  private String name;
  private String email;
  private Integer age;
  private String phone;
  private List<AccountRs> accounts;
  private List<EmployerRs> employers;
  private String role;

}
