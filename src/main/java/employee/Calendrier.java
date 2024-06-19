package employee;

import java.util.Date;
import java.util.List;

public class Calendrier {
    private List<Date> vacances;

    public Calendrier(List<Date> vacances) {
        this.vacances = vacances;
    }

    public boolean Vacances(Date date) {
        return vacances.contains(date);
    }
}
