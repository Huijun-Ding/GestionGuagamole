package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.ControlerInterface;
import Model.Utilisateur;
import BD.Query;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Connexion extends JFrame implements ItemListener, ActionListener{
	
	private JPanel contentPane;
	private static JTextField txtIdentifiantConn;
	private static JPasswordField passConn;
	private ControlerInterface controler;
	private static JRadioButton rdEtudiant = new JRadioButton("Etudiant",false);
	private static JRadioButton rdEnseignant = new JRadioButton("Enseignant",false);
	private static JRadioButton rdRespoF = new JRadioButton("Respo. Formation",false);
	private static JRadioButton rdAdminM = new JRadioButton("Admin Materiel",false);
	private static JLabel lblNewLabel = new JLabel("Connexion");
	private static JLabel lblNewLabel_1 = new JLabel("Identifiant:");
	private static JLabel lblNewLabel_2 = new JLabel("Mot de passe:");
	private static JButton btnValiderConn = new JButton("Valider");
	private static JButton btnAnnulerConn = new JButton("Annuler");
	private static JLabel lblVerifier = new JLabel("");
	

	/**
	 * Create the frame.
	 */
	public Connexion(ControlerInterface controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblNewLabel.setBounds(268, 41, 130, 74);
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		
		lblNewLabel_1.setBounds(158, 147, 112, 15);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		
		
		lblNewLabel_2.setBounds(158, 219, 112, 15);
		contentPane.add(lblNewLabel_2);
		
		txtIdentifiantConn = new JTextField();
		txtIdentifiantConn.setBounds(374, 146, 115, 21);
		contentPane.add(txtIdentifiantConn);
		txtIdentifiantConn.setColumns(10);
		
		passConn = new JPasswordField();
		passConn.setBounds(374, 218, 115, 21);
		contentPane.add(passConn);
		txtIdentifiantConn.setText("");
		passConn.setText("");
		rdEtudiant.setFont(new Font("Arial", Font.PLAIN, 12));
		
		rdEtudiant.setBounds(126, 284, 78, 23);
		contentPane.add(rdEtudiant);
		rdEnseignant.setFont(new Font("Arial", Font.PLAIN, 12));
				
		rdEnseignant.setBounds(206, 284, 98, 23);
		contentPane.add(rdEnseignant);
		rdRespoF.setFont(new Font("Arial", Font.PLAIN, 12));
				
		rdRespoF.setBounds(306, 284, 138, 23);
		contentPane.add(rdRespoF);
		ButtonGroup g = new ButtonGroup();
		g.add(rdEtudiant);
		g.add(rdEnseignant);
		g.add(rdRespoF);
		g.add(rdAdminM);
		
		rdEtudiant.addItemListener(this);
		rdEnseignant.addItemListener(this);
		rdRespoF.addItemListener(this);
		rdAdminM.addItemListener(this);
				
		btnValiderConn.setBounds(399, 340, 93, 23);
		contentPane.add(btnValiderConn);
			
		btnAnnulerConn.setBounds(126, 340, 93, 23);
		contentPane.add(btnAnnulerConn);
		
		
		rdAdminM.setFont(new Font("Arial", Font.PLAIN, 12));
		rdAdminM.setBounds(446, 284, 121, 23);
		contentPane.add(rdAdminM);
		
		lblVerifier.setText("");
		lblVerifier.setForeground(Color.RED);
		lblVerifier.setFont(new Font("Arial", Font.PLAIN, 12));
		lblVerifier.setBounds(173, 394, 299, 33);
		contentPane.add(lblVerifier);
		
		btnValiderConn.addActionListener(this);
		btnAnnulerConn.addActionListener(this);
		this.setVisible(true);
	}
	
	static int i = 0;
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if(arg0.getSource()==rdEtudiant) {
			i=1; 
		}else if(arg0.getSource()==rdEnseignant) {
			i=2;
		}else if(arg0.getSource()==rdRespoF) {
			i=3;
		}else if(arg0.getSource()==rdAdminM) {
			i=4;
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0){
		if(arg0.getSource()==btnValiderConn) {
			String id = txtIdentifiantConn.getText();
			String mdp = new String(passConn.getPassword());
			Utilisateur user = controler.connexion(id, mdp, i);
			if(user!=null) {
			if(i==3) {
			this.dispose();
			HomePageAdminF hpf = new HomePageAdminF(controler);
					}
			if(i==4){
				this.dispose();
				HomePageAdminM hp = new HomePageAdminM(controler);
			}
			}
			else if(controler.connexion(id, mdp, i)==null) {
				this.dispose();
				Connexion conn = new Connexion(controler);
				lblVerifier.setText("Veuillez verifier votre identifiant et mot de passe");
			}

		}
		else if(arg0.getSource()==btnAnnulerConn) {
			this.dispose();
		}
		
	}
}
