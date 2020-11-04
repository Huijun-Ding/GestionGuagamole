package Controler;

import Model.*;
import Vue.*;

public class ControlerInterface {
	private Model model;
    public AdminMateriel connexion(String id, String mdp, int i) {
    	if(model.connexion(id, mdp, i)!=null) {   		
    		AdminMateriel am = model.connexion(id, mdp, i);
    		System.out.println(am);
    		return am;
    	}
    	return null;
    }
}
