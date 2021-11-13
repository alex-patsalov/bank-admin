package application.services;

import application.entity.Account;
import application.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountService {

//  private final AccountDAO accountDAO;
  private final AccountRepository accountDAO;

  public Account save (Account account){
    return accountDAO.save(account);
  }

  public void saveAll(List<Account> entities){
    accountDAO.saveAll(entities);
  }

  public Optional<Account> getById(Integer id){
    return accountDAO.findById(id);
  }

//  move to repo
  public Optional<Account> getByNumber(String number){
    return getAll().stream().filter(a -> a.getNumber().equals(number)).findAny();
  }

  public List<Account> getAll(){
    return accountDAO.findAll();
  }

  public void delete (Account account){
     accountDAO.delete(account);
  }

  public void deleteById(Integer id){
    accountDAO.deleteById(id);
  }

  public void deleteAll(List<Account> entities){
     accountDAO.deleteAll(entities);
  }

}
