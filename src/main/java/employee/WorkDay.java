package employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkDay{
    private Date date;
    private int hoursWorked;
    private boolean isSunday;
    private boolean isHoliday;
    private boolean isNightWork;

    public double calculateHourlyRate(Category category) {
        double hourlyRate = category.getHourlyRate();
        if (isSunday) {
            hourlyRate *= 1.40;
        }
        if (isHoliday) {
            hourlyRate *= 1.50;
        }
        if (isNightWork) {
            hourlyRate *= 1.30;
        }
        return hourlyRate;
    }
}