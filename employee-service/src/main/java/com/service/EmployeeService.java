package com.service;

import com.model.Employee;
import com.model.EmployeeDocument;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();


    public List<Employee> getAllEmployees() {

        employees.add(Employee.builder()
                .employeeId(1L)
                .firstName("Ali")
                .lastName("Khan")
                .age("30")
                .address("Lahore, Pakistan")
                .build());
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(Employee.builder()
                .employeeId(1L)
                .firstName("Ali")
                .lastName("Khan")
                .age("30")
                .address("Lahore, Pakistan")
                .build());

        employees.add(Employee.builder()
                .employeeId(2L)
                .firstName("Sara")
                .lastName("Ahmed")
                .age("28")
                .address("Karachi, Pakistan")
                        .
                build());

        employees.add(Employee.builder()
                .employeeId(3L)
                .firstName("Usman")
                .lastName("Raza")
                .age("35")
                .address("Islamabad, Pakistan")
                .build());
        employees.add(employee);

    }

    public void addEmployees(List<Employee> employeeList) {
    }

    public Employee getEmployeeById(Long id) {
        return Employee.builder()
                .employeeId(3L)
                .firstName("Usman")
                .lastName("Raza")
                .age("35")
                .address("Islamabad, Pakistan")
                .employeeCode("1231223")
                .phone("+923214931507")
                .shiftTiming("Evening Shift")
                .cnic("352014931507")
                .dob("12-12-2012")
                .maritalStatus("Married")
                .gender("Male")
                .department("Engineering")
                .email("uraza@payroll.com")
                .documents(List.of(
                        EmployeeDocument.builder()
                                .title("CNIC Copy")
                                .fileName("cnic.pdf")
                                .fileType("PDF")
                                .uploadedDate(LocalDate.of(2023, 5, 1))
                                .description("Scanned copy of CNIC")
                                .build(),
                        EmployeeDocument.builder()
                                .title("Resume")
                                .fileName("resume.pdf")
                                .fileType("PDF")
                                .uploadedDate(LocalDate.of(2023, 6, 15))
                                .description("Latest resume")
                                .build()
                ))
                .build();
    }

    public long getCount() {
        return 20;
    }

    public Employee getById(Long id) {
        // Dummy data - in a real app this would come from the database
        return Employee.builder()
                .employeeId(3L)
                .firstName("Usman")
                .lastName("Raza")
                .age("35")
                .address("Islamabad, Pakistan")
                .employeeCode("1231223")
                .phone("+923214931507")
                .shiftTiming("Evening Shift")
                .cnic("352014931507")
                .dob("12-12-2012")
                .maritalStatus("Married")
                .gender("Male")
                .department("Engineering")
                .email("uraza@payroll.com")
                .documents(List.of(
                        EmployeeDocument.builder()
                                .title("CNIC Copy")
                                .fileName("cnic.pdf")
                                .fileType("PDF")
                                .uploadedDate(LocalDate.of(2023, 5, 1))
                                .description("Scanned copy of CNIC")
                                .build(),
                        EmployeeDocument.builder()
                                .title("Resume")
                                .fileName("resume.pdf")
                                .fileType("PDF")
                                .uploadedDate(LocalDate.of(2023, 6, 15))
                                .description("Latest resume")
                                .build()
                ))
                .build();

    }

    public List<Employee> getAll() {
        employees.add(Employee.builder()
                .employeeId(1L)
                .firstName("Ali")
                .lastName("Khan")
                .age("30")
                .address("Lahore, Pakistan")
                .build());


        return employees;
    }
}


