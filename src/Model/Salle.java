package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Salle {
    private int numSalle;
    private String nom;
    private int capaciteSalle;
    private HashMap<Calendrier,Boolean> etatSalle = new HashMap<Calendrier,Boolean>();
    private ArrayList<Machine> machines;
    
    public Salle(int num, String nom, int nb) {
        this.numSalle = num;
        this.nom=nom;
        this.capaciteSalle = nb;
        machines = new ArrayList();
    }
    
    public String getNomSalle() {
    	return this.nom;
    }
    public int getNumSalle() {
    	return this.numSalle;
    }
    
    public void setEtatSalle(Calendrier c, boolean etat) {

    }
    
    public void ajouterMachine(Machine m) {
        
    }
}
