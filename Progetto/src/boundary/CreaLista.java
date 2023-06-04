package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import control.Centralino;
public class CreaLista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreaLista frame = new CreaLista();
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
	public CreaLista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Creazione lista");
		lblNewLabel.setBounds(10, 11, 187, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 85, 414, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Inserisci");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret=0;
				String text = textField.getText();
				if(!text.isEmpty()) {
					ret = Centralino.creaLista(text);
				}
				
				if(ret>0) {
					JOptionPane.showMessageDialog(btnNewButton, "Lista inserita correttamente", "Plain Text", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Lista non inserita", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nome lista:");
		lblNewLabel_1.setBounds(10, 60, 81, 14);
		contentPane.add(lblNewLabel_1);
	}
}
