package Controler;

import Model.*;
import Vue.*;

import java.util.ArrayList;

import BD.*;


public class ControlerInterface {
	private Query query;
	private String idU=null;
	private int typeU=0;
	public ControlerInterface() {
		this.query = new Query();
	}
	public String getId() {
		return this.idU;
	}
	public int getType() {
		return this.typeU;
	}
	public void deconnexion() { 
		idU=null;
		typeU=0;
	}
	public Utilisateur connexion(String id, String mdp, int i) {
        Utilisateur user = query.connexionUilisateur(id, mdp, i);
            idU = id;
            typeU = i;
            
            if (i==4) {
                AdminMateriel am = (AdminMateriel) query.connexionUilisateur(id, mdp, i);
                return am;
            }
            if (i==3) {
                AdminRespoF ar = (AdminRespoF) query.connexionUilisateur(id, mdp, i);
                return ar;
            }
            if (i==1) {
                Etudiant e = (Etudiant) query.connexionUilisateur(id, mdp, i);
                return e;
            }
            if (i==2) {
                Enseignant ens = (Enseignant) query.connexionUilisateur(id, mdp, i);
                return ens;
                      
        }
        return null;
    }
    
    public String[] getNomPrenom(String id, int type) {
    	return query.getNomPrenom(id, type);
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

	public void supprimerMachine(String numMachine) {
		query.supprimerMachine(numMachine);
		
	}

	public void ajouterMachine(String nomMachine, int idS) {
		query.ajouterMachine(nomMachine, idS);
		
	}
	
	public ArrayList<TP> getListReservation(){
		return query.getListReservation();
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
	public ArrayList<Groupe> getListeGroupe() {
		return query.getListGroupe();
	}
	public void ajouterEtudiant(Etudiant etu) {
		query.ajouterEtudiant(etu);
	}
	public void supprimerGroupe(int numG) {
		query.supprimerGroupe(numG);
	}
	public void ajouterGroupe(Groupe g) {
		query.ajouterGroupe(g);	
	}
}