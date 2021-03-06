package application.dto.request;

import lombok.Data;

import javax.validation.constraints.PositiveOrZero;

@Data
public class AccountRq {

  private String number;
  @PositiveOrZero(message = "balance must be greater than 0")
  private Double balance;

}
