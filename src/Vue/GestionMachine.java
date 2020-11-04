package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;

public class GestionMachine extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private static JButton btnAjouterMachine = new JButton("Ajouter");
	private static JButton btnModifierMachine = new JButton("Modifier");
	private static JButton btnSupprimerMachine = new JButton("Supprimer");
	private static JButton btnRetourGM = new JButton("Retour");
	/**
	 * Create the frame.
	 */
	public GestionMachine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList listMachine = new JList();
		listMachine.setBorder(new LineBorder(Color.BLACK, 2, true));
		listMachine.setBounds(31, 76, 180, 152);
		contentPane.add(listMachine);
		
		JLabel lblNewLabel_1 = new JLabel("Machines:");
		lblNewLabel_1.setBounds(31, 50, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		
		btnAjouterMachine.setBounds(270, 73, 117, 29);
		contentPane.add(btnAjouterMachine);
		
		
		btnModifierMachine.setBounds(270, 115, 117, 29);
		contentPane.add(btnModifierMachine);
		
		
		btnSupprimerMachine.setBounds(270, 154, 117, 29);
		contentPane.add(btnSupprimerMachine);
		
		btnRetourGM.setBounds(270, 193, 117, 29);
		contentPane.add(btnRetourGM);
		
		JLabel lblNewLabel = new JLabel("Gestion des machines");
		lblNewLabel.setBounds(146, 17, 157, 16);
		contentPane.add(lblNewLabel);
		
		btnAjouterMachine.addActionListener(this);
		btnModifierMachine.addActionListener(this);
		btnSupprimerMachine.addActionListener(this);
		btnRetourGM.addActionListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAjouterMachine) {
			this.dispose();
			AjouterMachine am  = new AjouterMachine();
		}if(e.getSource()==btnModifierMachine) {
			this.dispose();
			ModifierMachine mm = new ModifierMachine();
		}if(e.getSource()==btnRetourGM) {
			this.dispose();
			HomePageAdminM hp = new HomePageAdminM();
		}
		
	}

}
