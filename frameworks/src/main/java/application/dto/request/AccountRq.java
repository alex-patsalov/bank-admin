package application.dto.request;

import application.enums.Currency;
import lombok.Data;

import javax.validation.constraints.PositiveOrZero;

@Data
public class AccountRq {

  private Currency currency;
  @PositiveOrZero(message = "balance must be greater than 0")
  private Double balance;

}
