package Controler;

import Model.*;
import BD.*;

public class ControlerInterface {
    private Etudiant etu; 
    
    public ControlerInterface(Etudiant modelEtu) {
    	this.etu = modelEtu;
    }
    
    public void annulerReservation(Reservation res) {
    	etu.annulerReservation(res);
    }
    
    public void modifierReservation(Reservation res) {
    	etu.modifierReservation(res);
    }
    
    public void ajouterReservation(Reservation res) {
    	etu.ajouterReservation(res);
    }
}
