package BD;
import java.sql.*;

import Model.AdminRespoF;
public class BDconfig {
    static Connection con;
    public Connection getConnection() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	try {
    		con=DriverManager.getConnection("jdbc:mysql:"+"//127.0.0.1:3306/guagamole","root","");
    		System.out.println("success");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return con;
    }
 
}
