package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AjouterSalle extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private static JButton btnValiderAjouterSalle = new JButton("Valider");
	private static JButton btnAnnulerAjouterSalle = new JButton("Annuler");
	/**
	 * Create the frame.
	 */
	public AjouterSalle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter une salle");
		lblNewLabel.setBounds(155, 6, 123, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de salle:");
		lblNewLabel_1.setBounds(95, 80, 114, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Capacite:");
		lblNewLabel_2.setBounds(95, 162, 114, 16);
		contentPane.add(lblNewLabel_2);
		
		JTextField txtNumS = new JTextField();
		txtNumS.setBounds(244, 75, 130, 26);
		contentPane.add(txtNumS);
		txtNumS.setColumns(10);
		
		JTextField txtCS = new JTextField();
		txtCS.setBounds(244, 157, 130, 26);
		contentPane.add(txtCS);
		txtCS.setColumns(10);
		
		
		btnValiderAjouterSalle.setBounds(257, 229, 117, 29);
		contentPane.add(btnValiderAjouterSalle);
				
		btnAnnulerAjouterSalle.setBounds(92, 229, 117, 29);
		contentPane.add(btnAnnulerAjouterSalle);
		
		btnValiderAjouterSalle.addActionListener(this);
		btnAnnulerAjouterSalle.addActionListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnValiderAjouterSalle) {
			this.dispose();
			GestionSalle gs = new GestionSalle();
		}if(e.getSource()==btnAnnulerAjouterSalle) {
			this.dispose();
			GestionSalle gs = new GestionSalle();
		}
		
	}

}
