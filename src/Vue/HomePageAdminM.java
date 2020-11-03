package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePageAdminM extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	private static JButton btnSeDeconnecter = new JButton("Se Deconnecter");
	private static JButton btnGestionSalle = new JButton("Gestion des salles");
	private static JButton btnGestionMachine = new JButton("Gestion des machines");
	/**
	 * Create the frame.
	 */
	public HomePageAdminM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 6, 103, 36);
		contentPane.add(lblNewLabel);
		
		JLabel nomAdminM = new JLabel("");
		nomAdminM.setBounds(138, 17, 61, 16);
		contentPane.add(nomAdminM);
		
		JLabel prenomAdminM = new JLabel("");
		prenomAdminM.setBounds(211, 17, 61, 16);
		contentPane.add(prenomAdminM);
		
		
		
		btnSeDeconnecter.setBounds(304, 24, 124, 29);
		contentPane.add(btnSeDeconnecter);
		
		
		btnGestionSalle.setBounds(40, 136, 168, 52);
		contentPane.add(btnGestionSalle);
		
		
		btnGestionMachine.setBounds(259, 136, 168, 52);
		contentPane.add(btnGestionMachine);
		
		btnSeDeconnecter.addActionListener(this);
		btnGestionSalle.addActionListener(this);
		btnGestionMachine.addActionListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSeDeconnecter) {
			this.setVisible(false);
			Connexion con = new Connexion();
		}if(e.getSource()==btnGestionSalle) {
			this.setVisible(false);
			GestionSalle gs = new GestionSalle();
		}if(e.getSource()==btnGestionMachine) {
			this.setVisible(false);
			GestionMachine gm = new GestionMachine();
		}
		
	}

}
