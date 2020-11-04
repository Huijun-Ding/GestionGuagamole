package Vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ReservationTPE {
    public ReservationTPE() {
        JFrame jf2 = new JFrame("Gestion Guagamole"); 
        JPanel cards = new JPanel(new CardLayout());         
        jf2.setBounds(600, 200, 800, 400);      

        JPanel jp = new JPanel();   
        JLabel jl = new JLabel("Réserver une machine pour un TP");   
        jp.setBackground(Color.white);  
        jp.add(jl);   
        jf2.add(jp, BorderLayout.NORTH);

        JPanel jp1 = new JPanel();
        JLabel labelTP =new JLabel("Choisissez votre TP ：");    
        JComboBox cmbTP = new JComboBox();  
        // une boucle de tous les TP correspond à cet étudiant
        cmbTP.addItem("--veuillez coisir--");    
        cmbTP.addItem("TP Programmation Objet Groupe 2 14H-17h");
        
        
        
        
        jp1.add(labelTP);
        jp1.add(cmbTP);  
        JButton btn1 = new JButton("Retour");    
        JButton btn2 = new JButton("Valider");
        jp1.add(btn1);
        jp1.add(btn2);
        jf2.add(jp1);

        JPanel jp2 = new JPanel();
        JButton btn3 = new JButton("Retour");
        JButton btn4 = new JButton("Réserver");
        jp2.add(new JLabel("Salle TP : "));
        jp2.add(new JLabel("Machines disponibles : "));
        
        
        
        jp2.add(btn3);
        jp2.add(btn4);

        cards.add(jp1, "card1");    
        cards.add(jp2, "card2");    
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "card1");   
        jf2.add(cards);

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
                    // Recherche des machines dans la salle de TP correspondant
                    
                    
                    
                    
                    
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
