package com.adapter.out.persistence;

import com.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
    // You can add custom queries here if needed
}
