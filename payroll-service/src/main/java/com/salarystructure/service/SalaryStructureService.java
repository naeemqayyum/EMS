package com.salarystructure.service;

import com.model.SalaryStructure;

import java.util.List;

public interface SalaryStructureService {
    List<SalaryStructure> getAll();
    SalaryStructure getByEmployeeId(Long employeeId);
    void save(SalaryStructure structure);
    void deleteByEmployeeId(Long employeeId);
}
