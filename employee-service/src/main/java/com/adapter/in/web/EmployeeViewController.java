package com.adapter.in.web;


import com.domain.model.AttendanceRecord;
import com.domain.model.Employee;
import com.domain.model.EmployeeSalary;
import com.domain.model.EmployeeSalaryComponent;
import com.domain.model.Holiday;
import com.domain.model.LeaveSummary;
import com.domain.model.SalaryComponentType;
import com.domain.service.AttendanceService;
import com.domain.service.EmployeeService;
import com.domain.service.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller // ⚠️ Use @Controller (not @RestController)
public class EmployeeViewController {

    private final EmployeeService employeeService;

    private final SalaryService salaryService;
    private final AttendanceService attendanceService;

    public EmployeeViewController(EmployeeService employeeService, SalaryService salaryService, AttendanceService attendanceService) {
        this.employeeService = employeeService;
        this.salaryService = salaryService;
        this.attendanceService = attendanceService;
    }

    @GetMapping("/employees-view")
    public String viewEmployees(Model model) {
        List<Employee> employees = null;
        employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee/employees"; // 👈 refers to templates/employees.html
    }

    @GetMapping("/employees/details/{id}")
    public String showEmployeeDetails(@PathVariable Long id, Model model) {
        Employee emp = employeeService.getById(id);
        model.addAttribute("employee", emp);
        EmployeeSalary salary = salaryService.getSalaryByEmployeeId(id); // make sure this returns a non-null object
        salary.setComponents(List.of(
                EmployeeSalaryComponent.builder()
                        .componentType(SalaryComponentType.builder()
                                .active(true)
                                .fixed(false)
                                .category("EARNING") // ⚠️ Consider using enum instead of hardcoding strings
                                .name("Bonus")
                                .build())
                        .active(true)
                        .amount(5000.00)
                        .build()
        ));

        List<AttendanceRecord> attendanceList = attendanceService.getAttendanceForEmployee(id);

        LeaveSummary leaveSummary = attendanceService.getLeaveSummaryForEmployee(id);
        List<Holiday> holidays = attendanceService.getUpcomingHolidays();


        model.addAttribute("leaveSummary", leaveSummary);
        model.addAttribute("holidays", holidays);


        model.addAttribute("attendanceList", attendanceList);
        model.addAttribute("employeeSalary", salary);

        return "employee/employeeDetails";
    }

}
