package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModifierMachine extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumSModifMachine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierMachine frame = new ModifierMachine();
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
	public ModifierMachine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modification d'une machine");
		lblNewLabel.setBounds(136, 6, 191, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro de machine:");
		lblNewLabel_1.setBounds(75, 70, 143, 16);
		contentPane.add(lblNewLabel_1);
		
		JTextField txtNumMModifMachine = new JTextField();
		txtNumMModifMachine.setBounds(267, 65, 130, 26);
		contentPane.add(txtNumMModifMachine);
		txtNumMModifMachine.setColumns(10);
		
		JButton btnValiderModifMachine = new JButton("Valider");
		btnValiderModifMachine.setBounds(280, 226, 117, 29);
		contentPane.add(btnValiderModifMachine);
		
		JButton btnAnnulerModifMachine = new JButton("Annuler");
		btnAnnulerModifMachine.setBounds(75, 226, 117, 29);
		contentPane.add(btnAnnulerModifMachine);
		
		JLabel lblNewLabel_2 = new JLabel("Numéro de Salle:");
		lblNewLabel_2.setBounds(75, 134, 130, 16);
		contentPane.add(lblNewLabel_2);
		
		txtNumSModifMachine = new JTextField();
		txtNumSModifMachine.setBounds(267, 129, 130, 26);
		contentPane.add(txtNumSModifMachine);
		txtNumSModifMachine.setColumns(10);
	}

}
