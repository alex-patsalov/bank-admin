package application.dto.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CustomerRq {

  @NotBlank(message = "name is required")
  @Size(min = 2)
  private String name;

  @Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$",
          message = "email is not valid")
  private String email;

  @Positive(message = "age should be equal or greater than 18")
  @Min(18)
  private Integer age;

  @NotBlank(message = "phone is required")
  @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$",
          message = "not valid phone number")
  private String phone;

  private String password;

}
