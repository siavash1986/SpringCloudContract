package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Before
  public void setup() {
    this.employeeRepository.save(new Employee(null, "Siavash"));
    this.employeeRepository.save(new Employee(null, "Paige"));
  }

  @Test
  public void empTest() {
    List<Employee> allEmployees = employeeRepository.findAll();
    assertThat(allEmployees).hasSize(2);
  }

  @Test
  public void testFindByName() {
    IntStream.rangeClosed(1,100)
        .forEach(name -> this.employeeRepository.save(new Employee(null, String.valueOf(name))));


    Page<Employee> employees = employeeRepository.findAll(PageRequest.of(0,10));

    assertThat(employees.getTotalPages()).isEqualTo(11);
    assertThat(employees.getTotalElements()).isEqualTo(102);
  }



}
