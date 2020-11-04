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

public class AjouterGroupe extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	private static JButton btnValiderAG = new JButton("Valider");
	private static JButton btnRetourAG = new JButton("Retour");
	ControlerInterface controler;
	/**
	 * Create the frame.
	 */
	public AjouterGroupe(ControlerInterface controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter un groupe");
		lblNewLabel.setBounds(157, 10, 120, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de groupe:");
		lblNewLabel_1.setBounds(102, 68, 120, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Formation:");
		lblNewLabel_2.setBounds(102, 139, 99, 15);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(249, 65, 93, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(249, 136, 93, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		btnValiderAG.setBounds(265, 232, 93, 23);
		contentPane.add(btnValiderAG);
		
		
		btnRetourAG.setBounds(102, 232, 93, 23);
		contentPane.add(btnRetourAG);
		
		btnValiderAG.addActionListener(this);
		btnRetourAG.addActionListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnValiderAG) {
			this.dispose();
			GestionGroupe gg = new GestionGroupe(controler);
		}if(e.getSource()==btnRetourAG) {
			this.dispose();
			GestionGroupe gg = new GestionGroupe(controler);
		}
		
	}

}
