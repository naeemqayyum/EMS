package com.adapter.in.web;

import com.domain.service.AttendanceService;
import com.domain.service.EmployeeService;

import com.domain.service.PayrollService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final EmployeeService employeeService;
    private final PayrollService payrollService;
    private final AttendanceService attendanceService;

    public DashboardController(EmployeeService employeeService,
                               PayrollService payrollService,
                               AttendanceService attendanceService) {
        this.employeeService = employeeService;
        this.payrollService = payrollService;
        this.attendanceService = attendanceService;
    }

    @GetMapping("/")
    public String redirectToDashboard() {
        return "redirect:/employees/dashboard";
    }
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("totalEmployees", employeeService.getCount());
        model.addAttribute("monthlyPayroll", payrollService.getCurrentMonthTotal());
        model.addAttribute("leavesTaken", attendanceService.getLeavesThisMonth());
        model.addAttribute("pendingApprovals", payrollService.getPendingApprovals());

        model.addAttribute("months", List.of("Jan", "Feb", "Mar")); // dynamic in real app
        model.addAttribute("salaryData", List.of(1200000, 1500000, 1800000));

        model.addAttribute("departmentLabels", List.of("HR", "IT", "Finance"));
        model.addAttribute("departmentCounts", List.of(5, 25, 10));

        return "dashboard/dashboard";
    }



}
