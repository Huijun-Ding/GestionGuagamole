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

import Controler.ControlerInterface;
import Model.Salle;

import javax.swing.JComboBox;

public class AjouterMachine extends JFrame implements ActionListener{
	ControlerInterface controler;
	private JPanel contentPane;

	private static JTextField txtNomMAM = new JTextField();
	private static JButton btnValiderAM = new JButton("Valider");
	private static JButton btnAnnulerAM = new JButton("Annuler");
	private final JComboBox comSalle = new JComboBox();
	/**
	 * Create the frame.
	 */
	public AjouterMachine(ControlerInterface controler) {
		this.controler=controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter une machine");
		lblNewLabel.setBounds(154, 25, 142, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom de machine:");
		lblNewLabel_1.setBounds(40, 75, 142, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Numero de salle:");
		lblNewLabel_2.setBounds(40, 144, 142, 16);
		contentPane.add(lblNewLabel_2);
		
		
		txtNomMAM.setBounds(239, 71, 130, 26);
		contentPane.add(txtNomMAM);
		txtNomMAM.setColumns(10);
		
		
		btnValiderAM.setBounds(260, 215, 117, 29);
		contentPane.add(btnValiderAM);
		
		
		btnAnnulerAM.setBounds(75, 216, 117, 29);
		contentPane.add(btnAnnulerAM);
		comSalle.setBounds(239, 141, 130, 23);
		
		contentPane.add(comSalle);
		
		int size = controler.getListeSalle().size();
		int count = 0;
		Salle[] str = new Salle[size];
		for(Salle s : controler.getListeSalle()) {
			str[count]=s;
			count+=1;
		}
		for(int addnum=0;addnum<size;addnum++) {
			comSalle.addItem(str[addnum].getNumSalle());
		}
		
		btnValiderAM.addActionListener(this);
		btnAnnulerAM.addActionListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnValiderAM) {
			String nomMachine = txtNomMAM.getText();
			int idS = Integer.parseInt(comSalle.getSelectedItem().toString());
			controler.ajouterMachine(nomMachine, idS);
			this.dispose();
			GestionMachine gm = new GestionMachine(controler);
		}if(e.getSource()==btnAnnulerAM) {
			this.dispose();
			GestionMachine gm1 = new GestionMachine(controler);
		}
		
	}
}
