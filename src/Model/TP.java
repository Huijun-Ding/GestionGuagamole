package Model;

import java.util.Calendar;
import java.util.Date;

public class TP {
    private String nomTP;
    private int nbEtudiantsTP;
    private Date dateTP;
    private Creneau creneauTP;
    private Salle salle;
    private Enseignant enseignant;
    private Groupe groupe;
    
    public TP(String nom, int nb, Date d, Creneau c, Salle s, Enseignant e, Groupe g) {
        this.nomTP = nom;
        this.nbEtudiantsTP = nb;
        this.dateTP = d;
        this.creneauTP = c;
        this.salle = s;
        this.enseignant = e;
        this.groupe = g;
    }
    

}
