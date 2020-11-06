package BD;
import java.sql.*;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDconfig {

    static final String DB_URL = "jdbc:mysql://localhost:3306/guacamole_db";
    static final String USER = "root";
    static final String PASS = "";
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connexion BD réussit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
	
	

