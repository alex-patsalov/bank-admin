package app1.dto;

import java.util.List;

public interface DAO<T> {

  T save(T obj);

  void saveAll(List<T> entities);

  T getOne(long id);

  List<T> getAll();

  boolean delete(T obj);

  boolean deleteById(long id);

  boolean deleteAll(List<T> entities);

}
