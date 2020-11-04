package Controler;

import Model.*;

public class ControlerInterface {
    private Etudiant etu; 
    
    public ControlerInterface(Etudiant modelEtu) {
    	this.etu = modelEtu;
    }
    
    public void annulerReservation(Reservation res) {
    	etu.annulerReservation(res);
    }
    
    public void modifierReservation(Reservation res, Calendrier cal) {
    	etu.modifierReservation(res, cal);
    }
}
