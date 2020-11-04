package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.ControlerInterface;

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

public class Connexion extends JFrame implements ItemListener, ActionListener{

	private JPanel contentPane;
	private static JTextField txtIdentifiantConn;
	private static JPasswordField passConn;
	private ControlerInterface controler;

	private static JRadioButton rdEtudiant = new JRadioButton("Etudiant",true);
	private static JRadioButton rdEnseignant = new JRadioButton("Enseignant",false);
	private static JRadioButton rdRespoF = new JRadioButton("Respo. Formation",false);
	private static JLabel lblNewLabel = new JLabel("Connexion");
	private static JLabel lblNewLabel_1 = new JLabel("Identifiant:");
	private static JLabel lblNewLabel_2 = new JLabel("Mot de passe:");
	private static JButton btnValiderConn = new JButton("Valider");
	private static JButton btnAnnulerConn = new JButton("Annuler");
	/**
	 * Create the frame.
	 */
	public Connexion(ControlerInterface controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblNewLabel.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		lblNewLabel.setBounds(152, 0, 98, 61);
		contentPane.add(lblNewLabel);
		
		
		lblNewLabel_1.setBounds(90, 77, 98, 15);
		contentPane.add(lblNewLabel_1);
		
		
		lblNewLabel_2.setBounds(90, 137, 98, 15);
		contentPane.add(lblNewLabel_2);
		
		txtIdentifiantConn = new JTextField();
		txtIdentifiantConn.setBounds(244, 71, 115, 21);
		contentPane.add(txtIdentifiantConn);
		txtIdentifiantConn.setColumns(10);
		
		passConn = new JPasswordField();
		passConn.setBounds(244, 137, 115, 21);
		contentPane.add(passConn);
				
		rdEtudiant.setBounds(47, 182, 121, 23);
		contentPane.add(rdEtudiant);
				
		rdEnseignant.setBounds(170, 182, 121, 23);
		contentPane.add(rdEnseignant);
				
		rdRespoF.setBounds(293, 182, 121, 23);
		contentPane.add(rdRespoF);
		ButtonGroup g = new ButtonGroup();
		g.add(rdEtudiant);
		g.add(rdEnseignant);
		g.add(rdRespoF);
		
		rdEtudiant.addItemListener(this);
		rdEnseignant.addItemListener(this);
		rdRespoF.addItemListener(this);
				
		btnValiderConn.setBounds(267, 232, 93, 23);
		contentPane.add(btnValiderConn);
			
		btnAnnulerConn.setBounds(90, 232, 93, 23);
		contentPane.add(btnAnnulerConn);
		
		btnValiderConn.addActionListener(this);
		btnAnnulerConn.addActionListener(this);
		this.setVisible(true);
	}
	
	static int i = 1;
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if(arg0.getSource()==rdEtudiant) {
			i=1; 
		}else if(arg0.getSource()==rdEnseignant) {
			i=2;
		}else if(arg0.getSource()==rdRespoF) {
			i=3;
		}
		System.out.print(i);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnValiderConn) {
			String identifiant = txtIdentifiantConn.getText();
			String mdp = new String(passConn.getPassword());
			System.out.println(identifiant);
			System.out.println(mdp);
			if(controler.connexion(identifiant, mdp, i)!=null) {
			this.dispose();

			}if(controler.connexion(identifiant, mdp, i)==null) {
				this.dispose();
				System.out.println("Error");
				Connexion conn = new Connexion(controler);
			}


		}
		else if(arg0.getSource()==btnAnnulerConn) {
			this.dispose();
		}
		
	}
}
