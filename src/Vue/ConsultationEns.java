package Vue;

import BD.BDconfig;
import Controler.ControlerInterface;
import static Vue.AjouterTP.sql;
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

        ControlerInterface contro = new ControlerInterface();
        
        // get IdEns
        System.out.println(contro.getId());
        try {
            sql = con.prepareStatement("select IdEns from enseignant where NumEns = ?;");
            sql.setString(1, /*contro.getId().toString()*/"20500001");
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
                comboBox.addItem(res.getString("NomS"));
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



        jfEns.setVisible(true);
    }

    public static void main(String[] args) {
        new ConsultationEns(contro);
    }
}
