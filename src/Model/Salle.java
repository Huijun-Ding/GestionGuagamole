package Model;

import java.util.ArrayList;

import java.util.HashMap;


public class Salle {
    private String numSalle;
    private int capaciteSalle;
    private HashMap<Calendrier,Boolean> etatSalle;
    private ArrayList<Machine> machines;
    
    public Salle(String num, int nb) {
        this.numSalle = num;
        this.capaciteSalle = nb;
        this.etatSalle = new HashMap<Calendrier,Boolean>();
        this.machines = new ArrayList<>();
    }
    
    
    public String getNumSalle() {
		return numSalle;
	}

	public void setEtatSalle(Calendrier c, boolean etat) {

    }
    
    public void ajouterMachine(Machine m) {
        
    }
}
