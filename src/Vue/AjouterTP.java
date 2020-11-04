package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AjouterTP {
    public AjouterTP() {
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
        txtfield.setText("普通文本框");
        
        JLabel j2 = new JLabel("Date : "); 
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        JFormattedTextField dateTextField = new JFormattedTextField(format);
        dateTextField.setText("dd-MM-yyyy");
        
        JLabel j3 = new JLabel("Créneau : "); 
        JComboBox cmb1 = new JComboBox();  
        // une boucle de tous les créneau
        cmb1.addItem("--veuillez coisir--");    
        cmb1.addItem("8H-9H30");
        
        JLabel j4 = new JLabel("Salle : "); 
        JComboBox cmb2 = new JComboBox();  
        // une boucle de tous les créneau
        cmb2.addItem("--veuillez coisir--");    
        cmb2.addItem("MH403");        
        
        JLabel j5 = new JLabel("Formation :  "); 
        JComboBox cmb3 = new JComboBox();  
        // une boucle de tous les créneau
        cmb3.addItem("--veuillez coisir--");    
        cmb3.addItem("miage ipm");
        
        JLabel j6 = new JLabel("Groupe d'étudiants :  "); 
        JComboBox cmb4 = new JComboBox();  
        // une boucle de tous les créneau
        cmb4.addItem("--veuillez coisir--");    
        cmb4.addItem("8H-9H30");
        
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
                    // qjouter le TP
                    
                    
                    
                    
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
