package app1.DAO;

import app1.entities.Account;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Component
public class AccountDAO implements DAO<Account>{
  private final List<Account> accounts = new ArrayList<>();
//  private Long id = 0L;

  @Override
  public Account save(Account account) {
    account.setId(null);
//    account.setId(++id);
    accounts.add(account);
    return account;
  }

  @Override
  public void saveAll(List<Account> entities) {
    for (Account a : entities){
      a.setId(null);
//      a.setId(++id);
    }
    accounts.addAll(entities);
  }

  @Override
  public Optional<Account> findById(long id) {
    return accounts.stream().filter(a -> a.getId() == id).findAny();
  }

  @Override
  public List<Account> findAll() {
    return accounts;
  }

  public Optional<Account> getByNumber(String number){
    return findAll().stream().filter(a -> a.getNumber().equals(number)).findAny();
  }

  @Override
  public boolean delete(Account account) {
    return accounts.remove(account);
  }

  @Override
  public void deleteById(long id) {
    Optional<Account> a = findById(id);
    a.ifPresent(aa -> delete(aa));
  }

  @Override
  public boolean deleteAll(List<Account> entities) {
    return accounts.removeAll(entities);
  }
}
