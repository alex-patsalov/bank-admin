package application.dto;

import lombok.Data;

@Data
public class CustomerRq {

  private String name;
  private String email;
  private Integer age;
  private String phone;
  private String password;

}
