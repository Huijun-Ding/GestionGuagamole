package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AjouterMachine extends JFrame implements ActionListener{

	private JPanel contentPane;


	private static JButton btnValiderAM = new JButton("Valider");
	private static JButton btnAnnulerAM = new JButton("Annuler");
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
		lblNewLabel.setBounds(154, 25, 142, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de machine:");
		lblNewLabel_1.setBounds(36, 81, 142, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Numero de salle:");
		lblNewLabel_2.setBounds(40, 144, 142, 16);
		contentPane.add(lblNewLabel_2);
		
		JTextField txtNumMAM = new JTextField();
		txtNumMAM.setBounds(238, 80, 130, 26);
		contentPane.add(txtNumMAM);
		txtNumMAM.setColumns(10);
		
		JTextField txtNumSAM = new JTextField();
		txtNumSAM.setBounds(239, 139, 130, 26);
		contentPane.add(txtNumSAM);
		txtNumSAM.setColumns(10);
		
		
		btnValiderAM.setBounds(260, 215, 117, 29);
		contentPane.add(btnValiderAM);
		
		
		btnAnnulerAM.setBounds(75, 216, 117, 29);
		contentPane.add(btnAnnulerAM);
		
		btnValiderAM.addActionListener(this);
		btnAnnulerAM.addActionListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnValiderAM) {
			this.setVisible(false);
			GestionMachine gm = new GestionMachine();
		}if(e.getSource()==btnAnnulerAM) {
			this.setVisible(false);
			GestionMachine gm1 = new GestionMachine();
		}
		
	}

}
