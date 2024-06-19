package employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private String name;
    private int normalHoursPerWeek;
    private double normalSalaryPerWeek;
    private double indemnityRate;

    public double getHourlyRate() {
        return normalSalaryPerWeek / normalHoursPerWeek;
    }
}

