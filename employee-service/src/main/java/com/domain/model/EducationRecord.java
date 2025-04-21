package com.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "education_records")
public class EducationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String degree;      // e.g. Bachelors, Masters, PhD
    private String field;       // e.g. Computer Science, Business
    private String institute;   // e.g. LUMS, NUST, FAST
    private String year;        // e.g. 2020
    private String grade;       // e.g. 3.8 CGPA or A+

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
