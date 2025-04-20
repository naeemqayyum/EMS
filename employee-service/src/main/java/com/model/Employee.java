package com.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private long employeeId;
    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private String salary;
    private String department;

    // Personal Info
    private String email;
    private String phone;
    private String gender;
    private String dob;
    private String cnic;
    private String maritalStatus;
    private String emergencyContact;

    // Employment Info
    private String designation;
    private String managerName;
    private String employmentType; // Full-Time, Part-Time, Contract, etc.
    private String joiningDate;    // format as yyyy-MM-dd
    private String employmentStatus; // Active, On Leave, Terminated, etc.

    // Bank Details (simplified)
    private BankAccount primaryBankAccount;
    private List<BankAccount> secondaryAccounts;
    private String probationEndDate;   // optional
    private String confirmationDate;   // optional
    private String employeeCode;       // internal HR code
    private String location;           // office/branch location
    private String shiftTiming;        // e.g., 9am - 6pm
    private String contractEndDate;    // if contractual
    private String totalExperience;
    private String experienceInCompany;
    private String experienceInDepartment;
    private List<EducationRecord> educationList;
    private List<EmployeeDocument> documents;
    private String previousExperience;        // e.g., "3 years at ABC Corp"


}
