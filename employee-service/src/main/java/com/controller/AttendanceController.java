package com.controller;

import com.model.Employee;
import com.service.AttendanceService;
import com.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final EmployeeService employeeService;

    public AttendanceController(AttendanceService attendanceService, EmployeeService employeeService) {
        this.attendanceService = attendanceService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String viewAll(Model model) {
        model.addAttribute("attendanceList", attendanceService.getAllAttendance());
        return "attendance/list";
    }

    @GetMapping("/employee/{id}")
    public String viewEmployeeAttendance(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("attendanceRecords", attendanceService.getByEmployee(id));
        return "attendance/employee-attendance";
    }

    @GetMapping("/mark")
    public String markForm(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "attendance/mark-form";
    }

    @PostMapping("/mark")
    public String markAttendance(@RequestParam Long employeeId,
                                 @RequestParam String status,
                                 @RequestParam String inTime,
                                 @RequestParam String outTime) {
        attendanceService.markAttendance(employeeId, status, inTime, outTime);
        return "redirect:/attendance";
    }
}
