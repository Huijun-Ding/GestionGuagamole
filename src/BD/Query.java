package BD;

import Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Query {
	static BDconfig c;
	static PreparedStatement sql;
	static ResultSet res;
	static Connection con=c.getConnection();
	
	Etudiant etu;
	
/*================ETUDIANT=======================================================*/
	
	/**
	 * afficher une liste des nom de tous les tp pour un groupe donné
	 * @return
	 */
	public static ArrayList<String> afficherNomTP() {
		ArrayList<String>nomTPs= new ArrayList<>();
		try {
		    /*Requêtes vers la bd*/

			//liste des noms de tps pour une date et un crénaeau donné, auquel le groupe de l'étudiant fait partie
		   sql = con.prepareStatement("Select distinct NomTP from tp,derouler where derouler.IdTP=tp.IdTP "
		   		+ "and IdG=? and Date(DateTP)=? and CreneauTP=?;");
		   
		   res = sql.executeQuery();
		   
		   while(res.next()) {
			   nomTPs.add(res.getString(1));
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
		return nomTPs;
	}
	
	/**
	 * Afficher le nom des salles reservées pour un tp
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
	 * afficher la liste des salles libres pour un créneau donné et une date donnée
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
	 * affiche une liste des machines libres dans une salle où va se dérouler un tp
	 * @return
	 */
	public static ArrayList<String> afficherMachineTP() {
		//afficher les machines libres dans la salle réservée pour le tp
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
	 * afficher la liste des machines libres dans une salle libre pour une date donnée et un créneau donné
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
	 * afficher la liste des reservations effectuées
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
		    /*Requêtes vers la bd*/
			
			//ajouter une nouvelle reservation
		   sql = con.prepareStatement("INSERT INTO reserver(IdE,IdM,DateResa,CreneauResa) "
		   		+ "values(?,?,?,?)");
		   
		   sql.setString(1,res.getUtilisateur().getNumU());
		   sql.setString(2,res.getMachine().getNumMachine());
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
	 * annuler une réservation
	 * @param res
	 */
	public void annulerReservation(Reservation res) {
		try {
		    /*Requêtes vers la bd*/
			
			//annuler/supprimer une reservation
		   sql = con.prepareStatement("DELETE FROM reserver WHERE IdE=? and IdM=?"
		   		+ " and DateResa=? and CreneauResa=?) ");
		   
		   sql.setString(1,res.getUtilisateur().getNumU());
		   sql.setString(2,res.getMachine().getNumMachine());
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
	 * modifer une réservation qui ne concerne pas un tp (date et/ou créneau)
	 * @param res
	 */
	public void modifierReservation(Reservation res) {
		try {
		    /*Requêtes vers la bd*/
			
			//annuler/supprimer une reservation
		   sql = con.prepareStatement("UPDATE reserver SET DateResa=?,CreneauResa=? where IdE=? and IdM=?) ");
		   
		   sql.setString(1,res.getUtilisateur().getNumU());
		   sql.setString(2,res.getMachine().getNumMachine());
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
