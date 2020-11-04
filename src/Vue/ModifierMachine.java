package Vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.ControlerInterface;

public class ModifierMachine extends JFrame implements ActionListener{

	private JPanel contentPane;
	ControlerInterface controler;
	private static JButton btnValiderModifMachine = new JButton("Valider");
	private static JButton btnAnnulerModifMachine = new JButton("Annuler");

	/**
	 * Create the frame.
	 */
	public ModifierMachine(ControlerInterface controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modification d'une machine");
		lblNewLabel.setBounds(136, 6, 191, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de machine:");
		lblNewLabel_1.setBounds(75, 70, 143, 16);
		contentPane.add(lblNewLabel_1);
		
		JTextField txtNumMModifMachine = new JTextField();
		txtNumMModifMachine.setBounds(267, 65, 130, 26);
		contentPane.add(txtNumMModifMachine);
		txtNumMModifMachine.setColumns(10);
		
		
		btnValiderModifMachine.setBounds(280, 226, 117, 29);
		contentPane.add(btnValiderModifMachine);
		
		
		btnAnnulerModifMachine.setBounds(75, 226, 117, 29);
		contentPane.add(btnAnnulerModifMachine);
		
		JLabel lblNewLabel_2 = new JLabel("Numero de Salle:");
		lblNewLabel_2.setBounds(75, 134, 130, 16);
		contentPane.add(lblNewLabel_2);
		
		JTextField txtNumSModifMachine = new JTextField();
		txtNumSModifMachine.setBounds(267, 129, 130, 26);
		contentPane.add(txtNumSModifMachine);
		txtNumSModifMachine.setColumns(10);
		
		btnValiderModifMachine.addActionListener(this);
		btnAnnulerModifMachine.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnValiderModifMachine) {
			this.dispose();
			GestionMachine gm = new GestionMachine(controler);
		}if(e.getSource()==btnAnnulerModifMachine) {
			this.dispose();
			GestionMachine gm = new GestionMachine(controler);
		}
		
	}

}
