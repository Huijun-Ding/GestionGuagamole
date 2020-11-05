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
import java.awt.SystemColor;

public class MenuE {
    public MenuE() {
        JFrame jf = new JFrame("Gestion Guagamole");   
        jf.setBounds(600, 200, 800, 400);   

        JPanel jp = new JPanel();    
        JLabel jl = new JLabel("Menu");   
        jp.setBackground(Color.white);  
        jp.add(jl);   
        jf.getContentPane().add(jp, BorderLayout.NORTH);

        JPanel cards = new JPanel(new CardLayout());  

        JPanel jp1 = new JPanel();
        jp1.setBackground(SystemColor.inactiveCaptionBorder);
        JButton btn1 = new JButton("Effectuer une réservation");  
        btn1.setBounds(202, 152, 159, 21);
        JButton btn2 = new JButton("Consulter mes réservations");
        btn2.setBounds(421, 152, 167, 21);
        jp1.setLayout(null);
        jp1.add(btn1);
        jp1.add(btn2);

        JPanel jp2 = new JPanel();
        jp2.setBackground(SystemColor.inactiveCaptionBorder);
        JButton btn3 = new JButton("Réserver pour un TP");
        btn3.setBounds(231, 107, 137, 21);
        JButton btn4 = new JButton("Réserver une machine libre");
        btn4.setBounds(391, 107, 169, 21);
        JButton btn5 = new JButton("Retour");
        btn5.setBounds(358, 214, 63, 21);
        jp2.setLayout(null);
        jp2.add(btn3);
        jp2.add(btn4);
        jp2.add(btn5);

        cards.add(jp1, "card1");    //ajouter panel1 dans card comme card1
        cards.add(jp2, "card2");    //ajouter panel2 dans card comme card2
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "card1");    //Afficher card1
        jf.getContentPane().add(cards);

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
