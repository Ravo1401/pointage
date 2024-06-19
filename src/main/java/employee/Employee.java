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
    private String prenom;
    private String nom;
    private String matricule;
    private Date dateNaissance;
    private Date dateEmbauche;
    private Date dateFin;
    private double salaireBrute;
    private Categorie categorie;
    private List<JourDeTravail> jourDeTravail;

    public double calculeSalaireNet() {
        return salaireBrute - salaireBrute * 0.20;
    }
}
