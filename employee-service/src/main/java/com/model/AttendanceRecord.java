package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceRecord {
    private LocalDate date;
    private String status; // Present, Absent, Leave
    private LocalTime inTime;
    private LocalTime outTime;
    private Duration totalHours;
    private String note;

    private String employeeName;
}

