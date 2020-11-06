package Model;

import java.util.ArrayList;

public class Utilisateur {

    private String numU;
    private String mdpU;
    private String nomU;
    private String prenomU;

    public Utilisateur(String num, String mdp, String nom, String prenom) {
        this.numU = num;
        this.mdpU = mdp;
        this.nomU = nom;
        this.prenomU = prenom;
    }
    
    public String getNumU() {
        return this.numU;
    }
}
