package com.domain.service;

import com.domain.model.AttendanceRecord;
import com.domain.model.AttendanceSummary;
import com.domain.model.Holiday;
import com.domain.model.LeaveSummary;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AttendanceService {

    public static List<AttendanceRecord> getAttendanceForEmployee(Long employeeId) {
        List<AttendanceRecord> records = new ArrayList<>();

        // Sample data for the last 7 days
        for (int i = 0; i < 7; i++) {
            LocalDate date = LocalDate.now().minusDays(i);
            AttendanceRecord record = new AttendanceRecord();
            record.setDate(date);

            // Dummy alternating presence
            if (i % 5 == 0) {
                record.setStatus("Leave");
                record.setNote("Approved Leave");
            } else if (i % 4 == 0) {
                record.setStatus("Absent");
                record.setNote("No show");
            } else {
                record.setStatus("Present");
                record.setInTime(LocalTime.of(9, 0));
                record.setOutTime(LocalTime.of(17, 0));
                record.setTotalHours(Duration.between(record.getInTime(), record.getOutTime()));
                record.setNote("Normal working day");
            }

            records.add(record);
        }

        return records;
    }


    public LeaveSummary getLeaveSummaryForEmployee(Long employeeId) {
        LeaveSummary summary = new LeaveSummary();
        summary.setTotalAnnualLeaves(12);
        summary.setTotalCasualLeaves(8);
        summary.setUsedCasualLeaves(3);
        summary.setUsedAnnualLeaves(5);

        // add leave records if needed
        return summary;
    }

    public List<Holiday> getUpcomingHolidays() {
        // Sample upcoming holidays
        return List.of(
                Holiday.builder().date(LocalDate.of(2025, 5, 1)).name("Labour Day").build(),
                Holiday.builder().date(LocalDate.of(2025, 5, 10)).name("Eid Day 1").build()
        );
    }


    public long getLeavesThisMonth() {
        return 10;

    }

    public List<AttendanceRecord> getAllAttendance() {
        return List.of(
                new AttendanceRecord(LocalDate.of(2025, 4, 1), "Present", LocalTime.of(9, 0), LocalTime.of(17, 0), Duration.ofHours(8), null, "Ali Khan"),
                new AttendanceRecord(LocalDate.of(2025, 4, 4), "Leave", null, null, Duration.ZERO, "Casual leave", "Ali Khan")
        );
    }



    public List<AttendanceRecord> getByEmployee(Long employeeId) {
        if (!employeeId.equals(1L)) {
            return Collections.emptyList();
        }

        return List.of(
                new AttendanceRecord(LocalDate.of(2025, 4, 1), "Present", LocalTime.of(9, 0), LocalTime.of(17, 0), Duration.ofHours(8), null, "Ali Khan"),
                new AttendanceRecord(LocalDate.of(2025, 4, 4), "Leave", null, null, Duration.ZERO, "Casual leave", "Ali Khan")
        );
    }




    public void markAttendance(Long employeeId, String status, String inTime, String outTime) {
    }

    public List<AttendanceSummary> getMonthlySummary() {
        // Dummy data for now
        return List.of(
                new AttendanceSummary("Ali Khan", 30, 25, 3, 2),
                new AttendanceSummary("Sara Ahmed", 30, 27, 2, 1)
        );
    }

}
