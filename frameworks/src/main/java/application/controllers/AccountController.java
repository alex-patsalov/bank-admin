package application.controllers;

import application.dto.request.AccountRq;
import application.entity.Account;
import application.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("account")
public class AccountController {

  private final AccountService accountService;

  @PutMapping("{put}")
  public void putMoney(@RequestParam("accountNumber") String number, @Validated @RequestBody AccountRq accountRq) {
    Optional<Account> account = accountService.getByNumber(number);
    if (account.isPresent()) {
      Account a = account.get();
      a.setBalance(a.getBalance() + accountRq.getBalance());
      accountService.save(a);
    }
  }

  @PutMapping({"withdraw"})
  public void withdrawMoney(@RequestParam("accountNumber") String number, @Validated @RequestBody AccountRq accountRq) {
    Optional<Account> account = accountService.getByNumber(number);
    if(account.isPresent() && account.get().getBalance() > accountRq.getBalance()){
      Account a = account.get();
      a.setBalance(a.getBalance() - accountRq.getBalance());
      accountService.save(a);
    }
  }

  @PutMapping({"transfer"})
  public void transferMoney(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("sum") double sum){
    Optional<Account> accountFrom = accountService.getByNumber(from);
    Optional<Account> accountTo = accountService.getByNumber(to);
    if(accountFrom.isPresent() && accountTo.isPresent() && accountFrom.get().getBalance() > sum){
      Account af = accountFrom.get();
      Account at = accountTo.get();
      af.setBalance(af.getBalance() - sum);
      at.setBalance(at.getBalance() + sum);
      accountService.save(af);
      accountService.save(at);
    }
  }
}
