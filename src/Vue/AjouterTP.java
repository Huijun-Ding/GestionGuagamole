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
import java.awt.Font;

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
        jl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jp.setBackground(Color.white);
        jp.add(jl);
        jfATP.getContentPane().add(jp, BorderLayout.NORTH);

        JPanel jp1 = new JPanel();
        jp1.setBackground(SystemColor.inactiveCaptionBorder);
        JButton btn1 = new JButton("Retour");
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn1.setBounds(225, 273, 110, 31);
        JButton btn2 = new JButton("Valider");
        btn2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn2.setBounds(436, 273, 116, 31);

        JLabel j = new JLabel("Nom : ");
        j.setFont(new Font("Tahoma", Font.PLAIN, 14));
        j.setBounds(180, 10, 110, 28);
        JTextField txtfield = new JTextField();
        txtfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtfield.setBounds(363, 11, 262, 28);
        txtfield.setText("Veuillez saisir le nom du TP ");

        JLabel j2 = new JLabel("Date : ");
        j2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        j2.setBounds(180, 48, 85, 29);
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        JFormattedTextField dateTextField = new JFormattedTextField(format);
        dateTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        dateTextField.setBounds(363, 49, 189, 24);
        dateTextField.setText("yyyy-MM-dd");

        JLabel j3 = new JLabel("Créneau : ");
        j3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        j3.setBounds(180, 87, 85, 31);
        JComboBox cmb1 = new JComboBox();
        cmb1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cmb1.setBounds(363, 83, 186, 35);
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
        j4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        j4.setBounds(180, 134, 83, 25);
        JComboBox cmb2 = new JComboBox();
        cmb2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cmb2.setBounds(363, 128, 186, 36);
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
        j5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        j5.setBounds(180, 179, 110, 27);
        JComboBox cmb3 = new JComboBox();
        cmb3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cmb3.setBounds(366, 177, 186, 30);
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
        j6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        j6.setBounds(180, 219, 176, 25);
        JComboBox cmb4 = new JComboBox();
        cmb4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cmb4.setBounds(366, 217, 186, 28);
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
