package com.domain.service;

import com.domain.model.Employee;
import com.domain.model.EmployeeSalary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryService {
    List<Employee> employees = new ArrayList<>();


    public EmployeeSalary getSalaryByEmployeeId(long iD) {
        return EmployeeSalary.builder().employeeId(122L).currency("USD").build();

    }


}
