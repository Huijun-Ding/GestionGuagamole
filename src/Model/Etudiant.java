package Model;

import java.util.Date;

public class Etudiant extends Utilisateur{
    
    private Groupe groupe;
    
    public Etudiant(String num, String mdp, String nom, String prenom, Groupe p) {
        super(num, mdp, nom, prenom);
        this.groupe = p;
    }
    
    public Groupe getGroupe() {
    	return groupe;
    }
    

    public void annulerReservation(Reservation res) {
    	if(mesReservation.contains(res) ) {
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
