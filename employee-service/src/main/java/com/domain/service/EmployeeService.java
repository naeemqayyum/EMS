package com.domain.service;

import com.domain.model.Employee;
import com.adapter.out.persistence.EmployeeJpaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeJpaRepository employeeRepo;

    public EmployeeService(EmployeeJpaRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    public void addEmployees(List<Employee> employeeList) {
        employeeRepo.saveAll(employeeList);
    }

    public long getCount() {
        return employeeRepo.count();
    }

    public List<Employee> getAll() {
        return getAllEmployees();
    }

    @PostConstruct
    public void seed() {
        if (employeeRepo.count() == 0) {
                employeeRepo.saveAll(generateSampleEmployees());
        }

    }

    private List<Employee> generateSampleEmployees() {
        Employee emp1 = Employee.builder()
                .firstName("Ali")
                .lastName("Khan")
                .age("30")
                .address("Lahore, Pakistan")
                .email("ali.khan@example.com")
                .phone("+923001234567")
                .department("Engineering")
                .employeeCode("EMP001")
                .gender("Male")
                .cnic("35201-1234567-1")
                .dob("1993-05-12")
                .employmentType("Full-Time")
                .joiningDate("2020-01-15")
                .employmentStatus("Active")
                .shiftTiming("9AM - 6PM")
                .build();

        Employee emp2 = Employee.builder()
                .firstName("Sara")
                .lastName("Ahmed")
                .age("28")
                .address("Karachi, Pakistan")
                .email("sara.ahmed@example.com")
                .phone("+923004567890")
                .department("HR")
                .employeeCode("EMP002")
                .gender("Female")
                .cnic("42101-7654321-0")
                .dob("1995-09-21")
                .employmentType("Part-Time")
                .joiningDate("2022-06-01")
                .employmentStatus("Active")
                .shiftTiming("10AM - 4PM")
                .build();

        Employee emp3 = Employee.builder()
                .firstName("Usman")
                .lastName("Raza")
                .age("35")
                .address("Islamabad, Pakistan")
                .email("usman.raza@example.com")
                .phone("+923008888999")
                .department("Finance")
                .employeeCode("EMP003")
                .gender("Male")
                .cnic("61101-1122334-5")
                .dob("1989-02-08")
                .employmentType("Contract")
                .joiningDate("2023-03-10")
                .employmentStatus("On Leave")
                .shiftTiming("Flexible")
                .build();

        return List.of(emp1, emp2, emp3);
    }


}
