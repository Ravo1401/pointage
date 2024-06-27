package com.example.pointage.employee;


import com.example.pointage.Calendar;
import com.example.pointage.Category;
import com.example.pointage.Salary;
import com.example.pointage.WorkDay;
import com.example.pointage.service.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Employee rakoto;
    private Employee rabe;
    private com.example.pointage.Calendar calendar;

    @BeforeEach
    public void setUp() {
        // Initialisation des employés Rakoto et Rabe
        rakoto = new Employee("Rakoto", "Rakoto", "001", new Date(), new Date(), null, 0, Category.GARDIEN, Arrays.asList(
                new WorkDay(LocalDate.of(2023, 6, 19), 8, false, false, false),
                new WorkDay(LocalDate.of(2023, 6, 20), 8, false, false, false)
        ));

        rabe = new Employee("Rabe", "Rabe", "002", new Date(), new Date(), null, 0, Category.GARDIEN, Arrays.asList(
                new WorkDay(LocalDate.of(2023, 6, 19), 8, false, false, false),
                new WorkDay(LocalDate.of(2023, 6, 20), 8, false, false, false)
        ));

        // Initialisation du calendrier
        calendar = new Calendar(Arrays.asList(
                LocalDate.of(2023, 12, 25),
                LocalDate.of(2024, 1, 1)
        ));
    }

    @Test
    public void testCalculateSalaryForRakoto() {
        Salary salary = Calculator.calculateSalary(rakoto, calendar);
        double expectedBrut = 100000 * (16.0 / 56); // 16 hours worked out of 56 normal hours per week
        double expectedNet = expectedBrut * 0.8;

        assertEquals(expectedBrut, salary.getBrut(), 0.001);
        assertEquals(expectedNet, salary.getNet(), 0.001);
    }

    @Test
    public void testCalculateSalaryForRabe() {
        Salary salary = Calculator.calculateSalary(rabe, calendar);
        double expectedBrut = 100000 * (16.0 / 56); // 16 hours worked out of 56 normal hours per week
        double expectedNet = expectedBrut * 0.8;

        assertEquals(expectedBrut, salary.getBrut(), 0.001);
        assertEquals(expectedNet, salary.getNet(), 0.001);
    }
}
