package com.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeSalaryComponent {
    private Long id;
    private SalaryComponentType componentType;
    private double amount;
    private boolean active;          // If disabled for this employee
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo; // optional for adhoc



}

