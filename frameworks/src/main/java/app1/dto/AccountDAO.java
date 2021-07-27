package app1.dto;

import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements DAO<Account>{
  private final List<Account> accounts = new ArrayList<>();
  private Long id = 0L;

  @Override
  public Account save(Account account) {
    account.setId(null);
    account.setId(++id);
    accounts.add(account);
    return account;
  }

  @Override
  public void saveAll(List<Account> entities) {
    for (Account a : entities){
      a.setId(null);
      a.setId(++id);
    }
    accounts.addAll(entities);
  }

  @Override
  public Account getOne(long id) {
    return accounts.get((int) id);
  }

  @Override
  public List<Account> getAll() {
    return accounts;
  }

  @Override
  public boolean delete(Account account) {
    return accounts.remove(account);
  }

  @Override
  public boolean deleteById(long id) {
    return accounts.remove(id);
  }

  @Override
  public boolean deleteAll(List<Account> entities) {
    return accounts.removeAll(entities);
  }
}
