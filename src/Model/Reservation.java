package Model;

import java.util.Date;

public class Reservation {

    private Calendrier calendrierR;
    private Utilisateur utilisateur;
    private Machine machine;
    private TP tp;

    public Reservation(Calendrier c, Utilisateur u, Machine m) {
        this.calendrierR = c;
        this.utilisateur = u;
        this.machine = m;
    }

    public Reservation(Calendrier c, Utilisateur u, Machine m, TP tp) {
        this.calendrierR = c;
        this.utilisateur = u;
        this.machine = m;
        this.tp = tp;
    }

    public Utilisateur getUtilisateur() {
    	return utilisateur;
    }
	public Calendrier getCalendrierR() {
		return calendrierR;
	}


    public void setCalendrierR(Calendrier calendrierR) {
        this.calendrierR = calendrierR;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public TP getTP() {
        return this.tp;
    }
}
