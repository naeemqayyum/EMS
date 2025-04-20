package com.service;

import org.springframework.stereotype.Service;

@Service
public class PayrollService {
    public long getCurrentMonthTotal() {
        return 13322;
    }

    public long getPendingApprovals() {
        return 23;
    }
}
