package Model;


import java.util.Date;

public class Reservation {
    private Calendrier calendrierR;
    private Utilisateur utilisateur;
    private Machine machine;
    
    public Reservation(Date d, Calendrier c, Utilisateur u, Machine m) {
        this.calendrierR =  c;
        this.utilisateur = u;
        this.machine = m;
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
    

}
