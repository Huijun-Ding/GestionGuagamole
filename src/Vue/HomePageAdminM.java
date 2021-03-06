package Vue;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.ControlerInterface;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePageAdminM extends JFrame implements ActionListener{

	private JPanel contentPane;
	private ControlerInterface controler;
	/**
	 * Launch the application.
	 */

	private static JButton btnSeDeconnecter = new JButton("Se Deconnecter");
	private static JButton btnGestionSalle = new JButton("Gestion des salles");
	private static JButton btnGestionMachine = new JButton("Gestion des machines");
	/**
	 * Create the frame.
	 */
	public HomePageAdminM(ControlerInterface controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue!");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 6, 103, 36);
		contentPane.add(lblNewLabel);
		
		JLabel nomAdminM = new JLabel("DUAN");
		nomAdminM.setBounds(205, 17, 89, 16);
		contentPane.add(nomAdminM);
		
		JLabel prenomAdminM = new JLabel("Chengyu");
		prenomAdminM.setBounds(119, 17, 83, 16);
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
			this.dispose();
			controler.deconnexion();
			Connexion con = new Connexion(controler);
		}if(e.getSource()==btnGestionSalle) {
			this.dispose();
			GestionSalle.comGroupe.removeAllItems();
			GestionSalle gs = new GestionSalle(controler);
		}if(e.getSource()==btnGestionMachine) {
			this.dispose();
			GestionMachine.comMachine.removeAllItems();
			GestionMachine.comSalle.removeAllItems();
			GestionMachine gm = new GestionMachine(controler);
		}
		
	}

}
