package application.facade;

public interface Facade<T, DtoRs, DtoRq> {

  DtoRs toDtoRs(DtoRq dtoRq);
  DtoRq toDtoRq(DtoRs dtoRs);
  DtoRs fromEntity(T entity);
  T toEntity(DtoRq dtoRq);
}
