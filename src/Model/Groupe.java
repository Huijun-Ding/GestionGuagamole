package Model;

import BD.BDconfig;
import java.util.ArrayList;
import java.sql.*;

public class Groupe {

    private String nomGroupe;
    private Formation formation;
    private ArrayList<Etudiant> etudiants;
    private ArrayList<TP> listeTPs;
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;

    public Groupe(String nom, Formation f) {
        this.nomGroupe = nom;
        this.formation = f;
        this.etudiants = new ArrayList<>();
        this.listeTPs = new ArrayList<>();
        BDconfig c= new BDconfig();
        con = c.getConnection();
        ActualiserLstEtudiantGroup();
        int numf = f.getNumFormation();
        BD.Query.ajouterGroupe(nom, numf);
    } 
    
    //public Groupe() {}

    public ArrayList<TP> getListeTPs() {
        return listeTPs;
    }

    public void ajouterTP(TP tp) {
        this.listeTPs.add(tp);
    }

    public void removeListTPs(TP tp) {
        this.listeTPs.remove(tp);
    }

    public void ajouterEtudiantGroupe(Etudiant etu) {
        this.etudiants.add(etu);
    }

    public void supprimerEtudiantGroupe(Etudiant e) {
        this.etudiants.remove(e);
    }
    
    public ArrayList<Etudiant> getEtudiants() {
        return this.etudiants;
    }

    public int getNbEtudiant() {
        return this.etudiants.size();
    }

    public void ActualiserLstEtudiantGroup(){
        etudiants.clear();
        try {
            sql=con.prepareStatement("SELECT * FROM etudiant where IdG="+this.nomGroupe+";");
            res = sql.executeQuery();
            while(res.next()){
                String num=res.getString("NumE");
                String mdp=res.getString("MdpE");
                String nom=res.getString("NomE");
                String prenom=res.getString("PrenomE");
                //int numgroup = res.getInt("IdG");
                System.out.println(nom);
                Etudiant e = new Etudiant(num,mdp,nom,prenom,this);
                etudiants.add(e);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

