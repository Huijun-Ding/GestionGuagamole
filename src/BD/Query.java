package BD;

import Model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
	

		String url = "jdbc:mysql://localhost:3306/guacamole_db";
		String login = "root";
		String mdp = "";
		Connection connexion= null;
		Statement stat = null;
		ResultSet resultat = null;
		
		public void afficherNomTP() {
			try {
			    connexion = DriverManager.getConnection( url, login, mdp );
			    /*Requêtes vers la bd*/
			   stat = connexion.createStatement();
			   //liste des noms de tps pour une date et un crénaeau donné, auquel le groupe de l'étudiant fait partie
			   resultat = stat.executeQuery("");
			   
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
