package Model;

import java.util.ArrayList;

import java.util.HashMap;

public class Salle {

    private String nomSalle;
    private int numSalle;
    private int capaciteSalle;
    private HashMap<Calendrier, Boolean> etatSalle;
    private ArrayList<Machine> machines;

    public Salle(int num, String nom, int nb) {
        this.numSalle = num;
        this.nomSalle=nom;
        this.capaciteSalle = nb;
        this.etatSalle = new HashMap<Calendrier, Boolean>();
        this.machines = new ArrayList<>();
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public int getNumSalle() {
    	return this.numSalle;
    }

    public void setEtatSalle(Calendrier c, boolean etat) {
        this.etatSalle.put(c, etat);
    }

    public void ajouterMachine(Machine m) {
        this.machines.add(m);
    }

    public void supprimerMachine(Machine m) {
        this.machines.remove(m);
    }
    
    public int getCapaciteSalle() {
        return this.capaciteSalle;
    }
}
