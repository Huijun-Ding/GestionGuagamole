package Model;

import java.util.ArrayList;

public class Utilisateur {
    private int numU;
    private String mdpU;
    protected String nomU;
    protected String prenomU;
    private ArrayList<Reservation> mesReservation;
    
    public Utilisateur(int num, String mdp, String nom, String prenom) {
        this.numU = num;
        this.mdpU = mdp;
        this.nomU = nom;
        this.prenomU = prenom;
        mesReservation = new ArrayList();
    }
}
