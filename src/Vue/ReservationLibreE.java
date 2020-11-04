package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReservationLibreE {
    public ReservationLibreE() {
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
        JLabel labelL2 =new JLabel("Choisissez une créneau ："); 
        JComboBox cmb1 = new JComboBox();  
        // une boucle de tous les TP correspond à cet étudiant
        cmb1.addItem("--veuillez coisir--");    
        cmb1.addItem("8H-9H30");
        
        
        jp1.add(labelL1);
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
        jp2.add(new JLabel("Salle libre : "));
        JComboBox cmb2 = new JComboBox();  
        // une boucle de tous les salles libre à cette créneau
        cmb2.addItem("--veuillez coisir--");    
        cmb2.addItem("ME405");
        jp2.add(cmb2);
        jp2.add(new JLabel("Machines disponibles : "));
        
        
        
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
                    // Recherche des machines dans la salle choisi
                    
                    
                    
                    
                    
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
