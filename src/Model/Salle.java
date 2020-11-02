package Model;

import java.util.ArrayList;

public class Salle {
    private String numSalle;
    private int capaciteSalle;
    private boolean etatSalle;
    private ArrayList<Machine> machines;
    
    public Salle(String num, int nb) {
        this.numSalle = num;
        this.capaciteSalle = nb;
        this.etatSalle = false;
        machines = new ArrayList();
    }
    
    public void ajouterMachine(Machine m) {
        
    }
}
