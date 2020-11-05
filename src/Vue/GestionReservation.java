package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controler.ControlerInterface;
import Model.Calendrier;
import Model.Creneau;
import Model.Salle;
import Model.TP;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.ScrollPane;

public class GestionReservation extends JFrame implements ActionListener{
	private ControlerInterface controler;
	private JPanel contentPane;
//	private static JTable tableReservation = new JTable(table,title);
	private static JButton btnRetourRes = new JButton("Retour");
	JTable tableReservation;
	/**
	 * Create the frame.
	 */
	public GestionReservation(ControlerInterface controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Toutes les Reservations");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 10, 280, 49);
		contentPane.add(lblNewLabel);
		
		
		btnRetourRes.setBounds(671, 27, 93, 23);
		contentPane.add(btnRetourRes);
				
		ArrayList<TP> tp =  controler.getListReservation();
		int size = tp.size();
		Object[] title = {"Date reservation","Creneau reservation", "Salle", "Etat"};
		Object[][] table = new Object[size][4];
		int count = 0;
		for(TP t : tp) {
			int j = 0;
			Calendrier cal = t.getCalendrier();
			Date date = cal.getDate();
			Creneau heure = cal.getHeure();
			Salle s = t.getSalle();
			String nomS = s.getNomSalle();
			table[count][0]=date;
			table[count][1]=heure;
			table[count][2]=nomS;			
			table[count][3]="Reserve";
			count++;
		}
				
		tableReservation = new JTable(table,title);
		tableReservation.setBounds(20, 69, 744, 378);
		
		JScrollPane scrollPane = new JScrollPane(tableReservation);
	    contentPane.add(scrollPane, BorderLayout.CENTER);
		
		contentPane.add(tableReservation.getTableHeader(), BorderLayout.NORTH);
		contentPane.add(tableReservation, BorderLayout.CENTER);
		

		btnRetourRes.addActionListener(this);
		
		
		
		this.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRetourRes) {
			this.dispose();
			GestionSalle gs = new GestionSalle(controler);
		}
		
	}
}
