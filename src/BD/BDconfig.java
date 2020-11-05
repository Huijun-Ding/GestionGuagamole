package BD;

import java.sql.*;

public class BDconfig {

    static final String DB_URL = "jdbc:mysql://localhost:3306/guagamole";
    static final String USER = "root";
    static final String PASS = "";
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
