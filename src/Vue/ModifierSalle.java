package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ModifierSalle extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumSModif;
	private JTextField txtCSModif;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierSalle frame = new ModifierSalle();
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
	public ModifierSalle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modification d'une salle");
		lblNewLabel.setBounds(136, 6, 191, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro de salle:");
		lblNewLabel_1.setBounds(75, 70, 116, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Capacité:");
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
		
		JButton btnValiderModifSalle = new JButton("Valider");
		btnValiderModifSalle.setBounds(280, 226, 117, 29);
		contentPane.add(btnValiderModifSalle);
		
		JButton btnAnnulerModifSalle = new JButton("Annuler");
		btnAnnulerModifSalle.setBounds(75, 226, 117, 29);
		contentPane.add(btnAnnulerModifSalle);
	}

}
