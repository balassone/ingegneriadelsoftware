package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Centralinista");
		lblNewLabel.setBounds(10, 11, 148, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textField.getText();
				if(!id.isEmpty()) {
					if(Controller.trovaCentralinista(Integer.parseInt(id))>0) {
						JOptionPane.showMessageDialog(btnNewButton, "Benvenuto, "+Controller.datiCentralinista(Integer.parseInt(id))+"!", "Plain Text", JOptionPane.PLAIN_MESSAGE);
						new CentralinistaView(Integer.parseInt(id)).setVisible(true);
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Centralinista Non Esistente", "Error", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(167, 138, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(167, 109, 89, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(167, 84, 46, 14);
		contentPane.add(lblNewLabel_1);
	}
}
