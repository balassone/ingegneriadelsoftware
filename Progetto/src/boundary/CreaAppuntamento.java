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

public class CreaAppuntamento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
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
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 148, 414, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 197, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		// Non corretta la possibilità di scrivere le note?
		// Login agente di vendita??
		JButton btnNewButton = new JButton("Crea");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Controlli sull'input vanno fatti qui!
				int ret=0;
				String data = textField.getText();
				String ora = textField_1.getText();
				String note = textField_2.getText();
				String esitos = textField_3.getText();
				int esito = Integer.parseInt(esitos);
				if(data.isEmpty() || !Controller.isDataValida(data)) {
					JOptionPane.showMessageDialog(btnNewButton, "Data Non Valida", "Error", JOptionPane.PLAIN_MESSAGE);
				} else if(ora.isEmpty() || !Controller.isOraValida(ora)) {
					JOptionPane.showMessageDialog(btnNewButton, "Ora Non Valida", "Error", JOptionPane.PLAIN_MESSAGE);
				} else if(note.isEmpty() || note.length()>1000){
					JOptionPane.showMessageDialog(btnNewButton, "Note Non Valide", "Error", JOptionPane.PLAIN_MESSAGE);
				} else if(esitos.isEmpty() || esito<0 || esito>1) {
					JOptionPane.showMessageDialog(btnNewButton, "Esito Non Valido!", "Error", JOptionPane.PLAIN_MESSAGE);
				} else {
					
				
					ret = Controller.creaAppuntamento(data, ora, note, esito, "ABCDEF00D11H123N",callID);
				
					if(ret>0) {
						JOptionPane.showMessageDialog(btnNewButton, "Appuntamento inserito correttamente con id="+ret, "Plain Text", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Appuntamento non inserita", "Error", JOptionPane.PLAIN_MESSAGE);
					}
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
		
		JLabel lblNewLabel_3 = new JLabel("Note");
		lblNewLabel_3.setBounds(10, 133, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Esito");
		lblNewLabel_4.setBounds(10, 179, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextPane txtpnOccupato = new JTextPane();
		txtpnOccupato.setBackground(SystemColor.menu);
		txtpnOccupato.setBounds(219, 39, 190, 83);
		txtpnOccupato.setText("0. OK\n1. Fallito");
		contentPane.add(txtpnOccupato);
	}
}

