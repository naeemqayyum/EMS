package com.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceSummary {

    private Long employeeId;
    private String employeeName;
    private Month month;
    private int totalWorkingDays;
    private int daysPresent;
    private int daysAbsent;
    private int casualLeaves;
    private int annualLeaves;
    private int sickLeaves;
    private int lateMarks;

    // Constructor for dummy data (no ID, month, etc.)
    public AttendanceSummary(String employeeName, int totalWorkingDays, int daysPresent, int daysAbsent, int casualLeaves) {
        this.employeeName = employeeName;
        this.totalWorkingDays = totalWorkingDays;
        this.daysPresent = daysPresent;
        this.daysAbsent = daysAbsent;
        this.casualLeaves = casualLeaves;
    }

}
