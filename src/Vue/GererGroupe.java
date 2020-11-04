package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.ControlerInterface;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GererGroupe extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNumG;
	private JTextField txtNumE;
	ControlerInterface controler;
	private static JButton btnRetour = new JButton("Retour");
	private static JButton btnAjouterEtudiant = new JButton("Ajouter");
	private static JButton btnSupprimerEtudiant = new JButton("Supprimer");

	/**
	 * Create the frame.
	 */
	public GererGroupe(ControlerInterface controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero de groupe:");
		lblNewLabel.setBounds(93, 100, 106, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero d'etudiant:");
		lblNewLabel_1.setBounds(93, 162, 122, 15);
		contentPane.add(lblNewLabel_1);
		
		txtNumG = new JTextField();
		txtNumG.setBounds(252, 97, 122, 21);
		contentPane.add(txtNumG);
		txtNumG.setColumns(10);
		
		txtNumE = new JTextField();
		txtNumE.setBounds(252, 159, 122, 21);
		contentPane.add(txtNumE);
		txtNumE.setColumns(10);
		
		
		btnRetour.setBounds(46, 232, 93, 23);
		contentPane.add(btnRetour);
		
		
		btnAjouterEtudiant.setBounds(198, 232, 93, 23);
		contentPane.add(btnAjouterEtudiant);
		
		
		btnSupprimerEtudiant.setBounds(335, 232, 93, 23);
		contentPane.add(btnSupprimerEtudiant);
		
		btnRetour.addActionListener(this);
		btnAjouterEtudiant.addActionListener(this);
		btnSupprimerEtudiant.addActionListener(this);
		
		this.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRetour) {
			this.dispose();
			GestionGroupe gg = new GestionGroupe(controler);
		}if(e.getSource()==btnAjouterEtudiant) {
			this.dispose();
			GestionGroupe gg = new GestionGroupe(controler);
		}if(e.getSource()==btnSupprimerEtudiant) {
			this.dispose();
			GestionGroupe gg = new GestionGroupe(controler);
		}
		
	}

}
