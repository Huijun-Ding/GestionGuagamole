package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuE {
    public MenuE() {
        JFrame jf = new JFrame("Gestion Guagamole");   
        jf.setBounds(600, 200, 800, 400);   

        JPanel jp = new JPanel();    
        JLabel jl = new JLabel("Menu");   
        jp.setBackground(Color.white);  
        jp.add(jl);   
        jf.add(jp, BorderLayout.NORTH);

        JPanel cards = new JPanel(new CardLayout());  

        JPanel jp1 = new JPanel();
        JButton btn1 = new JButton("Effectuer une réservation");  
        JButton btn2 = new JButton("Consulter mes réservations");
        jp1.add(btn1);
        jp1.add(btn2);
        jf.add(jp1, BorderLayout.CENTER);

        JPanel jp2 = new JPanel();
        JButton btn3 = new JButton("Réserver pour un TP");
        JButton btn4 = new JButton("Réserver une machine libre");
        JButton btn5 = new JButton("Retour");
        jp2.add(btn3);
        jp2.add(btn4);
        jp2.add(btn5, BorderLayout.SOUTH);

        cards.add(jp1, "card1");    //ajouter panel1 dans card comme card1
        cards.add(jp2, "card2");    //ajouter panel2 dans card comme card2
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "card1");    //Afficher card1
        jf.add(cards);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn1) {
                    cl.show(cards, "card2");
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn2) {
                    jf.dispose();
                    new ConsultationE();
                }
            }
        });

        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn3) {
                    jf.dispose();
                    new ReservationTPE();
                }
            }
        });

        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn4) {
                    jf.dispose();
                    new ReservationLibreE();
                }
            }
        });
        
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn5) {
                    cl.show(cards, "card1");
                }
            }
        });        
        
        jf.setVisible(true); 
    }

    public static void main(String[] args) {
        new MenuE();
    }    
}
