package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class LoginCentralinista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCentralinista frame = new LoginCentralinista();
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
	public LoginCentralinista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/ciuccio.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 160, 30);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Login Centralinista");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textField.getText();
				if(!id.isEmpty()) {
					if(Controller.trovaCentralinista(Integer.parseInt(id))>0) {
						JOptionPane.showMessageDialog(btnNewButton, "Benvenuto, "+Controller.datiCentralinista(Integer.parseInt(id))+"!", "Login effettuato", JOptionPane.PLAIN_MESSAGE);
						new CentralinistaView(Integer.parseInt(id)).setVisible(true);
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Centralinista Non Esistente", "Error", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(167, 140, 89, 30);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(197, 100, 59, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(167, 100, 30, 30);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel_1);
		
		JLabel sfondo = new JLabel("");
		sfondo.setIcon(new ImageIcon(this.getClass().getResource("/istockphoto-899394070-612x612.jpg")));
		sfondo.setBounds(0, 0, 440, 270);
		contentPane.add(sfondo);
	}
}
