package com.example.pointage;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

public class Calendar {
    private List<LocalDate> holidays;
    private List<WorkDay> workDays;

    public Calendar(List<LocalDate> holidays) {
        this.holidays = holidays;
    }

    public boolean isHoliday(LocalDate date) {
        return holidays.contains(date);
    }

    public void addWorkDay(WorkDay workDay) {
        workDays.add(workDay);
    }

    public List<WorkDay> getWorkDays() {
        return workDays;
    }
}