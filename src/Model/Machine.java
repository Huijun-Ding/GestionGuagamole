package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Machine {
    private String nomMachine;
    private Salle salle;
    private ArrayList<Reservation> reservations;
	private HashMap<Calendrier,Boolean> etatMachine ;
    
    public Machine(String num, Salle s) {
        this.nomMachine = num;
        this.salle = s;
        this.etatMachine= new HashMap<Calendrier,Boolean>();
        this.reservations = new ArrayList<>();
    }
    
    public ArrayList<Reservation> getReservations() {
		return reservations;
	}
    
    public String getNomMachine() {
    	return nomMachine;
    }   
        
}



