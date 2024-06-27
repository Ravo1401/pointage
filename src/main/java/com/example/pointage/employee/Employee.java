package com.example.pointage.employee;

import com.example.pointage.Category;
import com.example.pointage.WorkDay;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    private String matricule;
    private Date birthDate;
    private Date hireDate;
    private Date endDate;
    private double salaryBrut;
    private Category category;
    private List<WorkDay> workDays;
}


