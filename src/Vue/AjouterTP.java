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
import java.awt.SystemColor;

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
        jfATP.getContentPane().add(jp, BorderLayout.NORTH);

        JPanel jp1 = new JPanel();
        jp1.setBackground(SystemColor.inactiveCaptionBorder);
        JButton btn1 = new JButton("Retour");
        btn1.setBounds(225, 273, 59, 21);
        JButton btn2 = new JButton("Valider");
        btn2.setBounds(441, 273, 65, 21);

        JLabel j = new JLabel("Nom : ");
        j.setBounds(221, 24, 31, 13);
        JTextField txtfield = new JTextField();
        txtfield.setBounds(405, 21, 137, 19);
        txtfield.setText("Veuillez saisir le nom du TP ");

        JLabel j2 = new JLabel("Date : ");
        j2.setBounds(221, 62, 31, 13);
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        JFormattedTextField dateTextField = new JFormattedTextField(format);
        dateTextField.setBounds(405, 59, 105, 19);
        dateTextField.setText("yyyy-MM-dd");

        JLabel j3 = new JLabel("Créneau : ");
        j3.setBounds(221, 101, 59, 13);
        JComboBox cmb1 = new JComboBox();
        cmb1.setBounds(408, 98, 137, 19);
        // tous les crénneau
        cmb1.addItem("8h00-9h30");
        cmb1.addItem("9h30-11h00");
        cmb1.addItem("11h00-12h30");
        cmb1.addItem("12h30-14h00");
        cmb1.addItem("14h00-15h30");
        cmb1.addItem("15h30-17h00");
        cmb1.addItem("17h00-18h30");
        cmb1.addItem("18h30-20h00");

        JLabel j4 = new JLabel("Salle : ");
        j4.setBounds(223, 142, 33, 13);
        JComboBox cmb2 = new JComboBox();
        cmb2.setBounds(408, 139, 102, 19);
        // une boucle de tous les crÃ©neau
        cmb2.addItem("--veuillez choisir--");
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
        j5.setBounds(221, 180, 60, 13);
        JComboBox cmb3 = new JComboBox();
        cmb3.setBounds(408, 177, 102, 19);
        // une boucle de tous les crÃ©neau
        cmb3.addItem("--veuillez choisir--");
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
        j6.setBounds(222, 220, 110, 13);
        JComboBox cmb4 = new JComboBox();
        cmb4.setBounds(408, 217, 102, 19);
        // une boucle de tous les crÃ©neau
        cmb4.addItem("--veuillez choisir--");
        try {
            sql = con.prepareStatement("select NomG from groupe;");
            res = sql.executeQuery();
            while (res.next()) {
                cmb4.addItem(res.getString("NomG"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jp1.setLayout(null);

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
        jfATP.getContentPane().add(jp1, BorderLayout.CENTER);

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
                    //c1.setDate(j2.());
                    //c1.setHeure((Creneau) cmb1.getSelectedItem());
                    /*String date = (String)j2.getText();
                    Enum c = (Creneau) cmb1.getSelectedItem()
                    String s = (String)cmb2.getSelectedItem();
                    Enseignant ens = (Enseignant) ;
                    
                    Groupe g = new Groupe();

                    TP t = new TP(txtfield.getText(), c1, , );*/
                    
                    BD.Query.ajouterTP(txtfield.getText());
                    
                    // fermer la fÃªnetre
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
