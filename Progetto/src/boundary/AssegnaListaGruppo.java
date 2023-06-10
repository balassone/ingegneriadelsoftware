package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;
import exceptions.GruppoNonTrovato;
import exceptions.ListaNonTrovata;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssegnaListaGruppo extends JFrame {

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
					AssegnaListaGruppo frame = new AssegnaListaGruppo();
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
	public AssegnaListaGruppo() {
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
		
		JLabel lblNewLabel = new JLabel("Assegna Lista a Gruppo");
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
		JLabel lblNewLabel_1 = new JLabel("Lista");
		lblNewLabel_1.setBounds(10, 57, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gruppo");
		lblNewLabel_2.setBounds(10, 138, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Check Lista");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				if (!id.isEmpty()) {
					try {
						Controller.trovaLista(Integer.parseInt(id));
						textField_2.setText("Lista Trovata!");
						textField_1.setEditable(true);
					} catch (ListaNonTrovata ex) {
						textField_2.setText("Lista Non Trovata!");
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
				String lista = textField.getText();
				String gruppo = textField_1.getText();
				ret = Controller.assegnaListaGruppo(Integer.parseInt(lista), Integer.parseInt(gruppo));
				if(ret>0) {
					JOptionPane.showMessageDialog(btnNewButton, "Lista "+lista+" assegnata correttamente al gruppo "+gruppo+"!", "Plain Text", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Non assegnato!", "Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Check Gruppo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret = 0;
				String id = textField_1.getText();
				if(!id.isEmpty()) {
					try {
						Controller.trovaGruppo(Integer.parseInt(id));
						textField_3.setText("Gruppo Trovato!");
					} catch (GruppoNonTrovato ex) {
						textField_3.setText("Gruppo Non Trovato!");
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
