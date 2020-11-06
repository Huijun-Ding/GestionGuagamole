package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Machine {
    private String numMachine;
    private Salle salle;
    private ArrayList<Reservation> reservations;
    private HashMap<Calendrier,Boolean> etatMachine = new HashMap<Calendrier,Boolean>();
    
    public Machine(String num, Salle s) {
        this.numMachine = num;
        this.salle = s;
        reservations = new ArrayList();
    }
    
    public String getNomMachine() {
    	return this.numMachine;
    }
    
    public String getNumM() {
    	return this.numMachine;
    }
}
