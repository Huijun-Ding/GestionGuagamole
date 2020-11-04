package Model;

public class Etudiant extends Utilisateur{
    
    public int numG;
    
    public Etudiant(String num, String mdp, String nom, String prenom, int p) {
        super(num, mdp, nom, prenom);
        this.numG = p;
    }
}

