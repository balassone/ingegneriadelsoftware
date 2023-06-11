package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.Controller;

public class LoginAgente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAgente frame = new LoginAgente();
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
	public LoginAgente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Agente di Vendita");
		lblNewLabel.setBounds(10, 11, 202, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cf = textField.getText();
				if(!cf.isEmpty()) {
					if(Controller.trovaAgente(cf)>0) {
						JOptionPane.showMessageDialog(btnNewButton, "Benvenuto, Agente!", "Plain Text", JOptionPane.PLAIN_MESSAGE);
						new AgenteView(cf).setVisible(true);
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Agente Non Esistente", "Error", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(167, 138, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(78, 109, 267, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CF:");
		lblNewLabel_1.setBounds(78, 84, 46, 14);
		contentPane.add(lblNewLabel_1);
	}
}
