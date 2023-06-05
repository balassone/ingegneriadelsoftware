package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Centralino;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AggiungiCentralinista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int idGruppo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AggiungiCentralinista frame = new AggiungiCentralinista();
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
	
	public AggiungiCentralinista() {
		super();
	}
	public AggiungiCentralinista(int gruppo) {
		this.idGruppo=gruppo;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(164, 108, 89, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ret = 0;
				String id = textField.getText();
				
				if(!id.isEmpty()) {
					ret = Centralino.inserisciCentralinistaGruppo(idGruppo, Integer.parseInt(id));
				}
				
				if(ret>0) {
					JOptionPane.showMessageDialog(btnNewButton, "Centralinista "+id+" aggiunto al gruppo "+idGruppo+"!", "Plain Text", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Centralinista non trovato!", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(164, 152, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel = new JLabel("Aggiungi Centralinista");
		lblNewLabel.setBounds(10, 11, 133, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(164, 93, 46, 14);
		contentPane.add(lblNewLabel_1);
	}

}
