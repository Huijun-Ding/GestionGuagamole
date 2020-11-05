package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDconfig {
	String url;
	String login;
	String mdp;
	Connection connexion;
	
	public BDconfig(String urlBD, String utilisateurBD, String password, Connection connexion) {
		this.url = urlBD;
		this.login = utilisateurBD;
		this.mdp = password;
		this.connexion = connexion;
	
	/*Connexion à la base de données guacamole_bd*/
	 url = "jdbc:mysql://localhost:3306/guacamole_db";
	 login = "root";
	 mdp = "";
	connexion= null;
	
		try {
		    connexion = DriverManager.getConnection( url, login, mdp );
		    /*Requêtes vers la bd*/
		   
		} catch ( SQLException e ) {
		    /* Gérer les éventuelles erreurs ici */
			
		} finally {
		    if ( connexion != null )
		        try {
		            /* Fermeture de la connexion */
		            connexion.close();
		        } catch ( SQLException ignore ) {
		            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
		        }
		}
	}
	
	
}
