package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BD.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controler.ControlerInterface;
import Model.Salle;

import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;

public class GestionSalle extends JFrame implements ActionListener{

	static ControlerInterface controler;
	private JPanel contentPane;

	private static JButton btnAjouterSalle = new JButton("Ajouter");
	private static JButton btnSupprimerSalle = new JButton("Supprimer");
	private static JButton btnRetourGS = new JButton("Retour");
	private static JComboBox comGroupe = new JComboBox();
	
	
	/**
	 * Create the frame.
	 * @param String 
	 */
	public GestionSalle(ControlerInterface controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		
		
		
		int size = controler.getListeSalle().size();
		int count = 0;
		Salle[] str = new Salle[size];
		for(Salle s : controler.getListeSalle()) {
			str[count]=s;
			count+=1;
		}
		for(int addnum=0;addnum<size;addnum++) {
			comGroupe.addItem(str[addnum].getNomSalle());
		}
		
		
		JLabel lblNewLabel_1 = new JLabel("Salle de TP:");
		lblNewLabel_1.setBounds(48, 47, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		
		btnAjouterSalle.setBounds(182, 89, 117, 29);
		contentPane.add(btnAjouterSalle);
		
		
		btnSupprimerSalle.setBounds(182, 163, 117, 29);
		contentPane.add(btnSupprimerSalle);
		
		
		btnRetourGS.setBounds(182, 239, 117, 29);
		contentPane.add(btnRetourGS);
		
		JLabel lblNewLabel = new JLabel("Gestion des salles");
		lblNewLabel.setBounds(165, 10, 145, 15);
		contentPane.add(lblNewLabel);
		
		
		comGroupe.setBounds(155, 44, 169, 23);
		contentPane.add(comGroupe);
		
		
		btnAjouterSalle.addActionListener(this);
		btnSupprimerSalle.addActionListener(this);
		btnRetourGS.addActionListener(this);
		System.out.println(str);
		this.setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRetourGS) {
			comGroupe.removeAllItems();
			this.dispose();
			HomePageAdminM am = new HomePageAdminM(controler);
		}if(e.getSource()==btnAjouterSalle) {
			comGroupe.removeAllItems();
			this.dispose();
			AjouterSalle as = new AjouterSalle(controler);
		}if(e.getSource()==btnSupprimerSalle) {
			String nom = (String)comGroupe.getSelectedItem();
			controler.supprimerSalle(nom);
			comGroupe.removeAllItems();
			this.dispose();
			GestionSalle gs = new GestionSalle(controler);
			
		}
		
	}
}
