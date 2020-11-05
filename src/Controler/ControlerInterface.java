package Controler;

import Model.*;
import Vue.*;

import java.util.ArrayList;

import BD.*;


public class ControlerInterface {
	private Query query;
	public ControlerInterface() {
		this.query = new Query();
	}
	
    public Utilisateur connexion(int id, String mdp, int i) {
    	Utilisateur user = query.connexionUilisateur(id, mdp, i);
    	if(user!=null) {
    		if(user instanceof AdminMateriel) {
    			AdminMateriel am = (AdminMateriel) query.connexionUilisateur(id, mdp, i);
        		return am;
    		}
    		if(user instanceof AdminRespoF) {
    			AdminRespoF ar = (AdminRespoF) query.connexionUilisateur(id, mdp, i);
    			return ar;
    		}
    	}
    	return null;
    }
    
    public ArrayList<Salle> getListeSalle() {
    		return query.gestionSalle();
    }
    
    public void supprimerSalle(String nom) {
    	query.supprimerSalle(nom);
    }

	public void ajouterSalle(int numS, String nomS) {
		query.ajouterSalle(numS, nomS);
		
	}
	
	public ArrayList<Machine> getListeMachine(int numSalle){
		return query.getListeMachine(numSalle);
	}


}
