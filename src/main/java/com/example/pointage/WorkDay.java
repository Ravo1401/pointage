package com.example.pointage;

import lombok.AllArgsConstructor;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class WorkDay {
    private LocalDate date;
    private int hoursWorked;
    private boolean isNight;
    private boolean isSunday;
    private boolean isHoliday;
}
