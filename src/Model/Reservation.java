package Model;

import java.util.Calendar;
import java.util.Date;

public class Reservation {
    private Date dateReservation;
    private Calendar heureDebR;
    private Calendar heureFinR;
    private Utilisateur utilisateur;
    private Machine machine;
    
    public Reservation(Date d, Calendar deb, Calendar fin, Utilisateur u, Machine m) {
        this.dateReservation = d;
        this.heureDebR = deb;
        this.heureFinR = fin;
        this.utilisateur = u;
        this.machine = m;
    }
    
    public void finReservationMachine() {
        
    }
}
