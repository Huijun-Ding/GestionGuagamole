package BD;

import java.sql.*;

public class BDconfig {
    static final String DB_URL = "jdbc:mysql://localhost:3306/guacamole?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "000000";
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
