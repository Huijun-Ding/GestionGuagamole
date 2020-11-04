package gestionguagamole;

import Controler.ControlerInterface;
import Model.Model;
import Vue.Connexion;

public class GestionGuagamole {

    public static void main(String[] args) {
        ControlerInterface controler = new ControlerInterface();
        Model model = new Model();
        Connexion c1 = new Connexion(controler);
    }
    
}
