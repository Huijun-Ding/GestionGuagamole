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

public class ModifierSalle extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNumSModif;
	private JTextField txtCSModif;
	ControlerInterface controler;
	private static JButton btnValiderModifSalle = new JButton("Valider");
	private static JButton btnAnnulerModifSalle = new JButton("Annuler");
	/**
	 * Create the frame.
	 */
	public ModifierSalle(ControlerInterface controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modification d'une salle");
		lblNewLabel.setBounds(136, 6, 191, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de salle:");
		lblNewLabel_1.setBounds(75, 70, 116, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Capacite:");
		lblNewLabel_2.setBounds(75, 161, 103, 16);
		contentPane.add(lblNewLabel_2);
		
		txtNumSModif = new JTextField();
		txtNumSModif.setBounds(267, 65, 130, 26);
		contentPane.add(txtNumSModif);
		txtNumSModif.setColumns(10);
		
		txtCSModif = new JTextField();
		txtCSModif.setBounds(267, 156, 130, 26);
		contentPane.add(txtCSModif);
		txtCSModif.setColumns(10);
		
		
		btnValiderModifSalle.setBounds(280, 226, 117, 29);
		contentPane.add(btnValiderModifSalle);
		
		
		btnAnnulerModifSalle.setBounds(75, 226, 117, 29);
		contentPane.add(btnAnnulerModifSalle);
		
		btnValiderModifSalle.addActionListener(this);
		btnAnnulerModifSalle.addActionListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnValiderModifSalle) {
			this.dispose();
			GestionSalle gs = new GestionSalle(controler);
		}if(e.getSource()==btnAnnulerModifSalle) {
			this.dispose();
			GestionSalle gs = new GestionSalle(controler);
		}
		
	}

}
