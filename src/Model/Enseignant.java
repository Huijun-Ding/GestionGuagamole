package Model;

import java.util.ArrayList;

public class Enseignant extends Utilisateur{
  
    private ArrayList<TP> tps;
    
    public Enseignant(String num, String mdp, String nom, String prenom) {
        super(num, mdp, nom, prenom);
        tps = new ArrayList();
    }    
    
    public Enseignant() {}
    
    public void supprimerTPs(TP e) {
        this.tps.remove(e);
        e.supprimerTP();
    }

    public void ajouterTPs(TP e) {
        this.tps.add(e);
    }

}
