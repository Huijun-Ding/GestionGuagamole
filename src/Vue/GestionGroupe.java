package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;

public class GestionGroupe extends JFrame implements ActionListener{


	private JPanel contentPane;
	private static JButton btnGererGroupeEtudiant = new JButton("Gerer groupe d'etudiant");
	private static JButton btnAjouterGroupe = new JButton("Ajouter un nouveau groupe");
	private static JButton btnRetourGG = new JButton("Retour");
	/**
	 * Create the frame.
	 */
	public GestionGroupe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des groupes");
		lblNewLabel.setBounds(159, 10, 114, 15);
		contentPane.add(lblNewLabel);
		
		
		btnGererGroupeEtudiant.setBounds(36, 116, 173, 86);
		contentPane.add(btnGererGroupeEtudiant);
		
		
		btnAjouterGroupe.setBounds(243, 116, 185, 86);
		contentPane.add(btnAjouterGroupe);
		
		JComboBox comGroupe = new JComboBox();
		comGroupe.setBounds(36, 57, 173, 23);
		contentPane.add(comGroupe);
		
		
		btnRetourGG.setBounds(165, 232, 93, 23);
		contentPane.add(btnRetourGG);
		
		btnGererGroupeEtudiant.addActionListener(this);
		btnAjouterGroupe.addActionListener(this);
		btnRetourGG.addActionListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnGererGroupeEtudiant) {
			this.dispose();
			GererGroupe gg = new GererGroupe();
		}if(e.getSource()==btnAjouterGroupe){
			this.dispose();
		}if(e.getSource()==btnRetourGG) {
			this.dispose();
			HomePageAdminF hp = new HomePageAdminF();
		}
		
	}
}
