package com.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDocument {
    private Long id;
    private String type;          // e.g. CNIC, Resume, Contract
    private String title;
    private String fileName;
    private String fileType;
    private LocalDate uploadedDate;
    private String description;
}
