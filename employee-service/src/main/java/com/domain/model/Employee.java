package com.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String employeeCode;       // internal HR code
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
    private String employmentType;     // Full-Time, Part-Time, etc.
    private String joiningDate;
    private String employmentStatus;   // Active, On Leave, etc.
    private String probationEndDate;
    private String confirmationDate;
    private String contractEndDate;
    private String location;
    private String shiftTiming;
    private String totalExperience;
    private String experienceInCompany;
    private String experienceInDepartment;
    private String previousExperience;

    // 🔹 Primary bank account
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_bank_account_id")
    private BankAccount primaryBankAccount;

    // 🔹 Secondary accounts (owned by this employee)
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BankAccount> secondaryAccounts;

    // 🔹 Education records (owned by this employee)
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EducationRecord> educationList;

    // 🔹 Employee documents (owned by this employee)
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeDocument> documents;
}
