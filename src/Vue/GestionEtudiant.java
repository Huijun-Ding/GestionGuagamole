package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.ControlerInterface;
import Model.Etudiant;
import Model.Formation;
import Model.Machine;
import Model.Salle;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class GestionEtudiant extends JFrame implements ActionListener, ItemListener{

	private JPanel contentPane;
	private static JButton btnAjouterEtudiant = new JButton("Ajouter");
	private static JButton btnModifierEtudiant = new JButton("Modifier");
	private static JButton btnSupprimerEtudiant = new JButton("Supprimer");
	private static JButton btnRetourGE = new JButton("Retour");
	private static JComboBox comFormation = new JComboBox();
	private static JComboBox comEtudiant = new JComboBox();
	ControlerInterface controler;
	/**
	 * Create the frame.
	 */
	public GestionEtudiant(ControlerInterface controler) {
		this.controler=controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des etudiants");
		lblNewLabel.setBounds(106, 0, 250, 46);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		btnAjouterEtudiant.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAjouterEtudiant.setBounds(292, 48, 93, 23);
		contentPane.add(btnAjouterEtudiant);
		btnModifierEtudiant.setFont(new Font("Arial", Font.PLAIN, 12));
		btnModifierEtudiant.setBounds(292, 98, 93, 23);
		contentPane.add(btnModifierEtudiant);
		btnSupprimerEtudiant.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSupprimerEtudiant.setBounds(292, 153, 93, 23);
		contentPane.add(btnSupprimerEtudiant);
		btnRetourGE.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRetourGE.setBounds(292, 204, 93, 23);
		contentPane.add(btnRetourGE);
		

		comFormation.setBounds(78, 69, 142, 23);
		contentPane.add(comFormation);
		

		comEtudiant.setBounds(78, 153, 142, 23);
		contentPane.add(comEtudiant);
		
		int size = controler.getListeFormation().size();
		int count = 0;
		Formation[] str = new Formation[size];
		for(Formation f : controler.getListeFormation()) {
			str[count]=f;
			count+=1;			
		}
		for(int addnum=0;addnum<size;addnum++) {
			comFormation.addItem(str[addnum].getNomF());
		}
		
		String nomF = comFormation.getSelectedItem().toString();
		ArrayList<Etudiant> etudiant = controler.getListEtudiant(nomF);
		int sizeM = etudiant.size();
		int countM = 0;
		Etudiant[] et = new Etudiant[sizeM];
		for(Etudiant e : etudiant) {
			et[countM]=e;
			countM+=1;
		}
		for(int add=0;add<sizeM;add++) {
			comEtudiant.addItem(et[add].getNomE()+" "+et[add].getPrenomE());
		}
		
		JLabel lblNewLabel_1 = new JLabel("Formation:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(78, 48, 75, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Etudiant:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(79, 135, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		btnAjouterEtudiant.addActionListener(this);
		btnModifierEtudiant.addActionListener(this);
		btnSupprimerEtudiant.addActionListener(this);
		btnRetourGE.addActionListener(this);
		
		comFormation.addItemListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAjouterEtudiant) {
			AjouterEtudiant ae = new AjouterEtudiant(controler);
			this.dispose();
		}if(e.getSource()==btnModifierEtudiant) {
			ModiferEtudiant me = new ModiferEtudiant(controler);
			this.dispose();
		}if(e.getSource()==btnSupprimerEtudiant) {
			int ordre = comEtudiant.getSelectedIndex();
			String nomF = comFormation.getSelectedItem().toString();
			ArrayList<Etudiant> etudiant = controler.getListEtudiant(nomF);
			int sizeM = etudiant.size();
			int countM = 0;
			Etudiant[] et = new Etudiant[sizeM];
			for(Etudiant etu : etudiant) {
				et[countM]=etu;
				countM+=1;
			}
			Etudiant stu = et[ordre];
			controler.supprimerEtudaint(stu);
			this.dispose();
			comEtudiant.removeAllItems();
			comFormation.removeAllItems();
			GestionEtudiant ge = new GestionEtudiant(controler);
		}if(e.getSource()==btnRetourGE) {
			this.dispose();
			HomePageAdminF hp = new HomePageAdminF(controler);
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent ex) {
		if(ex.getStateChange()==ItemEvent.SELECTED) {
			comEtudiant.removeAllItems();
			String nomF = comFormation.getSelectedItem().toString();
			ArrayList<Etudiant> etudiant = controler.getListEtudiant(nomF);
			int sizeM = etudiant.size();
			int countM = 0;
			Etudiant[] et = new Etudiant[sizeM];
			for(Etudiant e : etudiant) {
				et[countM]=e;
				countM+=1;
			}
			for(int add=0;add<sizeM;add++) {
				comEtudiant.addItem(et[add].getNomE()+" "+et[add].getPrenomE());
			}
		}
		
	}
}
