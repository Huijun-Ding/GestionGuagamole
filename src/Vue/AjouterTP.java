package Vue;

import BD.*;
import Model.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.ArrayList;

public class AjouterTP {

    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    
    public AjouterTP() {
        BDconfig c= new BDconfig();
        con = c.getConnection();
       
        JFrame jfATP = new JFrame("Gestion Guagamole");
        jfATP.setBounds(600, 200, 800, 400);

        JPanel jp = new JPanel();
        JLabel jl = new JLabel("Nouveau TP");
        jp.setBackground(Color.white);
        jp.add(jl);
        jfATP.add(jp, BorderLayout.NORTH);

        JPanel jp1 = new JPanel();
        JButton btn1 = new JButton("Reour");
        JButton btn2 = new JButton("Valider");

        JLabel j = new JLabel("Nom : ");
        JTextField txtfield = new JTextField();
        txtfield.setText("Veuillez saisir le nom du TP ");

        JLabel j2 = new JLabel("Date : ");
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        JFormattedTextField dateTextField = new JFormattedTextField(format);
        dateTextField.setText("dd-MM-yyyy");

        JLabel j3 = new JLabel("Créneau : ");
        JComboBox cmb1 = new JComboBox();
        // tous les créneau
        cmb1.addItem(Creneau.CRENEAU_8H00_9H30);
        cmb1.addItem(Creneau.CRENEAU_9H30_11H00);
        cmb1.addItem(Creneau.CRENEAU_11H00_12H30);
        cmb1.addItem(Creneau.CRENEAU_12H30_14H00);
        cmb1.addItem(Creneau.CRENEAU_14H00_15H30);
        cmb1.addItem(Creneau.CRENEAU_15H30_17H00);
        cmb1.addItem(Creneau.CRENEAU_17H00_18H30);
        cmb1.addItem(Creneau.CRENEAU_18H30_20H00);

        JLabel j4 = new JLabel("Salle : ");
        JComboBox cmb2 = new JComboBox();
        // une boucle de tous les créneau
        cmb2.addItem("--veuillez coisir--");
        try {
            sql = con.prepareStatement("select NomS from salle;");
            res = sql.executeQuery();
            while (res.next()) {
                cmb2.addItem(res.getString("NomS"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        JLabel j5 = new JLabel("Formation :  ");
        JComboBox cmb3 = new JComboBox();
        // une boucle de tous les créneau
        cmb3.addItem("--veuillez coisir--");
        try {
            sql = con.prepareStatement("select NomF from formation;");
            res = sql.executeQuery();
            while (res.next()) {
                cmb3.addItem(res.getString("NomF"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        JLabel j6 = new JLabel("Groupe d'étudiants :  ");
        JComboBox cmb4 = new JComboBox();
        // une boucle de tous les créneau
        cmb4.addItem("--veuillez coisir--");
        try {
            sql = con.prepareStatement("select NomG from groupe;");
            res = sql.executeQuery();
            while (res.next()) {
                cmb4.addItem(res.getString("NomG"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        jp1.add(j);
        jp1.add(txtfield);
        jp1.add(j2);
        jp1.add(dateTextField);
        jp1.add(j3);
        jp1.add(cmb1);
        jp1.add(j4);
        jp1.add(cmb2);
        jp1.add(j5);
        jp1.add(cmb3);
        jp1.add(j6);
        jp1.add(cmb4);
        jp1.add(btn1);
        jp1.add(btn2);
        jfATP.add(jp1, BorderLayout.CENTER);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn1) {
                    jfATP.dispose();
                    new MenuEns();
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn2) {
                    // ajouter le TP
                    //Calendrier c1 = new Calendrier();
                    //c1.setDate(j2.getText());
                    //c1.setHeure((Creneau) cmb1.getSelectedItem());
                    /*String date = (String)j2.getText();
                    Enum c = (Creneau) cmb1.getSelectedItem()
                    String s = (String)cmb2.getSelectedItem();
                    Enseignant ens = (Enseignant) ;
                    
                    Groupe g = new Groupe();

                    TP t = new TP(txtfield.getText(), c1, , );*/
                    
                    BD.Query.ajouterTP(txtfield.getText());
                    
                    // fermer la fênetre
                    jfATP.dispose();
                    new ConsultationEns();
                }
            }
        });

        jfATP.setVisible(true);
    }

    public static void main(String[] args) {
        new AjouterTP();
    }
}
