package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class ConsultationEns {
    /**
     * @wbp.parser.entryPoint
     */
    public ConsultationEns() {
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
        panel.setBackground(SystemColor.text);
        panel.setBounds(0, 0, 90, 340);
        jp1.add(panel);
        panel.setLayout(null);
        
        jfEns.setVisible(true); 
    }

    /**
     * @wbp.parser.entryPoint
     */
    public static void main(String[] args) {
        new MenuEns();
    }  
}
