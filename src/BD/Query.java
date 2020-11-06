package BD;

import java.sql.*;
import java.util.ArrayList;

import Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {
    static Connection con = BDconfig.getConnection();
    static PreparedStatement sql;
    static ResultSet res;
    Etudiant etu;
  
    public static void main(String[] args) {
        con = BDconfig.getConnection();

       /* for (int i = 0; i < afficherNomTP(1).size(); i++) {
            System.out.println(afficherNomTP(1).get(i));
        }*/
    }

   public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql:" + "//127.0.0.1:3306/guagamole", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void insererEtudiant(String num, String mdp, String nom, String prenom, int numG) {
        int max = 0;
        try {
            sql = con.prepareStatement("SELECT max(IdE) FROM etudiant;");
            res = sql.executeQuery();
            while (res.next()) {
                max = res.getInt("max(IdE)");
            }
            sql = con.prepareStatement("Insert into etudiant(IdE,NumE,MdpE,NomE,PrenomE,IdG) values(?,?,?,?,?,?)");
            sql.setInt(1, max + 1);
            sql.setString(2, num);
            sql.setString(3, mdp);
            sql.setString(4, nom);
            sql.setString(5, prenom);
            sql.setInt(6, numG);
            sql.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void modifierEtudiant(String num, String mdp, String nom, String prenom) {
        try {
            sql = con.prepareStatement("update etudiant set MdpE=?,NomE=?,PrenomE=? where NumE=" + "'" + num + "';");
            sql.setString(1, mdp);
            sql.setString(2, nom);
            sql.setString(3, prenom);
            sql.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void supprimerEtudiant(String num) {
        try {
            sql = con.prepareStatement("delete from etudiant where NumE=" + "'" + num + "';");
            sql.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ajouterEtudiantGroupe(String num, int numG) {
        try {
            sql = con.prepareStatement("update etudiant set IdG=? where NumE=" + "'" + num + "';");
            sql.setInt(1, numG);
            sql.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void supprimerEtudiantGroupe(String num) {
        try {
            sql = con.prepareStatement("update etudiant set IdG=? where NumE=" + "'" + num + "';");
            sql.setNull(1, java.sql.Types.INTEGER);
            sql.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void ajouterGroupe(String nom, int numF) {
        int max = 0;
        try {
            sql = con.prepareStatement("SELECT max(IdG) FROM groupe;");
            res = sql.executeQuery();
            while (res.next()) {
                max = res.getInt("max(IdG)");
            }
            sql = con.prepareStatement("Insert into groupe(IdG,NomG,IdF) values(?,?,?)");
            sql.setInt(1, max + 1);
            sql.setString(2, nom);
            sql.setInt(3, numF);
            sql.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ModifierGroupe(int num, String nom, int numF) {
        try {
            sql = con.prepareStatement("update groupe set NomG=?,IdF=? where IdG=" + num + ";");
            sql.setString(1, nom);
            sql.setInt(2, numF);
            sql.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void supprimerGroupe(int num) {
        try {
            sql = con.prepareStatement("delete from groupe where IdG=?;");
            sql.setInt(1, num);
            sql.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ArrayList<String> afficherSalles() {
        ArrayList<String> salles = new ArrayList<>();
        try {
            sql = con.prepareStatement("select NomS from salle;");
            res = sql.executeQuery();

            while (res.next()) {
                salles.add(res.getString("NomS"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return salles;
    }

    public static void ajouterTP(String nom) {
        try {
            sql = con.prepareStatement("Insert into tp(NomTP) values(?)");
            sql.setString(1, nom);
            sql.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------
    public Utilisateur connexionUilisateur(String id, String mdp, int i) {
        if (id.equals("1234") && mdp.equals("1234")) {
            AdminMateriel a = new AdminMateriel("1234", "1234", "Duan", "Chengyu");
            return a;
        }
        Query conn = new Query();
        con = conn.getConnection();
        Statement stmt;
        ResultSet res;
        try {
            String sql;
            stmt = con.createStatement();
            if (i == 3) {
                AdminRespoF ar;
                sql = "SELECT * FROM enseignant E, encadrer EN WHERE E.idEns=EN.idEns";
                res = stmt.executeQuery(sql);
                while (res.next()) {
                    String idEns = res.getString("E.idEns");
                    String mdpEns = res.getString("E.mdpEns");
                    String nomEns = res.getString("E.nomEns");
                    String prenomEns = res.getString("E.prenomEns");
                    if (idEns.equals(id) && mdpEns.equals(mdp)) {
                        ar = new AdminRespoF(idEns, mdpEns, nomEns, prenomEns);
                        return ar;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Salle> gestionSalle() {
        ArrayList<Salle> salle = new ArrayList<Salle>();
        Query conn = new Query();
        con = conn.getConnection();
        Statement stmt;
        ResultSet res;
        try {
            stmt = con.createStatement();
            String sql = "SELECT * FROM salle S";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int IdS = res.getInt("S.IdS");
                String NomS = res.getString("S.NomS");
                Salle s = new Salle(IdS, NomS, 20);
                salle.add(s);
            }
            return salle;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void supprimerSalle(String nom) {
        Query conn = new Query();
        con = conn.getConnection();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "DELETE FROM salle WHERE NomS='" + nom + "'";
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ajouterSalle(int numS, String nomS) {
        Query conn = new Query();
        con = conn.getConnection();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "INSERT INTO salle`(IdS`, NomS) VALUES (" + numS + ",'" + nomS + "')";
            stmt.execute(sql);
        } catch (Exception e) {
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
            stmt = con.createStatement();
            String sql = "SELECT * FROM machine M, Salle S WHERE M.IdS=S.IdS and M.IdS=" + numSalle;
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int idM = res.getInt("M.IdM");
                String nomM = res.getString("M.NomM");
                int idS = res.getInt("S.IdS");
                String nomS = res.getString("S.NomS");
                Salle s = new Salle(idS, nomS, 20);
                Machine m = new Machine(nomM, s);
                machine.add(m);
            }
            return machine;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void supprimerMachine(String numMachine) {
        Query conn = new Query();
        con = conn.getConnection();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "DELETE FROM machine WHERE NomM='" + numMachine + "'";
            stmt.execute(sql);
        } catch (Exception e) {
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
            stmt = con.createStatement();
            stmt1 = con.createStatement();
            String sql = "SELECT Max(M.IdM) as maxidm FROM machine M";
            res = stmt.executeQuery(sql);
            int numIdM = 1;
            while (res.next()) {
                numIdM = res.getInt("maxidm");
                numIdM += 1;
            }
            sql = "INSERT INTO machine(IdM, NomM, IdS) VALUES (" + numIdM + ",'" + nomMachine + "'," + idS + ")";
            stmt1.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Creneau getCreneauEnum(String date) {
        Creneau cre = null;
        if (date.equals("8h00-9h30")) {
            cre = Creneau.CRENEAU_8H00_9H30;
        }
        if (date.equals("9h30-11h00")) {
            cre = Creneau.CRENEAU_9H30_11H00;
        }
        if (date.equals("11h00-12h30")) {
            cre = Creneau.CRENEAU_11H00_12H30;
        }
        if (date.equals("12h30-14h00")) {
            cre = Creneau.CRENEAU_12H30_14H00;
        }
        if (date.equals("14h00-15h30")) {
            cre = Creneau.CRENEAU_14H00_15H30;
        }
        if (date.equals("15h30-17h00")) {
            cre = Creneau.CRENEAU_15H30_17H00;
        }
        if (date.equals("17h00-18h30")) {
            cre = Creneau.CRENEAU_17H00_18H30;
        }
        if (date.equals("18h30-20h00")) {
            cre = Creneau.CRENEAU_18H30_20H00;
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
            stmt = con.createStatement();
            Date dateRes;
            String cres;
            int idS;
            String etatS;
            Creneau cre;
            String sql = "SELECT * FROM derouler d, salle s WHERE d.IdS = s.IdS";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                dateRes = res.getDate("d.DateTP");
                cres = res.getString("d.CreneauTP");
                Salle s = new Salle(res.getInt("s.IdS"), res.getString("s.NomS"), 20);
                cre = getCreneauEnum(cres);
                Calendrier cal = new Calendrier(cre, dateRes);
                TP tp = new TP(null, cal, s, null, null);
                reservation.add(tp);
            }
            return reservation;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
  /*================ETUDIANT=======================================================*/
	
	/**
	 * afficher une liste des nom de tous les tp pour un groupe donn�
	 * @return
	 */
	public  ArrayList<String> afficherNomTP(String numG, String date ) {
		ArrayList<String>nomTPs= new ArrayList<>();
		try {
		    /*Requetes vers la bd*/

			//liste des noms de tps pour une date et un crenaeau donne, auquel le groupe de l'etudiant fait partie
		   sql = con.prepareStatement("Select distinct NomTP from tp,derouler where derouler.IdTP=tp.IdTP "
		   		+ "and IdG ="+numG+" and DateTP ='"+date+"';");
		   
		   res = sql.executeQuery();
		   
		   while(res.next()) {
			   nomTPs.add(res.getString(1));
		   }
		   
		} catch ( SQLException throwables ) {
			throwables.printStackTrace();
			
		}/*finally {
		    if ( res != null )
	            //Fermeture de l'objet resultSet 
	            res.close();

		    if(sql !=null)
	    		sql.close();
		    if ( con != null )
	            // Fermeture de la connexion 
	            con.close();
	            System.out.println("deconnexion bd");
		}*/
		return nomTPs;
	}
	
	/**
	 * Afficher le nom des salles reserv�es pour un tp
	 * @return
	 */
	public static ArrayList<String> afficherSalleReservee(){
		ArrayList<String>nomSalles = new ArrayList<>();
		try {
		  sql = con.prepareStatement("SELECT NomS FROM derouler, etatsalle,salle"
		  		+ "WHERE etatsalle.DateTP=derouler.DateTP " 
				+ "and derouler.CreneauTP=etatsalle.CreneauTP "
		  		+ "and salle.IdS=derouler.IdS and etatsalle.EtatS='reservee';");
			   
			   res = sql.executeQuery();
			   
			   while(res.next()) {
				   nomSalles.add(res.getString("NomS"));
			   }
			   
		} catch ( SQLException e ) {
			e.printStackTrace();
				
		} finally {
		    if ( res != null )
		        try {
		            /* Fermeture de l'objet resultSet */
		            res.close();
		        } catch ( SQLException ignore ) {
		        }
		    
		    if(sql !=null)
		    	try {
		    		sql.close();
		    		
		    	}catch (SQLException ignore) {
		    		
		    	}
		    if ( con != null )
		        try {
		            /* Fermeture de la connexion */
		            con.close();
		        } catch ( SQLException ignore ) {
		        } 
		}
		return nomSalles;
	}
	
	/**
	 * afficher la liste des salles libres pour un cr�neau donn� et une date donn�e
	 * @return
	 */
	public static ArrayList<String> afficherSallesLibres(){
		ArrayList<String>nomSallesLibres = new ArrayList<>();
		try {
		  sql = con.prepareStatement("SELECT NomS FROM etatsalle,salle"
		  		+ "WHERE etatsalle.IdS=salle.IdS " 
				+ "and etatsalle.CreneauTP =? and etatsalle.DateTP =?"
		  		+ "and etatsalle.EtatS='libre';");
			   
			   res = sql.executeQuery();
			   
			   while(res.next()) {
				   nomSallesLibres.add(res.getString("NomS"));
			   }
			   
		} catch ( SQLException e ) {
			e.printStackTrace();
				
		} finally {
		    if ( res != null )
		        try {
		            /* Fermeture de l'objet resultSet */
		            res.close();
		        } catch ( SQLException ignore ) {
		        }
		    
		    if(sql !=null)
		    	try {
		    		sql.close();
		    		
		    	}catch (SQLException ignore) {
		    		
		    	}
		    if ( con != null )
		        try {
		            /* Fermeture de la connexion */
		            con.close();
		        } catch ( SQLException ignore ) {
		        } 
		}
		return nomSallesLibres;
	}
	
	/**
	 * affiche une liste des machines libres dans une salle o� va se d�rouler un tp
	 * @return
	 */
	public static ArrayList<String> afficherMachineTP() {
		//afficher les machines libres dans la salle r�serv�e pour le tp
		ArrayList<String>nomMachinesTP = new ArrayList<>();
		try {
		  sql = con.prepareStatement("SELECT distinct NomM FROM machine,derouler,etatmachine" + 
		  		"WHERE machine.IdM = etatmachine.IdM AND machine.IdS = derouler.IdS "
		  		+ "AND etatmachine.DateResa = derouler.DateTP AND etatmachine.CreneauResa = derouler.CreneauTP "
		  		+ "AND etatmachine.EtatM = 'libre';");
			   
			   res = sql.executeQuery();
			   
			   while(res.next()) {
				   nomMachinesTP.add(res.getString("NomM"));

			   }
			   
		} catch ( SQLException e ) {
			e.printStackTrace();
				
		} finally {
		    if ( res != null )
		        try {
		            /* Fermeture de l'objet resultSet */
		            res.close();
		        } catch ( SQLException ignore ) {
		        }
		    
		    if(sql !=null)
		    	try {
		    		sql.close();
		    		
		    	}catch (SQLException ignore) {
		    		
		    	}
		    if ( con != null )
		        try {
		            /* Fermeture de la connexion */
		            con.close();
		        } catch ( SQLException ignore ) {
		        } 
		}
		return nomMachinesTP;
	}
	/**
	 * afficher la liste des machines libres dans une salle libre pour une date donn�e et un cr�neau donn�
	 * @return
	 */
	public static ArrayList<String> afficherMachinesLibres(Calendrier date,Calendrier creneau){
		ArrayList<String>nomMachinesLibres = new ArrayList<>();
		try {
		  sql = con.prepareStatement("SELECT distinct NomM FROM machine,etatsalle,etatmachine" + 
		  		"WHERE machine.IdM = etatmachine.IdM AND machine.IdS = etatsalle.IdS "
		  		+ "AND etatmachine.DateResa = etatsalle.DateTP AND etatmachine.CreneauResa = etatsalle.CreneauTP "
		  		+ "AND etatmachine.EtatM = 'libre' and etatsalle.EtatS = 'libre'"
		  		+ "and etatsalle.DateTP=? and etatsalle.CreneauTP=?;");
			   
			   res = sql.executeQuery();
			   
			   while(res.next()) {
				   nomMachinesLibres.add(res.getString("NomM"));

			   }
			   
		} catch ( SQLException e ) {
			e.printStackTrace();
				
		} finally {
		    if ( res != null )
		        try {
		            /* Fermeture de l'objet resultSet */
		            res.close();
		        } catch ( SQLException ignore ) {
		        }
		    
		    if(sql !=null)
		    	try {
		    		sql.close();
		    		
		    	}catch (SQLException ignore) {
		    		
		    	}
		    if ( con != null )
		        try {
		            /* Fermeture de la connexion */
		            con.close();
		        } catch ( SQLException ignore ) {
		        } 
		}
		return nomMachinesLibres;
	}
	
	/**
	 * afficher la liste des reservations effectu�es
	 */
	public void AfficherReservations() {
		try {
			  sql = con.prepareStatement("SELECT * from reserver;");
			   
			   res = sql.executeQuery();
			   
			   while(res.next()) {
				   res.getString(1);
				   res.getString(2);
				   res.getString(3);
				   res.getString(4);
			   }
				   
			} catch ( SQLException e ) {
				e.printStackTrace();
					
			} finally {
			    if ( res != null )
			        try {
			            /* Fermeture de l'objet resultSet */
			            res.close();
			        } catch ( SQLException ignore ) {
			        }
			    
			    if(sql !=null)
			    	try {
			    		sql.close();
			    		
			    	}catch (SQLException ignore) {
			    		
			    	}
			    if ( con != null )
			        try {
			            /* Fermeture de la connexion */
			            con.close();
			        } catch ( SQLException ignore ) {
			        } 
			}
	}
	
	/**
	 * ajouter la nouvelle reservation dans sa liste
	 * @param res
	 */
	public void ajouterReservation(Reservation res) {
		
		try {
		    /*Requ�tes vers la bd*/
			
			//ajouter une nouvelle reservation
		   sql = con.prepareStatement("INSERT INTO reserver(IdE,IdM,DateResa,CreneauResa) "
		   		+ "values(?,?,?,?)");
		   
		   sql.setString(1,res.getUtilisateur().getNumU());
		   sql.setString(2,res.getMachine().getNomMachine());
		   sql.setString(3,res.getCalendrierR().getDate().toString());
		   sql.setString(4,res.getCalendrierR().getHeure().toString());
		   sql.executeUpdate();   
		   etu.ajouterReservation(res);
		   
		} catch ( SQLException e ) {
			e.printStackTrace();
			
		} finally {
		    
		    if(sql !=null)
		    	try {
		    		sql.close();
		    		
		    	}catch (SQLException ignore) {
		    		
		    	}
		    if ( con != null )
		        try {
		            /* Fermeture de la connexion */
		            con.close();
		        } catch ( SQLException ignore ) {
		        } 
		}
	}
	/**
	 * annuler une r�servation
	 * @param res
	 */
	public void annulerReservation(Reservation res) {
		try {
		    /*Requ�tes vers la bd*/
			
			//annuler/supprimer une reservation
		   sql = con.prepareStatement("DELETE FROM reserver WHERE IdE=? and IdM=?"
		   		+ " and DateResa=? and CreneauResa=?) ");
		   
		   sql.setString(1,res.getUtilisateur().getNumU());
		   sql.setString(2,res.getMachine().getNomMachine());
		   sql.setString(3,res.getCalendrierR().getDate().toString());
		   sql.setString(4,res.getCalendrierR().getHeure().toString());
		   sql.executeUpdate();  
		   etu.annulerReservation(res);
		   
		} catch ( SQLException e ) {
			e.printStackTrace();
			
		} finally {
		    
		    if(sql !=null)
		    	try {
		    		sql.close();
		    		
		    	}catch (SQLException ignore) {
		    		
		    	}
		    if ( con != null )
		        try {
		            /* Fermeture de la connexion */
		            con.close();
		        } catch ( SQLException ignore ) {
		        } 
		}
		
	}
	
	/**
	 * modifer une r�servation qui ne concerne pas un tp (date et/ou cr�neau)
	 * @param res
	 */
	public void modifierReservation(Reservation res) {
		try {
		    /*Requ�tes vers la bd*/
			
			//annuler/supprimer une reservation
		   sql = con.prepareStatement("UPDATE reserver SET DateResa=?,CreneauResa=? where IdE=? and IdM=?) ");
		   
		   sql.setString(1,res.getUtilisateur().getNumU());
		   sql.setString(2,res.getMachine().getNomMachine());
		   sql.setString(3,res.getCalendrierR().getDate().toString());
		   sql.setString(4,res.getCalendrierR().getHeure().toString());
		   
		   sql.executeUpdate();
		   etu.modifierReservation(res);
		   
		} catch ( SQLException e ) {
			e.printStackTrace();
			
		} finally {
			if(sql !=null)
		    	try {
		    		sql.close();
		    		
		    	}catch (SQLException ignore) {	
		    	}
			
			if ( con != null )
		        try {
		            /* Fermeture de la connexion */
		            con.close();
		        } catch ( SQLException ignore ) {
		        } 
			
		}
	}
	
}
