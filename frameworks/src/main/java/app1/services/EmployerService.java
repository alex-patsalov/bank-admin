package app1.services;

import app1.entities.Employer;
import app1.DAO.EmployerDAO;
import app1.repositories.EmployerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployerService {

//  private final EmployerDAO employerDAO;
  private final EmployerRepository employerDAO;

  public Employer save(Employer e){
    return employerDAO.save(e);
  }

  public void saveAll(List<Employer> entities){
    employerDAO.saveAll(entities);
  }

  public Optional<Employer> getById(Integer id){
    return employerDAO.findById(id);
  }

  public List<Employer> getAll(){
    return employerDAO.findAll();
  }

  public void delete(Employer e){
     employerDAO.delete(e);
  }

  public void deleteById(Integer id){
    employerDAO.deleteById(id);
  }

  public void deleteAll(List<Employer> es){
     employerDAO.deleteAll(es);
  }

}
