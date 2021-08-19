package application.facade;

import application.dto.request.EmployerRq;
import application.dto.response.EmployerRs;
import application.entity.Employer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployerFacade implements Facade<Employer, EmployerRs, EmployerRq> {

  private final ModelMapper mapper = new ModelMapper();

  @Override
  public EmployerRs toDtoRs(EmployerRq employerRq) {
    return mapper.map(employerRq, EmployerRs.class);
  }

  @Override
  public EmployerRq toDtoRq(EmployerRs employerRs) {
    return mapper.map(employerRs, EmployerRq.class);
  }

  @Override
  public EmployerRs fromEntity(Employer entity) {
    return mapper.map(entity, EmployerRs.class);
  }

  @Override
  public Employer toEntity(EmployerRq employerRq) {
    return mapper.map(employerRq, Employer.class);
  }
}
