package Controler;

import Model.*;
import Vue.*;
import BD.*;


public class ControlerInterface {
	private Query query;
	public ControlerInterface() {
		this.query = new Query();
	}
	
    public Utilisateur connexion(int id, String mdp, int i) {
    	Utilisateur user = query.ConnexionUilisateur(id, mdp, i);
    	if(user!=null) {
    		if(user instanceof AdminMateriel) {
    			AdminMateriel am = (AdminMateriel) query.ConnexionUilisateur(id, mdp, i);
        		return am;
    		}
    		if(user instanceof AdminRespoF) {
    			AdminRespoF ar = (AdminRespoF) query.ConnexionUilisateur(id, mdp, i);
    			return ar;
    		}
    	}
    	return null;
    }
}
