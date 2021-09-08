package application.controllers;

import application.dto.request.EmployerRq;
import application.dto.response.EmployerRs;
import application.entity.Employer;
import application.facade.EmployerFacade;
import application.services.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("employer")
public class EmployerController {

  private final EmployerFacade employerFacade;

  @GetMapping()
  public EmployerRs getOne(@RequestParam("id") Integer id) {
    return employerFacade.getOne(id);
  }

  @GetMapping({"all"})
  public List<EmployerRs> getAll() {
    return employerFacade.getAll();
  }

  @PostMapping()
  public Employer createOne(@Validated @RequestBody EmployerRq e) {
    return employerFacade.createOne(e);
  }

  @PutMapping()
  public Optional<Employer> modify(@RequestParam("id") Integer id, @RequestBody EmployerRq e) {
    return employerFacade.modify(id, e);
  }

  @DeleteMapping()
  public void deleteEmployer(@RequestParam("id") Integer id) {
    employerFacade.deleteEmployer(id);
  }
}
