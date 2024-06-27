package com.example.pointage.employee;

import com.example.pointage.Calendar;
import com.example.pointage.Category;
import com.example.pointage.Salary;
import com.example.pointage.WorkDay;
import com.example.pointage.service.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {
    private Employee rakoto;
    private Employee rabe;
    private com.example.pointage.Calendar calendar;

    @BeforeEach
    public void setUp() {
        // Création de la liste des jours de travail pour Rakoto et Rabe
        List<WorkDay> rakotoWorkDays = new ArrayList<>();
        List<WorkDay> rabeWorkDays = new ArrayList<>();

        LocalDate startDate = LocalDate.of(2023, 5, 26);
        LocalDate endDate = LocalDate.of(2023, 7, 6);

        // Ajouter les jours de travail pour les 6 semaines
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            rakotoWorkDays.add(new WorkDay(date, 10, false, date.getDayOfWeek() == java.time.DayOfWeek.SUNDAY, false));
            rabeWorkDays.add(new WorkDay(date, 14, true, date.getDayOfWeek() == java.time.DayOfWeek.SUNDAY, false));
        }

        // Initialisation des employés Rakoto et Rabe
        rakoto = new Employee("Rakoto", "Rakoto", "001", new Date(), new Date(), null, 0, Category.GARDIEN, rakotoWorkDays);
        rabe = new Employee("Rabe", "Rabe", "002", new Date(), new Date(), null, 0, Category.GARDIEN, rabeWorkDays);

        // Initialisation du calendrier
        calendar = new Calendar(Arrays.asList(
                LocalDate.of(2023, 12, 25),
                LocalDate.of(2024, 1, 1)
        ));
    }

    @Test
    public void testWorkDaysAndHoursForRakoto() {
        // Vérification des jours de travail
        int expectedDays = 42;
        int actualDays = rakoto.getWorkDays().size();
        assertEquals(expectedDays, actualDays);

        // Vérification des heures de travail
        int expectedHours = 420;
        int actualHours = rakoto.getWorkDays().stream().mapToInt(WorkDay::getHoursWorked).sum();
        assertEquals(expectedHours, actualHours);
    }

    @Test
    public void testWorkDaysAndHoursForRabe() {
        // Vérification des nuits de travail
        int expectedNights = 42;
        int actualNights = rabe.getWorkDays().size();
        assertEquals(expectedNights, actualNights);

        // Vérification des heures de travail
        int expectedHours = 588;
        int actualHours = rabe.getWorkDays().stream().mapToInt(WorkDay::getHoursWorked).sum();
        assertEquals(expectedHours, actualHours);
    }

    @Test
    public void testCalculateSalaryForRakoto() {
        Salary salary = Calculator.calculateSalary(rakoto, calendar);
        double expectedBrut = 100000 * (420.0 / 56); // 420 hours worked out of 56 normal hours per week
        double expectedNet = expectedBrut * 0.8;

        assertEquals(expectedBrut, salary.getBrut(), 0.001);
        assertEquals(expectedNet, salary.getNet(), 0.001);
    }

    @Test
    public void testCalculateSalaryForRabe() {
        Salary salary = Calculator.calculateSalary(rabe, calendar);
        double expectedBrut = 100000 * (588.0 / 56) * 1.3; // 588 hours worked out of 56 normal hours per week, with night shift multiplier
        double expectedNet = expectedBrut * 0.8;

        assertEquals(expectedBrut, salary.getBrut(), 0.001);
        assertEquals(expectedNet, salary.getNet(), 0.001);
    }
}
