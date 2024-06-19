package employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
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

    public double calculateSalaryNet() {
        return salaryBrut - salaryBrut * 0.20;
    }
}
