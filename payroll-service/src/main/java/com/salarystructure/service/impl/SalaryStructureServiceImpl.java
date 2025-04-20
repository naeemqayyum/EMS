package com.salarystructure.service.impl;

import com.model.SalaryStructure;
import com.salarystructure.service.SalaryStructureService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SalaryStructureServiceImpl implements SalaryStructureService {

    private final Map<Long, SalaryStructure> structureMap = new HashMap<>();

    @Override
    public List<SalaryStructure> getAll() {
        return new ArrayList<>(structureMap.values());
    }

    @Override
    public SalaryStructure getByEmployeeId(Long employeeId) {
        return structureMap.get(employeeId);
    }

    @Override
    public void save(SalaryStructure structure) {
        structureMap.put(structure.getEmployeeId(), structure);
    }

    @Override
    public void deleteByEmployeeId(Long employeeId) {
        structureMap.remove(employeeId);
    }
}
