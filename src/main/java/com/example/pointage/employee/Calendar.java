package com.example.pointage.employee;

import java.util.Date;
import java.util.List;

public class Calendar {
    private List<Date> holidays;

    public Calendar(List<Date> holidays) {
        this.holidays = holidays;
    }

    public boolean isHoliday(Date date) {
        return holidays.contains(date);
    }
}
