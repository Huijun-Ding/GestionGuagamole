package Model;

import java.util.Date;

public class Reservation {
    private Date dateReservation;
    private Calendrier calendrierR;
    private Utilisateur utilisateur;
    private Machine machine;
    
    public Reservation(Date d, Calendrier c, Utilisateur u, Machine m) {
        this.dateReservation = d;
        this.calendrierR =  c;
        this.utilisateur = u;
        this.machine = m;
    }
}
