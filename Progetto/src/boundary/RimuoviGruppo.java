package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RimuoviGruppo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RimuoviGruppo frame = new RimuoviGruppo();
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
	public RimuoviGruppo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Rimuovi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret = 0;
				String gruppo = textField.getText();
				if(!gruppo.isEmpty()) {
					if(Controller.trovaGruppo(Integer.parseInt(gruppo))>0) {
						ret = Controller.rimuoviGruppo(Integer.parseInt(gruppo));
						if(ret>0) {
							JOptionPane.showMessageDialog(btnNewButton, "Gruppo rimosso correttamente!", "Plain Text", JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(btnNewButton, "Gruppo non rimosso!", "Error", JOptionPane.PLAIN_MESSAGE);
						}
					}
				}
				
			}
		});
		btnNewButton.setBounds(161, 131, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Rimuovi Gruppo");
		lblNewLabel.setBounds(10, 11, 101, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(161, 100, 89, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
