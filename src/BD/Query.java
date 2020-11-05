package BD;
import java.sql.*;
import java.util.ArrayList;

import Model.*;

public class Query {
	static Connection con;
    public Connection getConnection() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	try {
    		con=DriverManager.getConnection("jdbc:mysql:"+"//127.0.0.1:3306/guagamole","root","");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return con;
    }
	
    public Utilisateur connexionUilisateur(int id, String mdp, int i) {
		if(id==1234 && mdp.equals("1234")) {
			AdminMateriel a = new AdminMateriel(1234,"1234","Duan","Chengyu");
			return a;
		}		
    	Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	ResultSet res;
    	try {
    		String sql;
    		stmt=con.createStatement();
    		if(i==3) {
    			AdminRespoF ar;
    			sql="SELECT * FROM enseignant E, encadrer EN WHERE E.idEns=EN.idEns";
    			res=stmt.executeQuery(sql);
    			while(res.next()) {    				
    				int idEns = res.getInt("E.idEns");
    				String mdpEns = res.getString("E.mdpEns");
    				String nomEns = res.getString("E.nomEns");
    				String prenomEns = res.getString("E.prenomEns");
    				if(idEns==id && mdpEns.equals(mdp)) {
    				ar = new AdminRespoF(idEns,mdpEns,nomEns,prenomEns);
    				return ar;
    				}
    			}
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;   	
    }
    public ArrayList<Salle> gestionSalle(){
    	ArrayList<Salle> salle = new ArrayList<Salle>();
    	Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	ResultSet res;
    	try {
    		stmt=con.createStatement();
    		String sql = "SELECT * FROM salle S";
    		res=stmt.executeQuery(sql);
    		while(res.next()) {
    			int IdS = res.getInt("S.IdS");
    			String NomS = res.getString("S.NomS");
    			Salle s = new Salle(IdS,NomS,20);
    			salle.add(s);
    		}
    		return salle;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public void supprimerSalle(String nom) {
    	Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	try {
    		stmt=con.createStatement();
    		String sql = "DELETE FROM salle WHERE NomS='"+ nom+"'";
    		stmt.execute(sql);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

	public void ajouterSalle(int numS, String nomS) {
		Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	try {
    		stmt=con.createStatement();
    		String sql = "INSERT INTO `salle`(`IdS`, `NomS`) VALUES ("+numS+",'"+nomS+"')";
    		stmt.execute(sql);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    
	}

	public ArrayList<Machine> getListeMachine(int numSalle) {
		ArrayList<Machine> machine = new ArrayList<Machine>();
		Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	ResultSet res;
    	try {
    		stmt=con.createStatement();
    		String sql = "SELECT * FROM machine M, Salle S WHERE M.IdS=S.IdS and M.IdS="+numSalle;
    		res=stmt.executeQuery(sql);
    		while(res.next()) {
    			int idM = res.getInt("M.IdM");
    			String nomM = res.getString("M.NomM");
    			int idS = res.getInt("S.IdS");
    			String nomS = res.getString("S.NomS");
    			Salle s = new Salle(idS,nomS,20);
    			Machine m = new Machine(nomM,s);
    			machine.add(m);
    		}
    		return machine;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return null;
	}


	}
	
	
    

