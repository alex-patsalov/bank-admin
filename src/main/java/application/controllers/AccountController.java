package application.controllers;

import application.dto.request.AccountRq;
import application.facade.AccountFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("account")
public class AccountController {

  private final AccountFacade accountFacade;

  @PutMapping("put")
  public void putMoney(@RequestParam("accountNumber") String number, @Validated @RequestBody AccountRq accountRq) {
    accountFacade.putMoney(number, accountRq);
  }

  @PutMapping({"withdraw"})
  public void withdrawMoney(@RequestParam("accountNumber") String number, @Validated @RequestBody AccountRq accountRq) {
    accountFacade.withdrawMoney(number, accountRq);
  }

  @PutMapping({"transfer"})
  public void transferMoney(@RequestParam("from") String from, @RequestParam("to") String to,
                            @RequestParam("sum") double sum) {
    accountFacade.transferMoney(from, to, sum);
  }
}
