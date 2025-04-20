package com.model;

import com.common.model.SalaryComponent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryStructure {

    private Long id;
    private String structureName;          // e.g., "Engineering Team Level 1"
    private String applicableTo;           // e.g., "Engineering", "Marketing", etc.
    private String level;                  // e.g., "Junior", "Mid", "Senior"
    private String currency;               // e.g., "PKR", "USD"

    private List<SalaryComponent> earnings;    // Fixed & variable earnings
    private List<SalaryComponent> deductions;  // Tax, insurance, etc.
    // NEW: For custom override
    private Long employeeId; // Optional: only populated if structure is for a specific employee
}
