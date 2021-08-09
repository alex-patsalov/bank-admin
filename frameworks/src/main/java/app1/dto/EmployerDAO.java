package app1.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployerDAO implements DAO<Employer>{

  private final List<Employer> employers = new ArrayList<>();
  private Long id = 0L;

  @Override
  public Employer save(Employer obj) {
    obj.setId(null);
    obj.setId(++id);
    employers.add(obj);
    return obj;
  }

  @Override
  public void saveAll(List<Employer> entities) {
    for (Employer e : entities){
      e.setId(null);
      e.setId(++id);
      employers.addAll(entities);
    }
  }

  @Override
  public Optional<Employer> getById(long id) {
    return employers.stream().filter(e -> e.getId() == id).findAny();
  }

  @Override
  public List<Employer> getAll() {
    return employers;
  }

  @Override
  public boolean delete(Employer obj) {
    return employers.remove(obj);
  }

  @Override
  public void deleteById(long id) {
    Optional<Employer> e = getById(id);
    e.ifPresent(ee -> delete(ee));
  }

  @Override
  public boolean deleteAll(List<Employer> entities) {
    return employers.removeAll(entities);
  }
}
