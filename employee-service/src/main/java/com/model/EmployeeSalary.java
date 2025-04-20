package com.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class EmployeeSalary {

    private Long employeeId;
    private String currency;
    private List<EmployeeSalaryComponent> components;

    public enum SalaryCategory {
        EARNING,
        DEDUCTION
    }

    public enum Frequency {
        MONTHLY,
        ADHOC,
        YEARLY
    }

    // Getters
    public Long getEmployeeId() {
        return employeeId;
    }

    public String getCurrency() {
        return currency;
    }

    public List<EmployeeSalaryComponent> getComponents() {
        return components;
    }

    // Setters
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setComponents(List<EmployeeSalaryComponent> components) {
        this.components = components;
    }
    public double getTotalEarnings() {
        return components.stream()
                .filter(c -> SalaryCategory.valueOf(c.getComponentType().getCategory()).equals(SalaryCategory.EARNING) && c.isActive())
                .mapToDouble(EmployeeSalaryComponent::getAmount)
                .sum();
    }

    public double getTotalDeductions() {
        return components.stream()
                .filter(c -> SalaryCategory.valueOf(c.getComponentType().getCategory()).equals(SalaryCategory.DEDUCTION) && c.isActive())
                .mapToDouble(EmployeeSalaryComponent::getAmount)
                .sum();
    }


    public double getNetSalary() {
        return getTotalEarnings() - getTotalDeductions();
    }
}
