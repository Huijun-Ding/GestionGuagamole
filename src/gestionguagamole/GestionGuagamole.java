package gestionguagamole;

import java.sql.SQLException;

import BD.*;
import Controler.ControlerInterface;
import Vue.Connexion;

public class GestionGuagamole {

    public static void main(String[] args) throws SQLException {
    	ControlerInterface controler = new ControlerInterface();
        Query query = new Query();
        Connexion c1 = new Connexion(controler);
        BDconfig.getConnection();
        
      for (int i = 0; i < query.afficherNomTP("1","2020-11-12").size(); i++) {
            System.out.println(query.afficherNomTP("1","2020-11-12").get(i));
        }
    }
    
}
