package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuEns {
    public MenuEns() {
        JFrame jfEns = new JFrame("Gestion Guagamole");   
        jfEns.setBounds(600, 200, 800, 400);   

        JPanel jp = new JPanel();    
        JLabel jl = new JLabel("Menu");   
        jp.setBackground(Color.white);  
        jp.add(jl);   
        jfEns.add(jp, BorderLayout.NORTH); 

        JPanel jp1 = new JPanel();
        JButton btn1 = new JButton("Ajouter un TP");  
        JButton btn2 = new JButton("Consulter les TPs");
        jp1.add(btn1);
        jp1.add(btn2);
        jfEns.add(jp1, BorderLayout.CENTER);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn1) {
                    jfEns.dispose();
                    new AjouterTP();
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn2) {
                    jfEns.dispose();
                    new ConsultationE();
                }
            }
        });
        
        jfEns.setVisible(true); 
    }

    public static void main(String[] args) {
        new MenuEns();
    }  
}
