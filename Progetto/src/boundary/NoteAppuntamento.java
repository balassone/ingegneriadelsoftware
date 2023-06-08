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
import javax.swing.JEditorPane;

public class NoteAppuntamento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(173, 303, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(20, 36, 561, 256);
		contentPane.add(editorPane);
		
		JButton btnNewButton = new JButton("Visualizza");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				if(!id.isEmpty()) {
					editorPane.setText(Controller.ottieniNoteAppuntamento("ABCDEF00D11H123N", Integer.parseInt(id)));
				}
			}
		});
		btnNewButton.setBounds(300, 302, 105, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Note Appuntamento");
		lblNewLabel.setBounds(10, 11, 129, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(139, 306, 33, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		JButton btnNewButton_1 = new JButton("Modifica");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret=0;
				String id = textField.getText();
				String testo = editorPane.getText();
				if(testo.isEmpty() || testo.length()>1000) {
					JOptionPane.showMessageDialog(btnNewButton, "Note Non Valide", "Error", JOptionPane.PLAIN_MESSAGE);
				} else {
					ret=Controller.modificaNoteAppuntamento("ABCDEF00D11H123N", Integer.parseInt(id), testo);
					if(ret>0) {
						JOptionPane.showMessageDialog(btnNewButton, "Note dell'appuntamento "+id+" modificate con successo!", "Plain Text", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Note non modificate!", "Error", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		btnNewButton_1.setBounds(473, 302, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
