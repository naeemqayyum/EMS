package com.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "attendance_records")
public class AttendanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String status; // Present, Absent, Leave
    private LocalTime inTime;
    private LocalTime outTime;

    @Column(name = "total_hours")
    private Duration totalHours;

    private String note;

    private String employeeName;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public AttendanceRecord(LocalDate date, String status, LocalTime inTime, LocalTime outTime,
                            Duration totalHours, String note, String employeeName) {
        this.date = date;
        this.status = status;
        this.inTime = inTime;
        this.outTime = outTime;
        this.totalHours = totalHours;
        this.note = note;
        this.employeeName = employeeName;
    }

}

