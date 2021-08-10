package app1.services;

import app1.entities.Account;
import app1.DAO.AccountDAO;
import app1.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountService {

  private final AccountDAO accountDAO;
//  private final AccountRepository accountDAO;

  public Account save (Account account){
    return accountDAO.save(account);
  }

  public void saveAll(List<Account> entities){
    accountDAO.saveAll(entities);
  }

  public Optional<Account> getById(long id){
    return accountDAO.getById(id);
  }

  public Optional<Account> getByNumber(String number){return accountDAO.getByNumber(number);}

  public List<Account> getAll(){
    return accountDAO.getAll();
  }

  public boolean delete (Account account){
    return accountDAO.delete(account);
  }

  public void deleteById(long id){
    accountDAO.deleteById(id);
  }

  public boolean deleteAll(List<Account> entities){
    return accountDAO.deleteAll(entities);
  }

}
