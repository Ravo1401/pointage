package com.example.pointage;


public enum Category {
    GARDIEN("Gardien", 56, 100000, 0.1),
    CADRE_SUPERIEUR("Cadre supérieur", 40, 150000, 0.2),
    NORMAL("Normal", 40, 100000, 0.1),
    CHAUFFEUR("Chauffeur", 40,120000, 0.1);

    private String name;
    private int normalHoursPerWeek;
    private double salaryPerWeek;
    private double indemnityRate;

    Category(String name, int normalHoursPerWeek, double salaryPerWeek, double indemnityRate) {
        this.name = name;
        this.normalHoursPerWeek = normalHoursPerWeek;
        this.salaryPerWeek = salaryPerWeek;
        this.indemnityRate = indemnityRate;
    }

    public String getName() {
        return name;
    }

    public int getNormalHoursPerWeek() {
        return normalHoursPerWeek;
    }

    public double getSalaryPerWeek() {
        return salaryPerWeek;
    }

    public double getIndemnityRate() {
        return indemnityRate;
    }
}