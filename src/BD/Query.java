package BD;

import java.sql.*;
import java.util.ArrayList;

import Model.*;

import java.sql.*;
import java.util.ArrayList;

public class Query {

    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;

    public static void main(String[] args) {
        BDconfig c = new BDconfig();
        con = c.getConnection();

        /*for (int i = 0; i < BD.Query.afficherSalles().size(); i++) {
            System.out.println(afficherSalles().get(i));
        }*/
        
        System.out.println(BD.Query.getCreneauTP("java"));
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
        ArrayList<String> salles = new ArrayList();
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
                sql = "SELECT * FROM enseignant E, encadrer EN WHERE E.IdEns=EN.IdEns";
                res = stmt.executeQuery(sql);
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
            else if (i==2){
                Enseignant en;
                sql = "SELECT * FROM enseignant";
                res = stmt.executeQuery(sql);
                while (res.next()) {
                    String idEns = res.getString("NumEns");
                    String mdpEns = res.getString("MdpEns");
                    String nomEns = res.getString("NomEns");
                    String prenomEns = res.getString("PrenomEns");
                    if (idEns.equals(id) && mdpEns.equals(mdp)) {
                        en = new Enseignant(idEns, mdpEns, nomEns, prenomEns);
                        return en;
                    }
                }
            }
            else if (i==1) {
                Etudiant e;
                sql = "SELECT * FROM etudiant";
                res = stmt.executeQuery(sql);
                while (res.next()) {
                    String idE = res.getString("NumE");
                    String mdpE = res.getString("MdpE");
                    String nomE = res.getString("NomE");
                    String prenomE = res.getString("PrenomE");
                    if (idE.equals(id) && mdpE.equals(mdp)) {
                        e = new Etudiant(idE, mdpE, nomE, prenomE);
                        return e;
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

    public void ajouterReservation(Reservation r) {
        int idE = 0;
        int idM = 0;
        try {
            sql = con.prepareStatement("SELECT IdE from etudiant where NumE=?;");
            sql.setString(1, r.getUtilisateur().getNumU());
            res = sql.executeQuery();
            while (res.next()) {
                idE = (res.getInt("IdE"));
            }
            sql = con.prepareStatement("SELECT IdM fromM machine where NomM=?;");
            sql.setString(1, r.getMachine().getNomMachine());
            res = sql.executeQuery();
            while (res.next()) {
                idM = (res.getInt("IdM"));
            }
            sql = con.prepareStatement("INSERT INTO reserver(IdE,IdM,DateResa,CreneauResa) values(?,?,?,?)");
            sql.setInt(1, idE);
            sql.setInt(2, idM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDateTP(String nomTP) {
        try {
            sql = con.prepareStatement("select distinct d.DateTP from derouler d, tp t where t.IdTP = d.IdTP and t.NomTP = ?;");
            sql.setString(1, nomTP);
            res = sql.executeQuery();
            while (res.next()) {
                return res.getString("d.DateTP");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    
    public static String getCreneauTP(String nomTP) {
        try {
            sql = con.prepareStatement("select distinct d.CreneauTP from derouler d, tp t where t.IdTP = d.IdTP and t.NomTP = ?;");
            sql.setString(1, nomTP);
            res = sql.executeQuery();
            while (res.next()) {
                return res.getString("d.CreneauTP");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
