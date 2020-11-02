package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePageAdminM extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageAdminM frame = new HomePageAdminM();
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
	public HomePageAdminM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 6, 103, 36);
		contentPane.add(lblNewLabel);
		
		JLabel nomAdminM = new JLabel("");
		nomAdminM.setBounds(138, 17, 61, 16);
		contentPane.add(nomAdminM);
		
		JLabel prenomAdminM = new JLabel("");
		prenomAdminM.setBounds(211, 17, 61, 16);
		contentPane.add(prenomAdminM);
		
		JButton btnSeDeconnecter = new JButton("Se Déconnecter");
		btnSeDeconnecter.setBounds(320, 12, 124, 29);
		contentPane.add(btnSeDeconnecter);
		
		JButton btnGestionSalle = new JButton("Gestion des salles");
		btnGestionSalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGestionSalle.setBounds(40, 136, 168, 52);
		contentPane.add(btnGestionSalle);
		
		JButton btnGestionMachine = new JButton("Gestion des machines");
		btnGestionMachine.setBounds(259, 136, 168, 52);
		contentPane.add(btnGestionMachine);
	}
}
