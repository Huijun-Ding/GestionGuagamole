package Model;

import BD.BDconfig;
import java.util.ArrayList;
import java.sql.*;

public class Formation {
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;

    static int numFormation;
    private String nomFormation;
    private AdminRespoF adminRespoF;
    private ArrayList<Groupe> lstGroupe;
    
    public Formation(int num, String nom, AdminRespoF resp) {
        this.numFormation=num;
        this.nomFormation = nom;
        this.adminRespoF = resp;
        this.lstGroupe=new ArrayList<>();
        BDconfig c= new BDconfig();
        con = c.getConnection();
        ActualiserLstGroupe();
    }
    

    public String getNomF() {
    	return this.nomFormation;
    }
    
    public void ajouterGroupe() {
        

    public static int getNumFormation() {
        return Formation.numFormation;

    }
    
    public void ActualiserLstGroupe(){
        lstGroupe.clear();
        try {
            sql=con.prepareStatement("SELECT * FROM groupe where IdF="+this.numFormation+";");
            res = sql.executeQuery();
            while(res.next()){
                int num=res.getInt("IdG");
                String nom=res.getString("NomG");
                Groupe g=new Groupe(nom,this);
                lstGroupe.add(g);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
