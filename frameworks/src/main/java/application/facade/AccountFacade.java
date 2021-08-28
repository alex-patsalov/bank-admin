package application.facade;

import application.dto.request.AccountRq;
import application.dto.response.AccountRs;
import application.entity.Account;
import application.services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class AccountFacade implements Facade<Account, AccountRs, AccountRq> {
  @Autowired
  private ModelMapper mapper;
  @Autowired
  AccountService accountService;

  @Override
  public AccountRs toDtoRs(AccountRq accountRq) {
    return mapper.map(accountRq, AccountRs.class);
  }

  @Override
  public AccountRq toDtoRq(AccountRs accountRs) {
    return mapper.map(accountRs, AccountRq.class);
  }

  @Override
  public AccountRs fromEntity(Account entity) {
    return mapper.map(entity, AccountRs.class);
  }

  @Override
  public Account toEntity(AccountRq accountRq) {
    return mapper.map(accountRq, Account.class);
  }

  public void putMoney(String number, AccountRq accountRq) {
    Optional<Account> account = accountService.getByNumber(number);
    if (account.isPresent()) {
      Account a = account.get();
      a.setBalance(a.getBalance() + accountRq.getBalance());
      accountService.save(a);
    }
  }

  public void withdrawMoney(String number, AccountRq accountRq) {
    Optional<Account> account = accountService.getByNumber(number);
    if(account.isPresent() && account.get().getBalance() > accountRq.getBalance()){
      Account a = account.get();
      a.setBalance(a.getBalance() - accountRq.getBalance());
      accountService.save(a);
    }
  }

  public void transferMoney(String from, String to, double sum){
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
