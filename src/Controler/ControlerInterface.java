package Controler;

import Vue.*;
import java.util.ArrayList;
import BD.*;
import Model.*;

public class ControlerInterface {

	private Query query;
	private int idU=0;
	private int typeU=0;
	public ControlerInterface() {
		this.query = new Query();
	}
	public int getId() {
		return this.idU;
	}
	public int getType() {
		return this.typeU;
	}
	public void deconnexion() {
		idU=0;
		typeU=0;
	}
    public Utilisateur connexion(int id, String mdp, int i) {
    	Utilisateur user = query.connexionUilisateur(id, mdp, i);
    	if(user!=null) {
    		idU=id;
    		typeU=i;
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
    
    public String[] getNomPrenom(int id, int type) {
    	return query.getNomPrenom(id, type);
    }
    
    public ArrayList<Salle> getListeSalle() {
    		return query.gestionSalle();



    public void annulerReservation(Reservation res) {
        query.annulerReservation(res);
    }
    
    public void modifierReservation(Reservation res) {
    	query.modifierReservation(res);

    }
    
    public void ajouterReservation(Reservation res) {
    	query.ajouterReservation(res);
    }
        
    public Utilisateur connexion(String id, String mdp, int i) {
        Utilisateur user = query.connexionUilisateur(id, mdp, i);
        if (user != null) {
            if (user instanceof AdminMateriel) {
                AdminMateriel am = (AdminMateriel) query.connexionUilisateur(id, mdp, i);
                return am;
            }
            if (user instanceof AdminRespoF) {
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

    public ArrayList<Machine> getListeMachine(int numSalle) {
        return query.getListeMachine(numSalle);
    }

    public void supprimerMachine(String numMachine) {
        query.supprimerMachine(numMachine);
    }


	public ArrayList<Formation> getListeFormation(){
		return query.getListeFormation();
	}
	
	public ArrayList<Etudiant> getListEtudiant(String nomF){
		return query.getListEtudiant(nomF);
	}
	public void supprimerEtudaint(Etudiant stu) {
		query.supprimerEtudiant(stu);
		
	}

    public void ajouterMachine(String nomMachine, int idS) {
        query.ajouterMachine(nomMachine, idS);
    }

    public ArrayList<TP> getListReservation() {
        return query.getListReservation();
    }


}
