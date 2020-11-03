package Model;

import java.util.Date;

public class Reservation {
    private Date dateReservation;
    private Creneau creneauReservation;
    private Utilisateur utilisateur;
    private Machine machine;
    
    public Reservation(Date d, Creneau time, Utilisateur u, Machine m) {
        this.dateReservation = d;
        this.creneauReservation = time;
        this.utilisateur = u;
        this.machine = m;
    }
    
    public void finReservationMachine() {
        
    }
}
