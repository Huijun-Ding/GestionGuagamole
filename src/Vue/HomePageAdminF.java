package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.ControlerInterface;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class HomePageAdminF extends JFrame implements ActionListener{

	private JPanel contentPane;
	private ControlerInterface controler;

	private static JButton btnSeDeconnecterRF = new JButton("Se Deconnecter");
	private static JButton btnGestionEtudiant = new JButton("Gestion des etudiants");
	private static JButton btnGestionGroupe = new JButton("Gestion des groupes");

	/**
	 * Create the frame.
	 */
	public HomePageAdminF(ControlerInterface controler) {
		this.controler=controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue!");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(20, 10, 105, 47);
		contentPane.add(lblNewLabel);
		
		String id = controler.getId();
		int type = controler.getType();
		String[] nomprenom = controler.getNomPrenom(id, type);
		JLabel lblNomRF = new JLabel(nomprenom[0]);
		lblNomRF.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNomRF.setBounds(106, 47, 105, 33);
		contentPane.add(lblNomRF);
		
		JLabel lblPrenomRF = new JLabel(nomprenom[1]);
		lblPrenomRF.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPrenomRF.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenomRF.setBounds(30, 47, 90, 33);
		contentPane.add(lblPrenomRF);
		btnSeDeconnecterRF.setFont(new Font("Arial", Font.PLAIN, 12));
		
		
		btnSeDeconnecterRF.setBounds(280, 24, 137, 23);
		contentPane.add(btnSeDeconnecterRF);
		btnGestionEtudiant.setFont(new Font("Arial", Font.PLAIN, 12));
		
		
		btnGestionEtudiant.setBounds(21, 113, 168, 53);
		contentPane.add(btnGestionEtudiant);
		btnGestionGroupe.setFont(new Font("Arial", Font.PLAIN, 12));
		
		
		btnGestionGroupe.setBounds(229, 113, 177, 53);
		contentPane.add(btnGestionGroupe);
		
		btnSeDeconnecterRF.addActionListener(this);
		btnGestionEtudiant.addActionListener(this);
		btnGestionGroupe.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSeDeconnecterRF) {
			this.dispose();
			controler.deconnexion();
			Connexion conn = new Connexion(controler);
		}if(e.getSource()==btnGestionEtudiant) {
			this.dispose();
			GestionEtudiant ge = new GestionEtudiant(controler);
		}if(e.getSource()==btnGestionGroupe) {
			GestionGroupe.comGroupe.removeAllItems();
			GestionGroupe.comFormation.removeAllItems();
			this.setVisible(false);
			GestionGroupe gg = new GestionGroupe(controler);
		}
		
	}
}
