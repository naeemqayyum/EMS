package com.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalaryComponentType {
    private Long id;
    private String name;             // e.g. "Basic Pay", "HRA", "Medical"
    private String category;         // "EARNING" or "DEDUCTION"
    private boolean fixed;           // true = fixed, false = variable
    private boolean active;          // configurable per org
    private boolean visibleToEmployee;

}
