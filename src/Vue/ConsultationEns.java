package Vue;

import BD.BDconfig;
import Controler.ControlerInterface;
import static Vue.AjouterTP.sql;
import static Vue.ConsultationE.sql;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultationEns {

    private int idens;
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    private static ControlerInterface contro;

    public ConsultationEns(ControlerInterface controler) {

        this.contro = controler;

        BDconfig c = new BDconfig();
        con = c.getConnection();

        // get IdEns
        try {
            sql = con.prepareStatement("select IdEns from enseignant where NumEns = ?;");
            sql.setString(1, contro.getId());
            res = sql.executeQuery();
            while (res.next()) {
                idens = res.getInt("IdEns");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        JFrame jfEns = new JFrame("Gestion Guagamole");
        jfEns.setBounds(600, 200, 800, 400);

        JPanel jp = new JPanel();
        JLabel jl = new JLabel("Consultation");
        jp.setBackground(Color.white);
        jp.add(jl);
        jfEns.getContentPane().add(jp, BorderLayout.NORTH);

        JPanel jp1 = new JPanel();
        jp1.setBackground(SystemColor.inactiveCaptionBorder);
        jp1.setLayout(null);
        jfEns.getContentPane().add(jp1, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 161, 330);
        jp1.add(panel);
        panel.setLayout(null);

        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(10, 76, 141, 29);
        // tous les TPs de cette enseignant
        comboBox.addItem("--veuillez choisir--");
        try {
            sql = con.prepareStatement("select t.NomTP from derouler d, tp t where d.IdTP = t.IdTP and d.IdEns = ?;");
            sql.setInt(1, idens);
            res = sql.executeQuery();
            while (res.next()) {
                comboBox.addItem(res.getString("NomTP"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        panel.add(comboBox);

        JButton btnNewButton = new JButton("Retour");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(25, 277, 112, 29);
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Annuler TP");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1.setBounds(25, 225, 112, 29);
        panel.add(btnNewButton_1);

        JLabel lblNewLabel_1 = new JLabel("TP");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(65, 34, 21, 32);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("Nom du TP");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(212, 31, 108, 27);
        jp1.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("Date");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(212, 81, 87, 34);
        jp1.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Cr\u00E9neau");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(212, 139, 87, 27);
        jp1.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Capacit\u00E9 de salle");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(212, 195, 142, 27);
        jp1.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("--------");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(473, 31, 231, 27);
        jp1.add(lblNewLabel_5);

        JLabel lblNewLabel_5_1 = new JLabel("--------");
        lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5_1.setBounds(473, 85, 231, 27);
        jp1.add(lblNewLabel_5_1);

        JLabel lblNewLabel_5_2 = new JLabel("--------");
        lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5_2.setBounds(473, 139, 231, 27);
        jp1.add(lblNewLabel_5_2);

        JLabel lblNewLabel_5_3 = new JLabel("--------");
        lblNewLabel_5_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5_3.setBounds(473, 195, 231, 27);
        jp1.add(lblNewLabel_5_3);

        JLabel lblNewLabel_5_4 = new JLabel("--------");
        lblNewLabel_5_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5_4.setBounds(473, 253, 231, 27);
        jp1.add(lblNewLabel_5_4);

        JLabel lblNewLabel_4_1 = new JLabel("Nombre d'\u00E9tudiant sur Guagamole");
        lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4_1.setBounds(212, 253, 231, 27);
        jp1.add(lblNewLabel_4_1);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnNewButton) {
                    jfEns.dispose();
                    new MenuEns(controler);
                }
            }
        });

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnNewButton_1) {
                    jfEns.dispose();
                    // supprimer ce TP 
                    /*int idr = Integer.parseInt(comboBox.getSelectedItem().toString());
                    
                    try {
                        sql = con.prepareStatement("Delete from reserver where IdR=?");
                        sql.setInt(1, idr);
                        int res = sql.executeUpdate();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }*/
                }
            }
        });

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == comboBox) {

                    // afficher(reset) Nom du TP, Date, Créneau, Capacité de salle et Nb étidiants sur guagamole
                    String nomtp = comboBox.getSelectedItem().toString();
                    int idtp = 0;
                    String datetp = "";
                    String creneautp = "";
                    int ids = 0;
                    int capacite = 0;
                    int nbp = 0;

                    // retrouver IdTP
                    try {
                        sql = con.prepareStatement("select IdTP from tp where NomTP = ?;");
                        sql.setString(1, nomtp);
                        res = sql.executeQuery();
                        while (res.next()) {
                            idtp = res.getInt("IdTP");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    // Date
                    try {
                        sql = con.prepareStatement("select DateTP from derouler where IdTP = ?;");
                        sql.setInt(1, idtp);
                        res = sql.executeQuery();
                        while (res.next()) {
                            datetp = res.getString("DateTP");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    // Créneau
                    try {
                        sql = con.prepareStatement("select CreneauTP from derouler where IdTP = ?;");
                        sql.setInt(1, idtp);
                        res = sql.executeQuery();
                        while (res.next()) {
                            creneautp = res.getString("CreneauTP");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    //  IdS
                    try {
                        sql = con.prepareStatement("select IdS from derouler where IdTP = ?;");
                        sql.setInt(1, idtp);
                        res = sql.executeQuery();
                        while (res.next()) {
                            ids = res.getInt("IdS");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    // Capacité de salle
                    try {
                        sql = con.prepareStatement("select COUNT(*) from machine where IdS = ?;");
                        sql.setInt(1, ids);
                        res = sql.executeQuery();
                        while (res.next()) {
                            capacite = res.getInt("COUNT(*)");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    // Nb étidiants sur guagamole
                    // reset JLabels
                    lblNewLabel_5.setText(nomtp);
                    lblNewLabel_5_1.setText(datetp);
                    lblNewLabel_5_2.setText(creneautp);
                    lblNewLabel_5_3.setText(String.valueOf(capacite));
                    lblNewLabel_5_4.setText("12");
                }
            }
        });
        
        jfEns.setVisible(true);
    }

    public static void main(String[] args) {
        new ConsultationEns(contro);
    }
}
