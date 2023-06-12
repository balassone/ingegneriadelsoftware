package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import control.Controller;
import exceptions.DataNonValida;
import exceptions.OraNonValida;
import javax.swing.JComboBox;

// IMPORTANTE. Runnando il main non funzionerà.
// La classe EsitoTelefonata invocherà il costruttore di questa classe passando al costruttore l'id della telefonata relativa all'appuntamento.

// Così facendo, riduciamo drasticamente il rischio di errore.

public class CreaAppuntamento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private int callID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreaAppuntamento frame = new CreaAppuntamento();
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
	
	public CreaAppuntamento() {
		super();
	}

	
	public CreaAppuntamento(int id) {
		this.callID=id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crea Appuntamento");
		lblNewLabel.setBounds(10, 11, 119, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 54, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 102, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox(Controller.agentiDisponibili());
		comboBox.setBounds(10, 158, 146, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Crea");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ret=0;
				String data = textField.getText();
				String ora = textField_1.getText();
				String agente = (String) comboBox.getSelectedItem();
				
				
				try {
					Controller.isDataValida(data);
				
					Controller.isOraValida(ora);
						
					if(agente.isEmpty() || !(Controller.trovaAgente(agente)>0)){
						JOptionPane.showMessageDialog(btnNewButton, "Agente Non Trovato", "Error", JOptionPane.PLAIN_MESSAGE);
					} else {
						ret = Controller.creaAppuntamento(data, ora, agente,callID);
						if(ret>0) {
							JOptionPane.showMessageDialog(btnNewButton, "Appuntamento inserito correttamente con id="+ret, "Plain Text", JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(btnNewButton, "Appuntamento non inserita", "Error", JOptionPane.PLAIN_MESSAGE);
						}
					}
						
				} catch (OraNonValida ex) {
					JOptionPane.showMessageDialog(btnNewButton, "Ora Non Valida", "Error", JOptionPane.PLAIN_MESSAGE);
				
				} catch (DataNonValida ex) {
					JOptionPane.showMessageDialog(btnNewButton, "Data Non Valida", "Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Data");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ora");
		lblNewLabel_2.setBounds(10, 85, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CF Agente");
		lblNewLabel_3.setBounds(10, 133, 101, 14);
		contentPane.add(lblNewLabel_3);
		
		
	}
}

