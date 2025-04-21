package com.application.repository;

import com.domain.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    Employee save(Employee employee);

    void deleteById(Long id);
}
