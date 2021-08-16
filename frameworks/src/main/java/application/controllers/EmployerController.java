package application.controllers;

import application.entity.Employer;
import application.services.EmployerService;
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
  public Optional<Employer> getOne(@RequestParam("id") Integer id){
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
  public Employer modify(@PathVariable("id") Integer id, @RequestBody Employer e) {
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
  public void deleteEmployer(@PathVariable("id") Integer id){
    employerService.deleteById(id);
  }
}
