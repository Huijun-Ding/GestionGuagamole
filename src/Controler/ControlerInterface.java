package Controler;

import Model.*;
import Vue.*;

public class ControlerInterface {
	private Model model;
	
	public ControlerInterface() {
		this.model = new Model();
	}
	
    public AdminMateriel connexion(String id, String mdp, int i) {
    	
    	if(model.connexion(id, mdp, i)!=null) {   		
    		AdminMateriel am = model.connexion(id, mdp, i);
    		return am;
    	}
    	return null;
    }
}
