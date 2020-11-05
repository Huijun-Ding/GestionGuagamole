package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDconfig {

	/*Connexion à la base de données guacamole_bd*/
	String url = "jdbc:mysql://localhost:3306/guacamole_db";
	String login = "root";
	String mdp = "";
	Connection con;
	PreparedStatement sql;
	ResultSet res;
	
	public Connection getConnection() {
		 /* Chargement du driver JDBC pour MySQL */
	    try {
	        Class.forName( "com.mysql.jdbc.Driver" );
	    } catch ( ClassNotFoundException e ) {
	    	e.printStackTrace();
	    }
	    //Connexion à la BD
		try {
		    con = DriverManager.getConnection( url, login, mdp );
		   
		} catch ( SQLException e ) {
			e.printStackTrace();	
		}
	return con;
	}
		
}
	
	

