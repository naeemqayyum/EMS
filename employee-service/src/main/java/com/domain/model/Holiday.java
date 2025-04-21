package com.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Holiday {
    private LocalDate date;
    private String name;
}
