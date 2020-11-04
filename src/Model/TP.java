package Model;

import java.util.Calendar;
import java.util.Date;

public class TP {
    private String nomTP;
    

	private int nbEtudiantsTP;
    private Calendrier calendrierTP;
    private Salle salle;
    private Enseignant enseignant;
    private Groupe groupe;
    
    public TP(String nom, int nb, Calendrier c, Salle s, Enseignant e, Groupe g) {
        this.nomTP = nom;
        this.nbEtudiantsTP = nb;
        this.calendrierTP = c;
        this.salle = s;
        this.enseignant = e;
        this.groupe = g;
    }

    public String getNomTP() {
		return nomTP;
	}
    
    public void supprimerTP() {
      
    }
    
    public void ajouterTP() {
        
    }

}
