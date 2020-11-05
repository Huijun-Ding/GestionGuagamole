package Vue;

import BD.BDconfig;
import static Vue.AjouterTP.sql;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import Controler.ControlerInterface;

public class ReservationTPE {

    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    private int ids;
    ControlerInterface ci = new ControlerInterface();

    public ReservationTPE() {
        BDconfig c = new BDconfig();
        con = c.getConnection();

        JFrame jf2 = new JFrame("Gestion Guagamole");
        JPanel cards = new JPanel(new CardLayout());
        jf2.setBounds(600, 200, 800, 400);

        JPanel jp = new JPanel();
        JLabel jl = new JLabel("Réserver une machine pour un TP");
        jp.setBackground(Color.white);
        jp.add(jl);
        jf2.getContentPane().add(jp, BorderLayout.NORTH);

        JPanel jp1 = new JPanel();
        jp1.setBackground(SystemColor.inactiveCaptionBorder);
        JLabel labelTP = new JLabel("Choisissez votre TP ：");
        labelTP.setBounds(211, 110, 110, 13);
        JComboBox cmbTP = new JComboBox();
        cmbTP.setBounds(353, 107, 225, 19);
        cmbTP.addItem("--veuillez choisir--");
        try {
            sql = con.prepareStatement("select NomTP from tp;");
            res = sql.executeQuery();
            while (res.next()) {
                cmbTP.addItem(res.getString("NomTP"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        jp1.setLayout(null);
        jp1.add(labelTP);
        JButton btn1 = new JButton("Retour");
        btn1.setBounds(258, 184, 88, 21);
        jp1.add(btn1);

        jp1.add(cmbTP);
        JButton btn2 = new JButton("Valider");
        btn2.setBounds(428, 184, 88, 21);
        jp1.add(btn2);

        JPanel jp2 = new JPanel();
        jp2.setBackground(SystemColor.inactiveCaptionBorder);
        JButton btn3 = new JButton("Retour");
        btn3.setBounds(251, 201, 100, 21);
        JButton btn4 = new JButton("Réserver");
        btn4.setBounds(404, 201, 106, 21);
        jp2.setLayout(null);
        JLabel label = new JLabel("Salle TP : ");
        label.setBounds(251, 73, 48, 13);
        jp2.add(label);
        JLabel label_1 = new JLabel("Machines disponibles : ");
        label_1.setBounds(251, 118, 106, 13);
        jp2.add(label_1);

        jp2.add(btn3);
        jp2.add(btn4);

        cards.add(jp1, "card1");
        cards.add(jp2, "card2");

        JLabel lblNewLabel = new JLabel("--------");
        lblNewLabel.setBounds(402, 73, 45, 13);
        jp2.add(lblNewLabel);
        try {
            sql = con.prepareStatement("select distinct d.IdS, s.NomS from tp t, derouler d, salle s where t.IdTP = d.IdTP and d.IdS = s.IdS and t.NomTP = ?;");
            sql.setString(1, (String)cmbTP.getSelectedItem());
            res = sql.executeQuery();
            //System.out.println(res.getInt("d.IdS"));
            lblNewLabel.setText(res.getString("s.NomS"));
            ids = res.getInt("d.IdS");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(404, 114, 106, 21);
        comboBox.addItem("--veuillez choisir--");
        //System.out.println(ci.afficherMachineTP());
        try {
            sql = con.prepareStatement("select NomM from machine m, salle s where m.IdS = s.IdS and s.IdS = ?;");
            sql.setInt(1, ids);
            res = sql.executeQuery();
            while (res.next()) {
                comboBox.addItem(res.getString("NomM"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jp2.add(comboBox);

        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "card1");
        jf2.getContentPane().add(cards);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn1) {
                    //retourner à la page MenuE
                    jf2.dispose();
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

                    // vers la page de consultation
                    jf2.dispose();
                    new ConsultationE();
                }
            }
        });

        jf2.setVisible(true);
    }

    public static void main(String[] args) {
        new ReservationTPE();
    }
}
