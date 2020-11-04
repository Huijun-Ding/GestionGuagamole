package BD;
import java.sql.*;
public class BDconfig {
    Connection con;
    public Connection getConnection() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	try {
    		con=DriverManager.getConnection("jdbc:mysql:"+"//127.0.0.1:3306/gestionguagamole","root","");
    		System.out.println("success");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return con;
    }
    public static void main(String[] args) {
    	BDconfig c = new BDconfig();
    	c.getConnection();
    }
}
