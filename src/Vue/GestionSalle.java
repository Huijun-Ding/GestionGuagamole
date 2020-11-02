package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class GestionSalle extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Gestion des salles");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionSalle frame = new GestionSalle();
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
	public GestionSalle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(166, 6, 136, 16);
		contentPane.add(lblNewLabel);
		
		JList listSalle = new JList();
		listSalle.setBorder(new LineBorder(Color.BLACK, 2, true));
		listSalle.setBounds(31, 76, 180, 152);
		contentPane.add(listSalle);
		
		JLabel lblNewLabel_1 = new JLabel("Salle de TP:");
		lblNewLabel_1.setBounds(31, 50, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAjouterSalle = new JButton("Ajouter");
		btnAjouterSalle.setBounds(270, 73, 117, 29);
		contentPane.add(btnAjouterSalle);
		
		JButton btnModifierSalle = new JButton("Modifier");
		btnModifierSalle.setBounds(270, 136, 117, 29);
		contentPane.add(btnModifierSalle);
		
		JButton btnSupprimerSalle = new JButton("Supprimer");
		btnSupprimerSalle.setBounds(270, 199, 117, 29);
		contentPane.add(btnSupprimerSalle);
		
		JButton btnRetourGS = new JButton("Retour");
		btnRetourGS.setBounds(166, 249, 117, 29);
		contentPane.add(btnRetourGS);
	}
}
