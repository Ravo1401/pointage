package employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JourDeTravail {
    private Date date;
    private int heuresTravailles;
    private boolean estDimanche;
    private boolean estVacance;
    private boolean estTravailDeNuit;

    public double calculeTauxHoraire(Categorie categorie) {
        double tauxHoraire = categorie.getTauxHoraire();
        if (estDimanche) {
            tauxHoraire *= 1.40;
        }
        if (estVacance) {
            tauxHoraire *= 1.50;
        }
        if (estTravailDeNuit) {
            tauxHoraire *= 1.30;
        }
        return tauxHoraire;
    }
}