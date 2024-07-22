package com.example.pointage.employee;

import com.example.pointage.Calendar;
import com.example.pointage.Category;
import com.example.pointage.Salary;
import com.example.pointage.WorkDay;
import com.example.pointage.service.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculTest {
    private static final Logger log = LoggerFactory.getLogger(CalculTest.class);
    private Employee rakoto;
    private Employee rabe;
    private Calendar calendar;

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
        // Vérification du salaire pour Rakoto
        Salary salary = Calculator.calculateSalary(rakoto, calendar);
        double expectedBrut = 100000 * 6; // 6 semaines de travail normal
        double expectedNet = expectedBrut * 0.8;
        log.info("" + expectedBrut);
        assertEquals(expectedBrut, salary.getBrut(), 0.001);
        assertEquals(expectedNet, salary.getNet(), 0.001);
    }

    @Test
    public void testCalculateSalaryForRabe() {
        // Vérification du salaire pour Rabe
        Salary salary = Calculator.calculateSalary(rabe, calendar);
        double expectedBrut = 100000 * 6 * 1.3; // 6 semaines de travail de nuit avec majoration de 30%
        double expectedNet = expectedBrut * 0.8;
        log.info("" + expectedBrut);
        assertEquals(expectedBrut, salary.getBrut(), 0.001);
        assertEquals(expectedNet, salary.getNet(), 0.001);
    }
}

