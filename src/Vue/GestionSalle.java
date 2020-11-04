package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controler.ControlerInterface;

public class GestionSalle extends JFrame implements ActionListener{
	ControlerInterface controler;
	private JPanel contentPane;

	private static JButton btnAjouterSalle = new JButton("Ajouter");
	private static JButton btnModifierSalle = new JButton("Modifier");
	private static JButton btnSupprimerSalle = new JButton("Supprimer");
	private static JButton btnRetourGS = new JButton("Retour");
	/**
	 * Create the frame.
	 */
	public GestionSalle(ControlerInterface controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JList listSalle = new JList();
		listSalle.setBorder(new LineBorder(Color.BLACK, 2, true));
		listSalle.setBounds(31, 76, 180, 152);
		contentPane.add(listSalle);
		
		JLabel lblNewLabel_1 = new JLabel("Salle de TP:");
		lblNewLabel_1.setBounds(31, 50, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		
		btnAjouterSalle.setBounds(270, 73, 117, 29);
		contentPane.add(btnAjouterSalle);
		
		
		btnModifierSalle.setBounds(270, 136, 117, 29);
		contentPane.add(btnModifierSalle);
		
		
		btnSupprimerSalle.setBounds(270, 199, 117, 29);
		contentPane.add(btnSupprimerSalle);
		
		
		btnRetourGS.setBounds(165, 238, 117, 29);
		contentPane.add(btnRetourGS);
		
		JLabel lblNewLabel = new JLabel("Gestion des salles");
		lblNewLabel.setBounds(165, 10, 145, 15);
		contentPane.add(lblNewLabel);
		
		btnAjouterSalle.addActionListener(this);
		btnModifierSalle.addActionListener(this);
		btnSupprimerSalle.addActionListener(this);
		btnRetourGS.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRetourGS) {
			this.dispose();
			HomePageAdminM am = new HomePageAdminM(controler);
		}if(e.getSource()==btnAjouterSalle) {
			this.dispose();
			AjouterSalle as = new AjouterSalle(controler);
		}if(e.getSource()==btnModifierSalle) {
			this.dispose();
			ModifierSalle ms = new ModifierSalle(controler);
		}
		
	}
}
