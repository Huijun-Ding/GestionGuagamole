package Controler;

import Vue.*;
import java.util.ArrayList;
import BD.*;
import Model.*;

public class ControlerInterface {

    private Query query;
    private String idU = null;
    private int typeU = 0;

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
        idU = null;
        typeU = 0;
    }

    public Utilisateur connexion(String id, String mdp, int i) {
        Utilisateur user = query.connexionUilisateur(id, mdp, i);
        if (user != null) {
            idU = id;
            typeU = i;
            
            if (user instanceof AdminMateriel) {
                AdminMateriel am = (AdminMateriel) query.connexionUilisateur(id, mdp, i);
                return am;
            }
            if (user instanceof AdminRespoF) {
                AdminRespoF ar = (AdminRespoF) query.connexionUilisateur(id, mdp, i);
                return ar;
            }
            if (user instanceof Etudiant) {
                Etudiant e = (Etudiant) query.connexionUilisateur(id, mdp, i);
                return e;
            }
            if (user instanceof Enseignant) {
                Enseignant ens = (Enseignant) query.connexionUilisateur(id, mdp, i);
                return ens;
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

    public void ajouterMachine(String nomMachine, int idS) {
        query.ajouterMachine(nomMachine, idS);
    }

    public ArrayList<TP> getListReservation() {
        return query.getListReservation();
    }
    
    public void ajouterTP(String nom) {
        query.ajouterTP(nom);
    }

    /*public String getDateTP(String nomTP) {
         return query.getDateTP(nomTP);
    }
    
    public String getCreneauTP(String nomTP) {
        return query.getCreneauTP(nomTP);
    }*/
}
