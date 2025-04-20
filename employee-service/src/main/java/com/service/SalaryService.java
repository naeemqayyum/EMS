package com.service;

import com.model.Employee;
import com.model.EmployeeSalary;
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
