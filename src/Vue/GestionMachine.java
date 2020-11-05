package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controler.ControlerInterface;
import Model.Machine;
import Model.Salle;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GestionMachine extends JFrame implements ActionListener,ItemListener{

	private JPanel contentPane;
	ControlerInterface controler;
	/**
	 * Launch the application.
	 */
	private static JButton btnAjouterMachine = new JButton("Ajouter");
	private static JButton btnModifierMachine = new JButton("Modifier");
	private static JButton btnSupprimerMachine = new JButton("Supprimer");
	private static JButton btnRetourGM = new JButton("Retour");
	public static JComboBox comSalle = new JComboBox();
	public static JComboBox comMachine = new JComboBox();
	/**
	 * Create the frame.
	 */
	public GestionMachine(ControlerInterface controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Machines:");
		lblNewLabel_1.setBounds(31, 139, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		
		btnAjouterMachine.setBounds(270, 73, 117, 29);
		contentPane.add(btnAjouterMachine);
		
		
		btnModifierMachine.setBounds(270, 115, 117, 29);
		contentPane.add(btnModifierMachine);
		
		
		btnSupprimerMachine.setBounds(270, 154, 117, 29);
		contentPane.add(btnSupprimerMachine);
		
		btnRetourGM.setBounds(270, 193, 117, 29);
		contentPane.add(btnRetourGM);
		
		JLabel lblNewLabel = new JLabel("Gestion des machines");
		lblNewLabel.setBounds(146, 17, 157, 16);
		contentPane.add(lblNewLabel);
		
		
		comMachine.setBounds(31, 157, 157, 23);
		contentPane.add(comMachine);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Salle");
		lblNewLabel_2.setBounds(31, 57, 54, 15);
		contentPane.add(lblNewLabel_2);		
		
		
		comSalle.setBounds(31, 76, 157, 23);
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
		
		String numS=comSalle.getSelectedItem().toString();
		int numSalle = Integer.parseInt(numS);
		int sizeM = controler.getListeMachine(numSalle).size();
		System.out.println(sizeM);
		System.out.println(numSalle);
		int countM = 0;
		Machine[] ma = new Machine[sizeM];
		for(Machine s : controler.getListeMachine(numSalle)) {
			ma[countM]=s;
			countM+=1;
		}
		for(int add=0;add<sizeM;add++) {
			comMachine.addItem(ma[add].getNomMachine());
		}

		
		btnAjouterMachine.addActionListener(this);
		btnModifierMachine.addActionListener(this);
		btnSupprimerMachine.addActionListener(this);
		btnRetourGM.addActionListener(this);
		
		this.setVisible(true);
		
		comSalle.addItemListener(this);

	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAjouterMachine) {
			this.dispose();
			AjouterMachine.comSalle.removeAllItems();
			AjouterMachine am  = new AjouterMachine(controler);
		}if(e.getSource()==btnModifierMachine) {
			this.dispose();
			ModifierMachine mm = new ModifierMachine(controler);
		}if(e.getSource()==btnRetourGM) {
			this.dispose();
			HomePageAdminM hp = new HomePageAdminM(controler);
		}if(e.getSource()==btnSupprimerMachine) {
			String numMachine = comMachine.getSelectedItem().toString();
			controler.supprimerMachine(numMachine);
			comMachine.removeAllItems();
			this.dispose();
			GestionMachine gm = new GestionMachine(controler);
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			comMachine.removeAllItems();;
			int numSalle = Integer.parseInt(comSalle.getSelectedItem().toString());
			int sizeM = controler.getListeMachine(numSalle).size();
			int countM = 0;
			Machine[] ma = new Machine[sizeM];
			for(Machine s : controler.getListeMachine(numSalle)) {
				ma[countM++]=s;				
			}
			for(int add=0;add<sizeM;add++) {
				comMachine.addItem(ma[add].getNomMachine());
			}
		}
		
	}
}
