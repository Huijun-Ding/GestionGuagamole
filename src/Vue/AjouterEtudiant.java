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

public class AjouterEtudiant extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static JButton btnValiderAE = new JButton("Valider");
	private static JButton btnRetourAE = new JButton("Retour");
	ControlerInterface controler;
	/**
	 * Create the frame.
	 */
	public AjouterEtudiant(ControlerInterface controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter un etudiant");
		lblNewLabel.setBounds(144, 10, 149, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero d'etudiant:");
		lblNewLabel_1.setBounds(70, 55, 108, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe:");
		lblNewLabel_2.setBounds(70, 99, 78, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nom:");
		lblNewLabel_3.setBounds(70, 142, 34, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prenom:");
		lblNewLabel_4.setBounds(70, 185, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(227, 52, 129, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(227, 96, 129, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(227, 139, 129, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(227, 182, 129, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		btnValiderAE.setBounds(263, 232, 93, 23);
		contentPane.add(btnValiderAE);
		
		
		btnRetourAE.setBounds(70, 232, 93, 23);
		contentPane.add(btnRetourAE);
		
		btnValiderAE.addActionListener(this);
		btnRetourAE.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnValiderAE) {
			this.dispose();
			GestionEtudiant ge = new GestionEtudiant(controler);
		}if(e.getSource()==btnRetourAE) {
			this.dispose();
			GestionEtudiant ge = new GestionEtudiant(controler);
		}
		
	}
}
