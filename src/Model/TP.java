package Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TP {

    private String nomTP;
    private Calendrier calendrierTP;
    private Salle salle;
    private Enseignant enseignant;
    private Groupe groupe;

    public TP(String nom, Calendrier c, Salle s, Enseignant e, Groupe g) {
        this.nomTP = nom;
        this.calendrierTP = c;
        this.salle = s;
        this.enseignant = e;
        this.groupe = g;
        // ajouter dans la BD

    }

    public String getNomTP() {
        return nomTP;
    }

    public void supprimerTP() {
        //supprimer de la BD

    }
    
    public int consulterRessource() {
        int nbPresent = 0;
        
        for (int i = 0; i < this.groupe.getEtudiants().size(); i++) {
            // pour chaqu'un de ces étudiants dans la liste, vérfier si il a réservé pour ce TP ou pas
            for (int j = 0; i < this.groupe.getEtudiants().get(i).getMesReservation().size(); i++) { 
                if (this.groupe.getEtudiants().get(i).getMesReservation().get(j).getTP() == this) {
                    nbPresent += 1;
                }
            }   
        }
        
        return nbPresent;
    }
}
