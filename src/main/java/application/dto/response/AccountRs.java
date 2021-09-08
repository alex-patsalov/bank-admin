package application.dto.response;

import application.enums.Currency;
import lombok.Data;

@Data
public class AccountRs {

  private Integer id;
  private String number;
  private Currency currency;
  private Double balance;

}
