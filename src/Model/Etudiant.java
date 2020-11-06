package Model;

public class Etudiant extends Utilisateur{
    
    private Groupe groupe;
    
    String nom;
    String prenom;
    
    public Etudiant(String num, String mdp, String nom, String prenom, Groupe p) {
        super(num, mdp, nom, prenom);
        this.groupe = p;
    }
    
    public String getNomE() {
    	return super.nomU;
    }
    
    public String getPrenomE() {
    	return super.prenomU;
    }
    
    public String getNumE() {
    	return super.numU;
    }
    public String getMdpE() {
    	return super.mdpU;
    }
    public Groupe getGroupe() {
    	return this.groupe;
    }
}
