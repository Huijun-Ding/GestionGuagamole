package gestionguagamole;

import BD.*;
import Controler.ControlerInterface;
import Vue.Connexion;

public class GestionGuagamole {

    public static void main(String[] args) {
        ControlerInterface controler = new ControlerInterface();
        Query query = new Query();
        Connexion c1 = new Connexion(controler); 
    }
    
}