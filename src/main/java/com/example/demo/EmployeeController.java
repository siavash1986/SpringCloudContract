package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
public class EmployeeController {

  private EmployeeRepository repository;

  public EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/api/employees")
  public Collection<Employee> getAllEmployees() {
    return repository.findAll();
  }

  @GetMapping("/api/employees/{id}")
  public Optional<Employee> getEmployeeById(@PathVariable  Long id) {
    return repository.findById(id);
  }
}
