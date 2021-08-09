package app1.services;

import app1.dto.Employer;
import app1.dto.EmployerDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployerService {

  private final EmployerDAO employerDAO;

  public Employer save(Employer e){
    return employerDAO.save(e);
  }

  public void saveAll(List<Employer> entities){
    employerDAO.saveAll(entities);
  }

  public Optional<Employer> getById(long id){
    return employerDAO.getById(id);
  }

  public List<Employer> getAll(){
    return employerDAO.getAll();
  }

  public boolean delete(Employer e){
    return employerDAO.delete(e);
  }

  public void deleteById(long id){
    employerDAO.deleteById(id);
  }

  public boolean deleteAll(List<Employer> es){
    return employerDAO.deleteAll(es);
  }

}
