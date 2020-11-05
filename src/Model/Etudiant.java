package Model;

import java.util.ArrayList;

public class Etudiant extends Utilisateur{
    
    private Groupe groupe;

    private ArrayList<Reservation> mesReservation;
    
    public Etudiant(String num, String mdp, String nom, String prenom, Groupe p) {
        super(num, mdp, nom, prenom);
        this.groupe = p;
        this.mesReservation = new ArrayList<>();
        
    }
    
    public Groupe getGroupe() {
    	return groupe;
    }
    
    public ArrayList<Reservation> getMesReservation() {
		return mesReservation;
	}
    
    public void ajouterReservation(Reservation res) {
    	mesReservation.add(res);
    }
    
    public void annulerReservation(Reservation res) {
    	if(mesReservation.contains(res)) {
    		mesReservation.remove(res);
    	}
    }

    public void modifierReservation(Reservation res,Calendrier cal) {
    	if(mesReservation.contains(res)) {
    		//changer date et creneau
    		res.setCalendrierR(cal);
    	}
    
    }
    
}
    

