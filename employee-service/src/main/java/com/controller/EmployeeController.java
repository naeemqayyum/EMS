package com.controller;

import com.model.Employee;
import com.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @Tag(name = "Employee API", description = "Operations related to fetching employee list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    @Tag(name = "Add Employee API", description = "Operations related to adding employee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }


    @PutMapping
    @Tag(name = "update Employee API", description = "Operations related to updating employee ")
    public void updateEmplyee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

//    @PostMapping
//    @Tag(name = "bulk add Employee API", description = "Operations related to adding employees from CSV")
//    public void addEmployeeCSV(@RequestBody List<Employee> employeeList) {
//        employeeService.addEmployees(employeeList);
//    }


}
