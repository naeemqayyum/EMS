package com.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveSummary {
    private int presentDays;
    private int absentDays;
    private int leaveDays;
    private int lateDays;

    private int totalAnnualLeaves;
    private int totalCasualLeaves;
    private int totalSickLeaves;
    private int usedAnnualLeaves;
    private int usedCasualLeaves;
    private List<LocalDate> leaveDates = new ArrayList<>();

}
