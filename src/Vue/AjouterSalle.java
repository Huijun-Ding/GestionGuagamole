package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AjouterSalle extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumS;
	private JTextField txtCS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterSalle frame = new AjouterSalle();
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
	public AjouterSalle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter une salle");
		lblNewLabel.setBounds(155, 6, 123, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro de salle:");
		lblNewLabel_1.setBounds(95, 80, 114, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Capacité:");
		lblNewLabel_2.setBounds(95, 162, 114, 16);
		contentPane.add(lblNewLabel_2);
		
		txtNumS = new JTextField();
		txtNumS.setBounds(244, 75, 130, 26);
		contentPane.add(txtNumS);
		txtNumS.setColumns(10);
		
		txtCS = new JTextField();
		txtCS.setBounds(244, 157, 130, 26);
		contentPane.add(txtCS);
		txtCS.setColumns(10);
		
		JButton btnValiderAjouterSalle = new JButton("Valider");
		btnValiderAjouterSalle.setBounds(257, 229, 117, 29);
		contentPane.add(btnValiderAjouterSalle);
		
		JButton btnAnnulerAjouterSalle = new JButton("Annuler");
		btnAnnulerAjouterSalle.setBounds(92, 229, 117, 29);
		contentPane.add(btnAnnulerAjouterSalle);
	}
}
