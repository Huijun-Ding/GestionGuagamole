package Model;

public class Utilisateur {

    protected String numU;
    protected String mdpU;
    protected String nomU;
    protected String prenomU;

    public Utilisateur(String num, String mdp, String nom, String prenom) {
        this.numU = num;
        this.mdpU = mdp;
        this.nomU = nom;
        this.prenomU = prenom;
    }

	public String getNumU() {
		return numU;
	}

}
