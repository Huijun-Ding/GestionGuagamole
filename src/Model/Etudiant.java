package Model;

public class Etudiant extends Utilisateur{
    
    private Groupe groupe;
    
    public Etudiant(int num, String mdp, String nom, String prenom, Groupe p) {
        super(num, mdp, nom, prenom);
        this.groupe = p;
    }
}
