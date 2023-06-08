package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Referenzia extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Referenzia frame = new Referenzia();
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
	public Referenzia() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setBounds(303, 82, 107, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Referenzia");
		lblNewLabel.setBounds(10, 11, 133, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 82, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 163, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		JLabel lblNewLabel_1 = new JLabel("ID Vecchio Appuntamento");
		lblNewLabel_1.setBounds(10, 57, 133, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID Nuovo Appuntamento");
		lblNewLabel_2.setBounds(10, 138, 133, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret = 0;
				String id = textField.getText();
				if (!id.isEmpty()) {
					ret = Controller.trovaAppuntamento(Integer.parseInt(id));
					if (ret>0) {
						textField_2.setText("Vecchio Trovato!");
						textField_1.setEditable(true);
						
					} else {
						textField_2.setText("Vecchio Non Trovato!");
						textField_1.setEditable(false);
					}
				}
			}
		});
		btnNewButton.setBounds(132, 81, 133, 23);
		contentPane.add(btnNewButton);
		JButton btnNewButton_2 = new JButton("Assegna");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret = 0;
				String vecchio = textField.getText();
				String nuovo = textField_1.getText();
				ret = Controller.referenziaAppuntamento(Integer.parseInt(vecchio), Integer.parseInt(nuovo));
				if(ret>0) {
					JOptionPane.showMessageDialog(btnNewButton, "Appuntamento "+vecchio+" assegnato correttamente al nuovo appuntamento "+nuovo+"!", "Plain Text", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Non assegnato!", "Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret = 0;
				String id = textField_1.getText();
				if (!id.isEmpty()) {
					ret = Controller.trovaAppuntamento(Integer.parseInt(id));
					if (ret>0) {
						textField_3.setText("Nuovo Trovato!");
						
					} else {
						textField_3.setText("Nuovo Non Trovato!");
						
					}
				}
			}
		});
		btnNewButton_1.setBounds(132, 162, 133, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setBounds(303, 163, 107, 20);
		contentPane.add(textField_3);
	}

}
