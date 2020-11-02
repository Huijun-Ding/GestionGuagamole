package Model;

import java.util.ArrayList;

public class Machine {
    private String numMachine;
    private boolean etatMachine;
    private Salle salle;
    private ArrayList<Reservation> reservations;
    
    public Machine(String num, Salle s) {
        this.numMachine = num;
        this.etatMachine = false;
        this.salle = s;
        reservations = new ArrayList();
    }
}
