package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.Controller;
import exceptions.ListaNonTrovata;
import exceptions.NumeroNonValido;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class RimuoviNumero extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RimuoviNumero frame = new RimuoviNumero();
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
	public RimuoviNumero() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\simone\\Documents\\Call Center\\ingegneriadelsoftware-main\\ingegneriadelsoftware-main\\media\\ciuccio.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 140, 30);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Rimuovi Numero");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBounds(10, 73, 56, 30);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Id Lista:");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Check Lista");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
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
		btnNewButton.setBounds(135, 73, 139, 30);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(70, 132, 145, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnAnnulla.setBackground(new Color(30, 144, 255));
		btnAnnulla.setForeground(new Color(255, 255, 255));
		btnAnnulla.setBounds(242, 227, 89, 30);
		contentPane.add(btnAnnulla);
		
		btnAnnulla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
		
		JButton btnNewButton_1 = new JButton("Rimuovi");
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret=0;
				String numero = textField_1.getText();	
				try {
					Controller.isNumeroTelefonoValido(numero);
					ret = Controller.rimuoviNumero(Integer.parseInt(textField.getText()), numero);
					if(ret>0) {
						JOptionPane.showMessageDialog(btnNewButton, "Numero rimosso correttamente dalla lista "+textField.getText()+"!", "Plain Text", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Numero non rimosso!", "Error", JOptionPane.PLAIN_MESSAGE);
					}
				} catch (NumeroNonValido ex) {
					JOptionPane.showMessageDialog(btnNewButton, "Numero non valido!", "Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(335, 227, 89, 30);
		contentPane.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		textField_2.setBackground(new Color(0, 80, 159));
		textField_2.setBounds(303, 73, 107, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(65, 73, 40, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(Color.WHITE);
		panel_1_1.setBackground(new Color(30, 144, 255));
		panel_1_1.setBounds(10, 132, 60, 30);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Numero:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel sfondo = new JLabel("");
		sfondo.setIcon(new ImageIcon("C:\\Users\\simone\\Documents\\Call Center\\ingegneriadelsoftware-main\\ingegneriadelsoftware-main\\media\\istockphoto-899394070-612x612.jpg"));
		sfondo.setBounds(0, 0, 440, 270);
		contentPane.add(sfondo);
	}

}
