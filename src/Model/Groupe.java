package Model;

import BD.BDconfig;
import java.util.ArrayList;
import java.sql.*;

public class Groupe {
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;

    private int numG;
    private String nomG;
    private ArrayList<Etudiant> lstEtudiantGroup;
    
    public Groupe(int num, String nom) {
        this.numG = num;
        this.nomG = nom;
        this.lstEtudiantGroup=new ArrayList<>();
        BDconfig c= new BDconfig();
        con = c.getConnection();
        ActualiserLstEtudiantGroup();
    }

    public void ActualiserLstEtudiantGroup(){
        lstEtudiantGroup.clear();
        try {
            sql=con.prepareStatement("SELECT * FROM etudiant where IdG="+this.numG+";");
            res = sql.executeQuery();
            while(res.next()){
                String num=res.getString("NumE");
                String mdp=res.getString("MdpE");
                String nom=res.getString("NomE");
                String prenom=res.getString("PrenomE");
                int numgroup=res.getInt("IdG");
                System.out.println(nom);
                Etudiant e=new Etudiant(num,mdp,nom,prenom,numgroup);
                lstEtudiantGroup.add(e);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

