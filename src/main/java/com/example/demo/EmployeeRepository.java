package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  Stream<Employee> findByName(String name);
}
