package com.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LeaveRecord {
    private LocalDate date;
    private String leaveType; // "Annual", "Casual", etc.
    private String reason;
}
