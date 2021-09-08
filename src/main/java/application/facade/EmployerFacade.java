package application.facade;

import application.dto.request.EmployerRq;
import application.dto.response.EmployerRs;
import application.entity.Employer;
import application.services.EmployerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployerFacade implements Facade<Employer, EmployerRs, EmployerRq> {

  @Autowired
  private ModelMapper mapper;
//  private final ModelMapper mapper = new ModelMapper();
  @Autowired
  EmployerService employerService;

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

  public EmployerRs getOne(Integer id){
    Optional<Employer> employer = employerService.getById(id);
    return employer.map(e -> this.fromEntity(e)).orElse(null);
  }

  public List<EmployerRs> getAll(){
    return employerService.getAll()
            .stream()
            .map(e -> this.fromEntity(e)).collect(Collectors.toList());
  }

  public Employer createOne(EmployerRq e){
    return employerService.save(this.toEntity(e));
  }

  public Optional<Employer> modify(Integer id, EmployerRq e) {
    Optional<Employer> eId = employerService.getById(id);
    eId.ifPresent(employer -> {
      employer.setName(e.getName());
      employer.setAddress(e.getAddress());
      employerService.save(eId.get());
    });
    return Optional.of(eId.get());
  }

  public void deleteEmployer(Integer id){
    employerService.deleteById(id);
  }
}
