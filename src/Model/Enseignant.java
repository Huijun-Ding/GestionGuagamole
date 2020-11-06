package Model;

import java.util.ArrayList;

public class Enseignant extends Utilisateur{
  
    private ArrayList<TP> TPs;
    
    public Enseignant(String num, String mdp, String nom, String prenom) {
        super(num, mdp, nom, prenom);
        TPs = new ArrayList();
    }    
    
    public void supprimerTP() {
        
    }
    
    public void ajouterTP() {
        
    }
}
