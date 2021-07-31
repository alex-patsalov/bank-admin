package app1.controllers;

import app1.dto.Account;
import app1.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("accounts")
public class AccountController {

  private final AccountService accountService;

  @PutMapping("{put}")
  public void putMoney(@RequestParam("accountNumber") String number, @RequestParam("sum") double sum) {
    Optional<Account> account = accountService.getByNumber(number);
    if (account.isPresent()) {
      Account a = account.get();
      a.setBalance(a.getBalance() + sum);
      accountService.save(a);
    }
  }

  @PutMapping({"withdraw"})
  public void withdrawMoney(@RequestParam("accountNumber") String number, @RequestParam("sum") double sum) {
    Optional<Account> account = accountService.getByNumber(number);
    if(account.isPresent() && account.get().getBalance() > sum){
      Account a = account.get();
      a.setBalance(a.getBalance() - sum);
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
