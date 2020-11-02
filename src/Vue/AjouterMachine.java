package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AjouterMachine extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumMAM;
	private JTextField txtNumSAM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterMachine frame = new AjouterMachine();
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
	public AjouterMachine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter une machine");
		lblNewLabel.setBounds(133, 6, 142, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro de machine:");
		lblNewLabel_1.setBounds(36, 81, 142, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Numéro de salle:");
		lblNewLabel_2.setBounds(40, 144, 142, 16);
		contentPane.add(lblNewLabel_2);
		
		txtNumMAM = new JTextField();
		txtNumMAM.setBounds(238, 80, 130, 26);
		contentPane.add(txtNumMAM);
		txtNumMAM.setColumns(10);
		
		txtNumSAM = new JTextField();
		txtNumSAM.setBounds(239, 139, 130, 26);
		contentPane.add(txtNumSAM);
		txtNumSAM.setColumns(10);
		
		JButton btnValiderAM = new JButton("Valider");
		btnValiderAM.setBounds(260, 215, 117, 29);
		contentPane.add(btnValiderAM);
		
		JButton btnAnnulerAM = new JButton("Annuler");
		btnAnnulerAM.setBounds(75, 216, 117, 29);
		contentPane.add(btnAnnulerAM);
	}

}
