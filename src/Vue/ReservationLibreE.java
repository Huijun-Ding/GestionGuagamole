package Vue;

import BD.BDconfig;
import Model.Calendrier;
import Model.Creneau;
import Model.Machine;
import Model.Utilisateur;
import static Vue.AjouterTP.con;
import static Vue.AjouterTP.sql;
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
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReservationLibreE {
    
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    
    public ReservationLibreE() {
        
        BDconfig c= new BDconfig();
        con = c.getConnection();
        
        JFrame jf3 = new JFrame("Gestion Guagamole"); 
        JPanel cards = new JPanel(new CardLayout());         
        jf3.setBounds(600, 200, 800, 400);      

        JPanel jp = new JPanel();   
        JLabel jl = new JLabel("Réserver une machine libre");   
        jp.setBackground(Color.white);  
        jp.add(jl);   
        jf3.add(jp, BorderLayout.NORTH);

        JPanel jp1 = new JPanel();
        JLabel labelL1 =new JLabel("Choisissez une date ：");  
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        JFormattedTextField dateTextField = new JFormattedTextField(format);
        dateTextField.setText("yyyy-MM-dd");
        
        JLabel labelL2 =new JLabel("Choisissez une créneau ："); 
        JComboBox cmb1 = new JComboBox();  
        cmb1.addItem("--veuillez coisir--");    
        cmb1.addItem("8h00-9h30");
        cmb1.addItem("9h30-11h00");
        cmb1.addItem("11h00-12h30");
        cmb1.addItem("12h30-14h00");
        cmb1.addItem("14h00-15h30");
        cmb1.addItem("15h30-17h00");
        cmb1.addItem("17h00-18h30");
        cmb1.addItem("18h30-20h00");
        
        jp1.add(labelL1);
        jp1.add(dateTextField);
        jp1.add(labelL2);
        jp1.add(cmb1);  
        JButton btn1 = new JButton("Retour");    
        JButton btn2 = new JButton("Valider");
        jp1.add(btn1);
        jp1.add(btn2);
        jf3.add(jp1);
        
//---------------------------------------------------------------------------
        JPanel jp2 = new JPanel();
        JButton btn3 = new JButton("Retour");
        JButton btn4 = new JButton("Réserver");
        
        /*jp2.add(new JLabel("Salle libre : "));
        JComboBox cmb2 = new JComboBox();  
        // une boucle de tous les salles libre à cette date et créneau
        cmb2.addItem("--veuillez coisir--");    
        try {
             ; 
            sql = con.prepareStatement("SELECT NomS FROM salle WHERE IdS not in (SELECT s.IdS FROM Salle s, derouler d WHERE s.IdS = d.IdS and DateTP = ? and CreneauTP = ?);");
            sql.setString(1, dateTextField.getText());
            sql.setString(2, (String)cmb1.getSelectedItem());
            res = sql.executeQuery();
            while (res.next()) {
                cmb2.addItem(res.getString("NomS"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jp2.add(cmb2);*/
        
        jp2.add(new JLabel("Machines disponibles : "));
        JComboBox cmb3 = new JComboBox();  
        cmb3.addItem("--veuillez coisir--"); 
        try {

            sql = con.prepareStatement("SELECT NomM FROM machine WHERE IdS in (SELECT IdS FROM salle WHERE IdS not in (SELECT s.IdS FROM Salle s, derouler d WHERE s.IdS = d.IdS and DateTP = ? and CreneauTP = ?));");
            sql.setString(1, dateTextField.getText());
            sql.setString(2, (String)cmb1.getSelectedItem());
            res = sql.executeQuery();
            while (res.next()) {
                cmb3.addItem(res.getString("NomM"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }        
        jp2.add(cmb3);
        jp2.add(btn3);
        jp2.add(btn4);

        cards.add(jp1, "card1");    
        cards.add(jp2, "card2");    
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "card1");   
        jf3.add(cards);
        
//---------------------------------------------------------------------------
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn1) {
                    //retourner à la page MenuE
                    jf3.dispose();
                    new MenuE();
                }
            }
        });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn2) {
                    cl.show(cards, "card2");
                }
            }
        });       
        
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn3) {
                    cl.show(cards, "card1");
                }
            }
        });   
        
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn4) {
                    // réaliser la résrvation
                    //Reservation r = new Reservation(Calendrier c, Utilisateur u, Machine m);
                    
                    
                    // vers la page de consultation
                    jf3.dispose();
                    new ConsultationE();
                }
            }
        });         
        
        jf3.setVisible(true);        
    }
    
    public static void main(String[] args) {
        new ReservationLibreE();
    }    
}
