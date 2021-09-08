package application.DAO;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface DAO<T> {

  T save(T obj);

  void saveAll(List<T> entities);

  Optional<T> findById(long id);

  List<T> findAll();

  boolean delete(T obj);

  void deleteById(long id);

  boolean deleteAll(List<T> entities);

}
