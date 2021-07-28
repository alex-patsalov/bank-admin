package app1.dto;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

  T save(T obj);

  void saveAll(List<T> entities);

  Optional<T> getById(long id);

  List<T> getAll();

  boolean delete(T obj);

  void deleteById(long id);

  boolean deleteAll(List<T> entities);

}
