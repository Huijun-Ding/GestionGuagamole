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

public class ModiferEtudiant extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNumEME;
	private JTextField txtMdpEME;
	private JTextField txtNomEME;
	private JTextField txtPrenomEME;
	private static JButton btnValiderME = new JButton("Valider");
	private static JButton btnRetourME = new JButton("Retour");
	ControlerInterface controler;

	/**
	 * Create the frame.
	 */
	public ModiferEtudiant(ControlerInterface controler) {
		this.controler=controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modifier un compte d'etudiant");
		lblNewLabel.setBounds(123, 10, 193, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero d'etudiant:");
		lblNewLabel_1.setBounds(82, 55, 116, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe:");
		lblNewLabel_2.setBounds(82, 103, 97, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nom:");
		lblNewLabel_3.setBounds(82, 150, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prenom:");
		lblNewLabel_4.setBounds(82, 201, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		txtNumEME = new JTextField();
		txtNumEME.setBounds(251, 52, 116, 21);
		contentPane.add(txtNumEME);
		txtNumEME.setColumns(10);
		
		txtMdpEME = new JTextField();
		txtMdpEME.setBounds(251, 100, 116, 21);
		contentPane.add(txtMdpEME);
		txtMdpEME.setColumns(10);
		
		txtNomEME = new JTextField();
		txtNomEME.setBounds(251, 144, 116, 21);
		contentPane.add(txtNomEME);
		txtNomEME.setColumns(10);
		
		txtPrenomEME = new JTextField();
		txtPrenomEME.setBounds(250, 198, 117, 21);
		contentPane.add(txtPrenomEME);
		txtPrenomEME.setColumns(10);
		
	
		btnValiderME.setBounds(258, 242, 93, 23);
		contentPane.add(btnValiderME);
		
		
		btnRetourME.setBounds(105, 242, 93, 23);
		contentPane.add(btnRetourME);
		
		btnValiderME.addActionListener(this);
		btnRetourME.addActionListener(this);
		
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnValiderME) {
			this.dispose();
			GestionEtudiant ge = new GestionEtudiant (controler);		
			}if(e.getSource()==btnRetourME) {
				this.dispose();
				GestionEtudiant ge = new GestionEtudiant(controler);
			}
		
	}

}
