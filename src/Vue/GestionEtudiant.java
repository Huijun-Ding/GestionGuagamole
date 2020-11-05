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

import javax.swing.JList;
import javax.swing.JButton;

public class GestionEtudiant extends JFrame implements ActionListener{

	private JPanel contentPane;
	private static JButton btnAjouterEtudiant = new JButton("Ajouter");
	private static JButton btnModifierEtudiant = new JButton("Modifier");
	private static JButton btnSupprimerEtudiant = new JButton("Supprimer");
	private static JButton btnRetourGE = new JButton("Retour");
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
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(10, 56, 210, 204);
		contentPane.add(list);
		btnAjouterEtudiant.setBounds(292, 48, 93, 23);
		contentPane.add(btnAjouterEtudiant);
		btnModifierEtudiant.setBounds(292, 98, 93, 23);
		contentPane.add(btnModifierEtudiant);
		btnSupprimerEtudiant.setBounds(292, 153, 93, 23);
		contentPane.add(btnSupprimerEtudiant);
		btnRetourGE.setBounds(292, 204, 93, 23);
		contentPane.add(btnRetourGE);
		
		btnAjouterEtudiant.addActionListener(this);
		btnModifierEtudiant.addActionListener(this);
		btnSupprimerEtudiant.addActionListener(this);
		btnRetourGE.addActionListener(this);
		
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
			
		}if(e.getSource()==btnRetourGE) {
			this.dispose();
			HomePageAdminF hp = new HomePageAdminF(controler);
		}
		
	}
}
