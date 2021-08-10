package app1.controllers;

import app1.entities.Employer;
import app1.services.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("employer")
public class EmployerController {

  private final EmployerService employerService;

  @GetMapping()
  public Optional<Employer> getOne(@RequestParam("id") long id){
    return employerService.getById(id);
  }

  @GetMapping({"all"})
  public List<Employer> getAll(){
    return employerService.getAll();
  }

  @PostMapping({"create"})
  public Employer createOne(@RequestBody Employer e){
    return employerService.save(e);
  }

  @PutMapping({"modify/{id}"})
  public Employer modify(@PathVariable("id") long id, @RequestBody Employer e) {
    return employerService.getById(id)
            .map(employer -> {
              employer.setName(e.getName());
              employer.setAddress(e.getAddress());
              return employer;
            })
            .orElseGet(() -> {
              e.setId(id);
              return employerService.save(e);
            });
  }

  @DeleteMapping({"delete/{id}"})
  public void deleteEmployer(@PathVariable("id") long id){
    employerService.deleteById(id);
  }
}
