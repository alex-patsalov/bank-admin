package application.controllers;

import application.dto.request.EmployerRq;
import application.dto.response.EmployerRs;
import application.entity.Customer;
import application.entity.Employer;
import application.facade.EmployerFacade;
import application.services.CustomerService;
import application.services.EmployerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("employer")
public class EmployerController {

  private final EmployerService employerService;
  private final CustomerService customerService;
  private final ModelMapper modelMapper = new ModelMapper();
  private final EmployerFacade employerFacade;

  @GetMapping()
  public EmployerRs getOne(@RequestParam("id") Integer id){
    Optional<Employer> employer = employerService.getById(id);
//    return employer.map(e -> modelMapper.map(e, EmployerRs.class)).orElse(null);
    return employer.map(e -> employerFacade.fromEntity(e)).orElse(null);
  }

  @GetMapping({"all"})
  public List<EmployerRs> getAll(){
    return employerService.getAll()
            .stream()
//            .map(e -> modelMapper.map(e, EmployerRs.class)).collect(Collectors.toList());
            .map(e -> employerFacade.fromEntity(e)).collect(Collectors.toList());
  }

  @PostMapping({"create"})
  public Employer createOne(@Validated @RequestBody EmployerRq e){
//    Employer emp = modelMapper.map(e, Employer.class);
    return employerService.save(employerFacade.toEntity(e));
  }

  @PutMapping({"modify"})
  public Optional<Employer> modify(@RequestParam("id") Integer id, @RequestBody EmployerRq e) {
    Optional<Employer> eId = employerService.getById(id);
    eId.ifPresent(employer -> {
      employer.setName(e.getName());
      employer.setAddress(e.getAddress());
      employerService.save(eId.get());
    });
    return Optional.ofNullable(eId.get());
  }

  @DeleteMapping({"delete"})
  public void deleteEmployer(@RequestParam("id") Integer id){
    employerService.deleteById(id);
  }
}
