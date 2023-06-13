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
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import control.Controller;
import exceptions.NoteNonValide;

import javax.swing.JEditorPane;

public class NoteAppuntamento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoteAppuntamento frame = new NoteAppuntamento();
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
	
	public NoteAppuntamento() {
		super();
	}
	
	public NoteAppuntamento(String CF) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(20, 304, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(20, 36, 561, 206);
		contentPane.add(editorPane);
		
		JButton btnNewButton = new JButton("Visualizza");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				if(!id.isEmpty()) {
					editorPane.setText(Controller.ottieniNoteAppuntamento(CF, Integer.parseInt(id)));
					textField_1.setText((Controller.ottieniEsitoAppuntamento(CF, Integer.parseInt(id))));
					
				}
			}
		});
		btnNewButton.setBounds(116, 303, 105, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Appuntamento");
		lblNewLabel.setBounds(10, 11, 129, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(20, 281, 33, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		JButton btnNewButton_1 = new JButton("Modifica");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret=0;
				String id = textField.getText();
				String testo = editorPane.getText();
				String esito = textField_1.getText(); //TODO: metti in ComboBox
				
				try {
					Controller.isNotaValida(testo);
					if (Integer.parseInt(esito)<0 || Integer.parseInt(esito)>1){
						JOptionPane.showMessageDialog(btnNewButton, "Esito Non Valido", "Error", JOptionPane.PLAIN_MESSAGE);
					}	else {
						ret=Controller.modificaNoteAppuntamento(CF, Integer.parseInt(id), testo,Integer.parseInt(esito));
						if(ret>0) {
							JOptionPane.showMessageDialog(btnNewButton, "Appuntamento "+id+" modificato con successo!", "Plain Text", JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(btnNewButton, "Non modificato!", "Error", JOptionPane.PLAIN_MESSAGE);
						}
					
					}
				} catch (NoteNonValide n) {
					JOptionPane.showMessageDialog(btnNewButton, "Note Non Valide", "Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(473, 302, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(377, 304, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Esito [0: OK; 1: Fallito]");
		lblNewLabel_2.setBounds(377, 281, 185, 14);
		contentPane.add(lblNewLabel_2);
	}
}
