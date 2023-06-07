package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Centralino;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EsitoTelefonata extends JFrame {

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
					EsitoTelefonata frame = new EsitoTelefonata();
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
	public EsitoTelefonata() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registra Esito");
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
		
		JButton btnNewButton = new JButton("Registra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Controlli sull'input vanno fatti qui!
				int ret=0;
				String data = textField.getText();
				String ora = textField_1.getText();
				String note = textField_2.getText();
				String esitos = textField_3.getText();
				int esito = Integer.parseInt(esitos);
				if(data.isEmpty() || !Centralino.isDataValida(data)) {
					JOptionPane.showMessageDialog(btnNewButton, "Data Non Valida", "Error", JOptionPane.PLAIN_MESSAGE);
				} else if(ora.isEmpty() || !Centralino.isOraValida(ora)) {
					JOptionPane.showMessageDialog(btnNewButton, "Ora Non Valida", "Error", JOptionPane.PLAIN_MESSAGE);
				} else if(note.isEmpty() || note.length()>1000) {
					JOptionPane.showMessageDialog(btnNewButton, "Note Non Valide", "Error", JOptionPane.PLAIN_MESSAGE);
				} else if(esitos.isEmpty()|| esito < 1 || esito > 5) {
					JOptionPane.showMessageDialog(btnNewButton, "Esito Non Valido!", "Error", JOptionPane.PLAIN_MESSAGE);
				} else {
					
				
					ret = Centralino.registraEsitoChiamata(data, ora, note, esito, 2);
				
					if(ret>0) {
						JOptionPane.showMessageDialog(btnNewButton, "Telefonata inserita correttamente", "Plain Text", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Telefonata non inserita", "Error", JOptionPane.PLAIN_MESSAGE);
					}
				
					if(esito==5) {
						new CreaAppuntamento(ret).setVisible(true);
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
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.menu);
		textPane.setBounds(219, 39, 190, 83);
		textPane.setText("1. occupato\n2. senza risposta\n3. da richiamare\n4. non interessato\n5. appuntamento fissato");
		contentPane.add(textPane);
	}
}
