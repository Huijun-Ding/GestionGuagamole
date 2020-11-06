package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import Controler.ControlerInterface;
import Model.Formation;
import Model.Groupe;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JTextField;

public class GestionGroupe extends JFrame implements ActionListener, DocumentListener{

	ControlerInterface controler;
	private JPanel contentPane;
	private static JButton btnSupprimerGroupe = new JButton("Supprimer");
	private static JButton btnRetourGG = new JButton("Retour");
	public static JComboBox comGroupe = new JComboBox();
	public static JButton btnAjouterGroupe = new JButton("Ajouter");
	private static JTextField txtNomG = new JTextField();
	public static JComboBox comFormation = new JComboBox();
	private final JLabel lblNewLabel_1 = new JLabel("Liste des groupes:");
	private final JLabel lblNewLabel_2 = new JLabel("Nom du groupe");
	private final JLabel lblNewLabel_3 = new JLabel("Formation");
	Formation[] str1;
	/**
	 * Create the frame.
	 */

	public GestionGroupe(ControlerInterface controler) {
		txtNomG.setBounds(29, 140, 109, 21);
		txtNomG.setColumns(10);
		this.controler=controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des groupes");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		lblNewLabel.setBounds(125, 10, 205, 34);
		contentPane.add(lblNewLabel);
		
		
		btnSupprimerGroupe.setBounds(319, 65, 109, 34);
		contentPane.add(btnSupprimerGroupe);
		

		comGroupe.setBounds(29, 68, 173, 29);
		contentPane.add(comGroupe);
		
		
		btnRetourGG.setBounds(165, 232, 93, 23);
		contentPane.add(btnRetourGG);
		

		btnAjouterGroupe.setBounds(319, 133, 109, 34);
		contentPane.add(btnAjouterGroupe);
		btnAjouterGroupe.setEnabled(false);
		
		contentPane.add(txtNomG);
		comFormation.setBounds(165, 139, 109, 23);
		
		contentPane.add(comFormation);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(29, 50, 109, 15);
		
		contentPane.add(lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(34, 120, 104, 15);
		
		contentPane.add(lblNewLabel_2);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(165, 120, 93, 15);
		
		contentPane.add(lblNewLabel_3);
		
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
		
		int size1 = controler.getListeFormation().size();
		int count1 = 0;
		str1 = new Formation[size1];
		for(Formation f : controler.getListeFormation()) {
			str1[count1]=f;
			count1 += 1;			
		}
		for(int addnum=0;addnum<size1;addnum++) {
			comFormation.addItem(str1[addnum].getNomF());
		}
		
		btnSupprimerGroupe.addActionListener(this);
		btnRetourGG.addActionListener(this);
		btnAjouterGroupe.addActionListener(this);
		
		Document document = txtNomG.getDocument();
		document.addDocumentListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {if(e.getSource()==btnSupprimerGroupe){
			controler.supprimerGroupe(Integer.parseInt(comGroupe.getSelectedItem().toString()));
			comGroupe.removeAllItems();
			comFormation.removeAllItems();
			this.dispose();
			GestionGroupe gg = new GestionGroupe(controler);
		}if(e.getSource()==btnRetourGG) {
			this.dispose();
			HomePageAdminF hp = new HomePageAdminF(controler);
		}if(e.getSource()==btnAjouterGroupe) {
			String nomG = txtNomG.getText();
			Formation f = str1[comFormation.getSelectedIndex()];
			Groupe g = new Groupe(nomG,f);
			controler.ajouterGroupe(g);
			comFormation.removeAllItems();
			comGroupe.removeAllItems();
			this.dispose();
			GestionGroupe gg = new GestionGroupe(controler);
		}
		
	}
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		btnAjouterGroupe.setEnabled(true);
		
	}
	@Override
	public void insertUpdate(DocumentEvent arg0) {
		btnAjouterGroupe.setEnabled(true);
		
	}
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		btnAjouterGroupe.setEnabled(false);		
	}
}

