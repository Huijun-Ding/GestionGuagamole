package BD;

import java.sql.*;
import java.util.ArrayList;

public class Query {

    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;

    public static void main(String[] args) {
        BDconfig c = new BDconfig();
        con = c.getConnection();

        for (int i = 0; i < BD.Query.afficherSalles().size(); i++) {
            System.out.println(afficherSalles().get(i));
        }
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
        ArrayList<String> salles = new ArrayList();
        try {
            sql = con.prepareStatement("select NomS from salle;");
            res = sql.executeQuery();
            /*Statement statement = con.createStatement();
            String query = "update people set name='John' where id=123";
            statement.executeQuery(query);*/

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
}
