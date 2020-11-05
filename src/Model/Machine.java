package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Machine {
    private String numMachine;
    private Salle salle;
    private ArrayList<Reservation> reservations;
	private HashMap<Calendrier,Boolean> etatMachine ;
    
    public Machine(String num, Salle s) {
        this.numMachine = num;
        this.salle = s;
        this.etatMachine= new HashMap<Calendrier,Boolean>();
        this.reservations = new ArrayList<>();
    }
    
    public ArrayList<Reservation> getReservations() {
		return reservations;
	}
    public String getNumMachine() {
    	return numMachine;
    }
	
}