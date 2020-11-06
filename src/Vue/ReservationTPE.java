package Vue;

import BD.BDconfig;
import static Vue.AjouterTP.sql;
import static Vue.ReservationLibreE.res;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import Controler.*;

public class ReservationTPE {

    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    private int ids;
    private String datetp;
    private String creneautp;
    private static ControlerInterface contro;

    public ReservationTPE(ControlerInterface controler) {
        
        this.contro = controler;
        
        BDconfig c = new BDconfig();
        con = c.getConnection();

        JFrame jf2 = new JFrame("Gestion Guagamole");
        JPanel cards = new JPanel(new CardLayout());
        jf2.setBounds(600, 200, 800, 400);

        JPanel jp = new JPanel();
        JLabel jl = new JLabel("Réserver une machine pour un TP");
        jl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jp.setBackground(Color.white);
        jp.add(jl);
        jf2.getContentPane().add(jp, BorderLayout.NORTH);

        JPanel jp1 = new JPanel();
        jp1.setBackground(SystemColor.inactiveCaptionBorder);
        JLabel labelTP = new JLabel("Choisissez votre TP :  ");
        labelTP.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelTP.setBounds(156, 89, 190, 47);

        JComboBox cmbTP = new JComboBox();
        cmbTP.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cmbTP.setBounds(356, 98, 264, 29);
        //cmbTP.addItem("--veuillez choisir--");
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
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn1.setBounds(211, 184, 135, 34);
        jp1.add(btn1);

        jp1.add(cmbTP);
        JButton btn2 = new JButton("Valider");
        btn2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn2.setBounds(428, 184, 126, 34);
        jp1.add(btn2);

        JPanel jp2 = new JPanel();
        jp2.setBackground(SystemColor.inactiveCaptionBorder);
        JButton btn3 = new JButton("Retour");
        btn3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn3.setBounds(250, 201, 101, 33);

        JButton btn4 = new JButton("Réserver");
        btn4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn4.setBounds(437, 201, 115, 33);

        jp2.setLayout(null);
        JLabel label = new JLabel("Salle TP : ");
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setBounds(237, 53, 106, 33);
        jp2.add(label);

        JLabel label_1 = new JLabel("Machines disponibles : ");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_1.setBounds(237, 111, 146, 33);
        jp2.add(label_1);

        jp2.add(btn3);
        jp2.add(btn4);

        cards.add(jp1, "card1");
        cards.add(jp2, "card2");

        JLabel lblNewLabel = new JLabel("--------");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(404, 53, 115, 33);
        jp2.add(lblNewLabel);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBox.setBounds(404, 114, 165, 27);
        jp2.add(comboBox);

        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "card1");
        jf2.getContentPane().add(cards);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn1) {
                    //retourner à la page MenuE
                    jf2.dispose();
                    new MenuE(controler);
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
                    comboBox.removeAllItems();
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
                    new ConsultationE(controler);
                }
            }
        });

        cmbTP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // salle de tp
                try {
                    sql = con.prepareStatement("select distinct d.IdS, s.NomS from tp t, derouler d, salle s where t.IdTP = d.IdTP and d.IdS = s.IdS and t.NomTP = ?;");
                    sql.setString(1, cmbTP.getSelectedItem().toString());
                    res = sql.executeQuery();
                    while (res.next()) {
                        lblNewLabel.setText(res.getString("s.NomS"));
                        ids = res.getInt("d.IdS");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                // date de tp
                try {
                    sql = con.prepareStatement("select distinct d.DateTP from derouler d, tp t where t.IdTP = d.IdTP and t.NomTP = ?;");
                    sql.setString(1, cmbTP.getSelectedItem().toString());
                    res = sql.executeQuery();
                    while (res.next()) {
                        datetp = res.getString("d.DateTP");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                // creneau de tp
                try {
                    sql = con.prepareStatement("select distinct d.CreneauTP from derouler d, tp t where t.IdTP = d.IdTP and t.NomTP = ?;");
                    sql.setString(1, cmbTP.getSelectedItem().toString());
                    res = sql.executeQuery();
                    while (res.next()) {
                        creneautp = res.getString("d.CreneauTP");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                // machine non-réservé dans cette salle
                comboBox.addItem("--veuillez choisir--");
                try {
                    sql = con.prepareStatement("select distinct NomM from machine m, salle s where m.IdS = s.IdS and s.IdS = ? and m.IdM not in ( select IdM from reserver where DateResa = ? and CreneauResa = ?);");
                    sql.setInt(1, ids);
                    sql.setString(2, (String) datetp);
                    sql.setString(3, (String) creneautp);
                    res = sql.executeQuery();
                    while (res.next()) {
                        System.out.println(res.getString("NomM"));
                        comboBox.addItem(res.getString("NomM"));
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        jf2.setVisible(true);
    }

    public static void main(String[] args) {
        new ReservationTPE(contro);
    }
}
