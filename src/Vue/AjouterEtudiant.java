package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.ControlerInterface;
import Model.Etudiant;
import Model.Formation;
import Model.Groupe;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;

public class AjouterEtudiant extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNumE = new JTextField();
	private JTextField txtMdpE = new JTextField();
	private JTextField txtNomE = new JTextField();
	private JTextField txtPrenomE = new JTextField();
	private static JButton btnValiderAE = new JButton("Valider");
	private static JButton btnRetourAE = new JButton("Retour");
	ControlerInterface controler;
	public static JComboBox comGroupe = new JComboBox();
	/**
	 * Create the frame.
	 */
	public AjouterEtudiant(ControlerInterface controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter un etudiant");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(207, 20, 149, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero d'etudiant:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(85, 68, 108, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(112, 105, 78, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nom:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(159, 142, 34, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prenom:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(142, 182, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		
		txtNumE.setBounds(237, 65, 129, 21);
		contentPane.add(txtNumE);
		txtNumE.setColumns(10);
		
		
		txtMdpE.setBounds(237, 102, 129, 21);
		contentPane.add(txtMdpE);
		txtMdpE.setColumns(10);
		

		txtNomE.setBounds(237, 139, 129, 21);
		contentPane.add(txtNomE);
		txtNomE.setColumns(10);
		

		txtPrenomE.setBounds(237, 179, 129, 21);
		contentPane.add(txtPrenomE);
		txtPrenomE.setColumns(10);
		
		
		btnValiderAE.setBounds(334, 287, 93, 23);
		contentPane.add(btnValiderAE);
		
		
		btnRetourAE.setBounds(100, 287, 93, 23);
		contentPane.add(btnRetourAE);
		

		comGroupe.setBounds(237, 224, 129, 23);
		contentPane.add(comGroupe);
		int size = controler.getListeGroupe().size();
		int count = 0;
		Groupe[] str = new Groupe[size];
		for(Groupe g : controler.getListeGroupe()) {
			str[count]=g;
			count+=1;			
		}
		for(int addnum=0;addnum<size;addnum++) {
			comGroupe.addItem(str[addnum].getNumG());
		}
		
		JLabel lblNewLabel_5 = new JLabel("Groupe:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(142, 228, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		btnValiderAE.addActionListener(this);
		btnRetourAE.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnValiderAE) {
			String numE = txtNumE.getText();
			String mdpE = txtMdpE.getText();
			String nomE = txtNomE.getText();
			String prenomE = txtPrenomE.getText();
			Groupe g = new Groupe(comGroupe.getSelectedItem().toString(),null);
			Etudiant etu = new Etudiant(numE,mdpE,nomE,prenomE,g);
			controler.ajouterEtudiant(etu);
			GestionEtudiant.comFormation.removeAllItems();
			GestionEtudiant.comEtudiant.removeAllItems();
			this.dispose();
			GestionEtudiant ge = new GestionEtudiant(controler);
		}if(e.getSource()==btnRetourAE) {
			GestionEtudiant.comFormation.removeAllItems();
			GestionEtudiant.comEtudiant.removeAllItems();
			this.dispose();
			GestionEtudiant ge = new GestionEtudiant(controler);
		}
		
	}
}
