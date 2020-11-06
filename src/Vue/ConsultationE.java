package Vue;

import BD.BDconfig;
import Controler.ControlerInterface;
import static Vue.AjouterTP.sql;
import static Vue.ConsultationEns.sql;
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

public class ConsultationE {

    private static ControlerInterface contro;
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    private int ide;

    public ConsultationE(ControlerInterface controler) {
        BDconfig c = new BDconfig();
        con = c.getConnection();
        this.contro = controler;

        JFrame jfE = new JFrame("Gestion Guagamole");
        jfE.setBounds(600, 200, 800, 400);

        JPanel jp = new JPanel();
        JLabel jl = new JLabel("Consultation");
        jl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jp.setBackground(Color.white);
        jp.add(jl);
        jfE.getContentPane().add(jp, BorderLayout.NORTH);

        JPanel jp1 = new JPanel();
        jp1.setBackground(SystemColor.inactiveCaptionBorder);
        jp1.setLayout(null);
        jfE.getContentPane().add(jp1, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 161, 330);
        jp1.add(panel);
        panel.setLayout(null);

        // get IdE
        System.out.println(contro.getId());
        try {
            sql = con.prepareStatement("select IdE from etudiant where NumE = ?;");
            sql.setString(1, contro.getId());
            res = sql.executeQuery();
            while (res.next()) {
                ide = res.getInt("IdE");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(10, 76, 141, 29);
        // tous les réservations de cet étudiant
        comboBox.addItem("--veuillez choisir--");
        try {
            sql = con.prepareStatement("select IdR from reserver where IdE = ?;");
            sql.setInt(1, ide);
            res = sql.executeQuery();
            while (res.next()) {
                comboBox.addItem(res.getInt("IdR"));
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

        JButton btnNewButton_1 = new JButton("Annuler");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1.setBounds(25, 225, 112, 29);
        panel.add(btnNewButton_1);

        JLabel lblNewLabel_1 = new JLabel("R\u00E9servation");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(42, 34, 73, 32);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("Machine");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(271, 63, 108, 27);
        jp1.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("Date");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(271, 120, 87, 34);
        jp1.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Cr\u00E9neau");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(271, 185, 87, 27);
        jp1.add(lblNewLabel_3);

        JLabel lblNewLabel_5 = new JLabel("--------");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(473, 63, 231, 27);
        jp1.add(lblNewLabel_5);

        JLabel lblNewLabel_5_1 = new JLabel("--------");
        lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5_1.setBounds(473, 124, 231, 27);
        jp1.add(lblNewLabel_5_1);

        JLabel lblNewLabel_5_2 = new JLabel("--------");
        lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5_2.setBounds(473, 185, 231, 27);
        jp1.add(lblNewLabel_5_2);

        JLabel lblNewLabel_4_1 = new JLabel("Remarque: d\u00E9connectez vous la machine \u00E0 la fin de votre r\u00E9servation, mais l'\u00E9teindre pas");
        lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4_1.setBounds(196, 278, 566, 27);
        jp1.add(lblNewLabel_4_1);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnNewButton) {
                    jfE.dispose();
                    new MenuE(controler);
                }
            }
        });

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnNewButton_1) {
                    // supprimer dans la DB la réservation sélectionnée
                    int idr = Integer.parseInt(comboBox.getSelectedItem().toString());
                    
                    try {
                        sql = con.prepareStatement("Delete from reserver where IdR=?");
                        sql.setInt(1, idr);
                        int res = sql.executeUpdate();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == comboBox) {
                    // pour chaque réservation, afficher les :
                    int idr = Integer.parseInt(comboBox.getSelectedItem().toString());
                    String nomm = "";
                    String dater = "";
                    String creneaur = "";

                    // machine 
                    try {
                        sql = con.prepareStatement("select m.NomM from reserver r, machine m where r.IdM = m.IdM and r.IdR = ?;");
                        sql.setInt(1, idr);
                        res = sql.executeQuery();
                        while (res.next()) {
                            nomm = res.getString("NomM");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    // date
                    try {
                        sql = con.prepareStatement("select DateResa from reserver where IdR = ?;");
                        sql.setInt(1, idr);
                        res = sql.executeQuery();
                        while (res.next()) {
                            dater = res.getString("DateResa");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    // créneau
                    try {
                        sql = con.prepareStatement("select CreneauResa from reserver where IdR = ?;");
                        sql.setInt(1, idr);
                        res = sql.executeQuery();
                        while (res.next()) {
                            creneaur = res.getString("CreneauResa");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    // reset value
                    lblNewLabel_5.setText(nomm);
                    lblNewLabel_5_1.setText(dater);
                    lblNewLabel_5_2.setText(creneaur);
                }
            }
        });

        jfE.setVisible(true);
    }

    public static void main(String[] args) {
        new ConsultationE(contro);
    }

}
