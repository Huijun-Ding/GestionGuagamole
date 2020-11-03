package Controler;

import Model.Model;
import Vue.*;

public class ControlerInterface {
	private Model model;
    public void connexion(String id, String mdp, int i) {
    	if(!model.connexion(id, mdp, i)) {
    		Connexion c = new Connexion();
    	}if(model.connexion(id, mdp, i)) {
    		if(i==3) {
    			HomePageAdminM am = new HomePageAdminM();
    		}
    	}
    }
}
