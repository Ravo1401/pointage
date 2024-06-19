package employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    private String nom;
    private int heuresNormalesParSemaine;
    private double salaireNormalesParSemaine;
    private double tauxIndemnisation;

    public double getTauxHoraire() {
        return salaireNormalesParSemaine/ heuresNormalesParSemaine;
    }
}

