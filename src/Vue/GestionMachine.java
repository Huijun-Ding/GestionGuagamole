package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionMachine extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionMachine frame = new GestionMachine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JButton btnAjouterMachine = new JButton("Ajouter");
		btnAjouterMachine.setBounds(270, 73, 117, 29);
		contentPane.add(btnAjouterMachine);
		
		JButton btnModifierMachine = new JButton("Modifier");
		btnModifierMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifierMachine.setBounds(270, 136, 117, 29);
		contentPane.add(btnModifierMachine);
		
		JButton btnSupprimerMachine = new JButton("Supprimer");
		btnSupprimerMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupprimerMachine.setBounds(270, 199, 117, 29);
		contentPane.add(btnSupprimerMachine);
		
		JButton btnRetourGM = new JButton("Retour");
		btnRetourGM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRetourGM.setBounds(166, 249, 117, 29);
		contentPane.add(btnRetourGM);
		
		JLabel lblNewLabel = new JLabel("Gestion des machines");
		lblNewLabel.setBounds(146, 17, 157, 16);
		contentPane.add(lblNewLabel);
	}

}
