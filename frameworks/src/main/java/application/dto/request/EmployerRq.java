package application.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class EmployerRq {

  @NotBlank(message = "name is required")
  @Size(min = 3)
  private String name;
  @NotBlank(message = "address is required")
  @Size(min = 3)
  private String address;

}
