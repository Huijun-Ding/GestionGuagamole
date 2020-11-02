package Model;

import java.util.Calendar;
import java.util.Date;

public class TP {
    private String nomTP;
    private int nbEtudiantsTP;
    private Date dateTP;
    private Calendar heureDebTP;
    private Calendar heureFinTP;
    private Salle salle;
    private Enseignant enseignant;
    private Groupe groupe;
    
    public TP(String nom, int nb, Date d, Calendar deb, Calendar fin, Salle s, Enseignant e, Groupe g) {
        this.nomTP = nom;
        this.nbEtudiantsTP = nb;
        this.dateTP = d;
        this.heureDebTP = deb;
        this.heureFinTP = fin;
        this.salle = s;
        this.enseignant = e;
        this.groupe = g;
    }
}
