package com.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_documents")
public class EmployeeDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;           // e.g. CNIC, Resume, Contract
    private String title;
    private String fileName;
    private String fileType;
    private LocalDate uploadedDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
