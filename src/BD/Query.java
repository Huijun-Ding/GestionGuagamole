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
	
    public Utilisateur connexionUilisateur(String id, String mdp, int i) {
//        if (id.equals("1234") && mdp.equals("1234")) {
//            AdminMateriel a = new AdminMateriel("1234", "1234", "Duan", "Chengyu");
//            return a;
//        }
        Query conn = new Query();
        con = conn.getConnection();
        Statement stmt;
        Statement stmt2;
        Statement stmt3;
        Statement stmt4;
        ResultSet res;
        try {
            String sql;
            stmt = con.createStatement();
            stmt2 = con.createStatement();
            stmt3 = con.createStatement();
            stmt4 = con.createStatement();
            if (i == 4) {
            	 AdminMateriel am;
                 sql = "SELECT * FROM superadmin";
                 res = stmt.executeQuery(sql);
                 while (res.next()) {
                     String idSA = res.getString("IdSA");
                     String mdpSA = res.getString("MdpSA");
                     String nomSA = res.getString("NomSA");
                     String prenomSA = res.getString("PrenomSA");
                     if (idSA.equals(id) && mdpSA.equals(mdp)) {
                         am = new AdminMateriel(idSA, mdpSA, nomSA, prenomSA);
                         return am;
                     }
                 }
            }
            if (i == 3) {
                AdminRespoF ar;
                sql = "SELECT * FROM enseignant E, encadrer EN WHERE E.IdEns=EN.IdEns";
                res = stmt2.executeQuery(sql);
                while (res.next()) {
                    String idEns = res.getString("E.IdEns");
                    String mdpEns = res.getString("E.MdpEns");
                    String nomEns = res.getString("E.NomEns");
                    String prenomEns = res.getString("E.PrenomEns");
                    if (idEns.equals(id) && mdpEns.equals(mdp)) {
                        ar = new AdminRespoF(idEns, mdpEns, nomEns, prenomEns);
                        return ar;
                    }
                }
            }
            if (i==2){
                Enseignant en;
                sql = "SELECT * FROM enseignant";
                res = stmt3.executeQuery(sql);
                while (res.next()) {
                    String idEns = res.getString("IdEns");
                    String mdpEns = res.getString("MdpEns");
                    String nomEns = res.getString("NomEns");
                    String prenomEns = res.getString("PrenomEns");
                    if (idEns.equals(id) && mdpEns.equals(mdp)) {
                        en = new Enseignant(idEns, mdpEns, nomEns, prenomEns);
                        return en;
                    }
                }
            }
            if (i==1) {
                Etudiant e;
                sql = "SELECT * FROM etudiant";
                res = stmt4.executeQuery(sql);
                while (res.next()) {
                    String idE = res.getString("IdE");
                    String mdpE = res.getString("MdpE");
                    String nomE = res.getString("NomE");
                    String prenomE = res.getString("PrenomE");
                    if (idE.equals(id) && mdpE.equals(mdp)) {
                        e = new Etudiant(idE, mdpE, nomE, prenomE,null);
                        return e;
                    }
                }
                res.close();
                stmt.close();
                con.close();
            }
        } catch (Exception e) {
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

	public void supprimerMachine(String numMachine) {
		Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	try {
    		stmt=con.createStatement();
    		String sql = "DELETE FROM machine WHERE NomM='"+ numMachine+"'";
    		stmt.execute(sql);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
	}

	public void ajouterMachine(String nomMachine, int idS) {
		Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	Statement stmt1;
    	ResultSet res;
    	try {
    		stmt=con.createStatement();
    		stmt1=con.createStatement();
    		String sql = "SELECT Max(M.IdM) as maxidm FROM machine M";
    		res=stmt.executeQuery(sql);
    		int numIdM=1;
    		while(res.next()) {
    			numIdM = res.getInt("maxidm");
    			numIdM+=1;
    		}
    		sql = "INSERT INTO machine(IdM, NomM, IdS) VALUES ("+numIdM+",'"+nomMachine+"',"+idS+")";
    		stmt1.execute(sql);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		
	}
	public Creneau getCreneauEnum(String date) {
		Creneau cre=null;
		if(date.equals("8h00-9h30")) {
			cre=Creneau.CRENEAU_8H00_9H30;
		}if(date.equals("9h30-11h00")) {
			cre=Creneau.CRENEAU_9H30_11H00;
		}if(date.equals("11h00-12h30")) {
			cre=Creneau.CRENEAU_11H00_12H30;
		}if(date.equals("12h30-14h00")) {
			cre=Creneau.CRENEAU_12H30_14H00;
		}if(date.equals("14h00-15h30")) {
			cre=Creneau.CRENEAU_14H00_15H30;
		}if(date.equals("15h30-17h00")) {
			cre=Creneau.CRENEAU_15H30_17H00;
		}if(date.equals("17h00-18h30")) {
			cre=Creneau.CRENEAU_17H00_18H30;
		}if(date.equals("18h30-20h00")) {
			cre=Creneau.CRENEAU_18H30_20H00;
		}
		return cre;
	}
	public ArrayList<TP> getListReservation() {
		ArrayList<TP> reservation = new ArrayList<TP>();
		Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	ResultSet res;
    	try {
    		stmt=con.createStatement();
    		Date dateRes;
    		String cres;
    		int idS;
    		String etatS;
    		Creneau cre;
    		String sql = "SELECT * FROM tp T, salle S WHERE S.IdS = T.IdS";
    		res = stmt.executeQuery(sql);
    		while(res.next()) {
    			dateRes = res.getDate("T.DateTP");
    			cres = res.getString("T.CreneauTP");
    			Salle s = new Salle(res.getInt("S.IdS"),res.getString("S.NomS"),20);
    			cre = getCreneauEnum(cres);
    			Calendrier cal = new Calendrier(cre, dateRes);
    			TP tp = new TP(null,0,cal,s,null,null);
    			reservation.add(tp);
    		}
    		return reservation;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return null;
	}
	public String[] getNomPrenom(String id, int type) {
		String[] nomprenom = new String[2];
		Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	ResultSet res;
    	try {
      		stmt=con.createStatement();
      		String sql;
      		if(type==1) {
      			sql="SELECT * FROM etudiant WHERE IdE="+id;
      			res=stmt.executeQuery(sql);
      			while(res.next()) {
      				String nom = res.getString("NomE");
      				String prenom = res.getString("PrenomE");
      				nomprenom[0]=nom;
      				nomprenom[1]=prenom;
      			}
      		}
      		if(type==2) {
      			sql="SELECT * FROM enseignant WHERE IdEns="+id;
      			res=stmt.executeQuery(sql);
      			while(res.next()) {
      				String nom = res.getString("NomEns");
      				String prenom = res.getString("PrenomEns");
      				nomprenom[0]=nom;
      				nomprenom[1]=prenom;
      			}
      		}
      		if(type==3) {
      			sql="SELECT Ucase(E.NomEns) as NomEns, E.PrenomEns FROM enseignant E, encadrer EN WHERE E.idEns=EN.idEns and E.IdEns="+id;
      			res=stmt.executeQuery(sql);
      			while(res.next()) {
      				String nom = res.getString("NomEns");
      				String prenom = res.getString("E.PrenomEns");
      				nomprenom[0]=nom;
      				nomprenom[1]=prenom;
      			}
      		}
      		if(type==4) {
      			sql="SELECT Ucase(NomSA) as NomSA, PrenomSA FROM superadmin WHERE IdSA="+id;
      			res=stmt.executeQuery(sql);
      			while(res.next()) {
      				String nom = res.getString("NomSA");
      				String prenom = res.getString("PrenomSA");
      				nomprenom[0]=nom;
      				nomprenom[1]=prenom;
      			}
      		}
      		return nomprenom;
    	}

    	catch(Exception e) {
    		e.printStackTrace();
    	}
		return null;
	}

	public ArrayList<Formation> getListeFormation() {
		ArrayList<Formation> formation = new ArrayList<Formation>();
		Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	ResultSet res;
    	try {
    		stmt=con.createStatement();
    		String sql = "SELECT * FROM formation";
    		res=stmt.executeQuery(sql);
    		while(res.next()) {
    			int idF = res.getInt("IdF");
    			String nomF = res.getString("NomF");
    			Formation f = new Formation(nomF,null);
    			formation.add(f);
    		}
    		return formation;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return null;
	}

	public ArrayList<Etudiant> getListEtudiant(String nomF) {
		ArrayList<Etudiant> etudiant = new ArrayList<Etudiant>();
		Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	ResultSet res;
    	try {
    		stmt=con.createStatement();
    		String sql = "SELECT * FROM etudiant e, groupe g, formation f WHERE e.IdG=g.IdG and g.IdF=f.IdF and f.NomF='"+nomF+"'";
    		res=stmt.executeQuery(sql);
    		while(res.next()) {
    			String idE = res.getString("e.IdE");
    			String nomE = res.getString("e.NomE");
    			String prenomE = res.getString("e.PrenomE");
    			String nomG = res.getString("g.NomG");
    			Formation f = new Formation(nomF,null);
    			Groupe g = new Groupe(nomG,f);
    			Etudiant e = new Etudiant(idE,null,nomE,prenomE,g);
    			etudiant.add(e);
    		}
    		return etudiant;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return null;
	}

	public void supprimerEtudiant(Etudiant stu) {
		String idE = stu.getNumE();
		Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	ResultSet res;
		try{
            stmt = con.createStatement();
            stmt.execute("delete from etudiant where IdE="+"'"+idE+"';");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
	}

	public ArrayList<Groupe> getListGroupe() {
		ArrayList<Groupe> groupe = new ArrayList<Groupe>();
		Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	ResultSet res;
		try{
            stmt = con.createStatement();
            res=stmt.executeQuery("Select * From groupe");
            while(res.next()) {
            	String numG = res.getString("IdG");
            	Groupe g = new Groupe(numG,null);
            	groupe.add(g);
            }
            return groupe;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
		return null;
	}

	public void ajouterEtudiant(Etudiant etu) {
		Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	Statement stmt1;
    	ResultSet res;
		try{
			int idE = 0;
			String numE =etu.getNumE();
			String mdpE = etu.getMdpE();
			String nomE = etu.getNomE();
			String prenomE = etu.getPrenomE();
			int idG = Integer.parseInt(etu.getGroupe().getNumG());
            stmt = con.createStatement();
            stmt1 = con.createStatement();
            res = stmt.executeQuery("SELECT MAX(IdE) as maxide FROM etudiant");
            while(res.next()) {
            	idE = res.getInt("maxide")+1;
            }
            stmt1.execute("INSERT INTO `etudiant`(`IdE`, `NumE`, `PrenomE`, `NomE`, `MdpE`, `IdG`) VALUES ("+idE+",'"+numE+"','"+prenomE+"','"+nomE+"','"+mdpE+"',"+idG+")");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }		
	}

	public void supprimerGroupe(int numG) {
		Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	ResultSet res;
		try{
            stmt = con.createStatement();
            stmt.execute("delete from groupe where IdG="+"'"+numG+"';");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
	}

	public void ajouterGroupe(Groupe g) {
		Query conn = new Query();
    	con = conn.getConnection();
    	Statement stmt;
    	Statement stmt1;
    	Statement stmt2;
    	ResultSet res;
		try{
			int idG = 0;
			int idF = 0;
			String numG =g.getNumG();
			String nomF = g.getFormation().getNomF();
            stmt = con.createStatement();
            stmt1 = con.createStatement();
            stmt2 = con.createStatement();
            res = stmt.executeQuery("SELECT MAX(IdG) as maxidg FROM groupe");
            while(res.next()) {
            	idG = res.getInt("maxidg")+1;
            }
            res=stmt.executeQuery("SELECT IdF FROM formation WHERE NomF='"+nomF+"'");
            while(res.next()) {
            	idF=res.getInt("IdF");
            }
            stmt2.execute("INSERT INTO `groupe`(`IdG`, `NomG`, `IdF`) VALUES ("+idG+",'"+numG+"',"+idF+")");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }		
		
	}

}

	

	
	
	
    

