package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;
import exceptions.GruppoNonTrovato;
import exceptions.ListaNonTrovata;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/ciuccio.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		textField_2.setBackground(new Color(0, 80, 159));
		textField_2.setBounds(303, 82, 107, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 200, 30);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Assegna Lista a Gruppo");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(65, 82, 40, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(65, 163, 40, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
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
		btnNewButton.setBounds(135, 82, 133, 30);
		contentPane.add(btnNewButton);
		
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
		
		JButton btnNewButton_2 = new JButton("Assegna");
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton_2.setBackground(new Color(30, 144, 255));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
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
		btnNewButton_2.setBounds(335, 227, 89, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Check Gruppo");
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
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
		btnNewButton_1.setBounds(135, 163, 133, 30);
		contentPane.add(btnNewButton_1);
		
		
		
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(255, 255, 255));
		textField_3.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(0, 80, 159));
		textField_3.setBounds(303, 163, 107, 30);
		contentPane.add(textField_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(10, 82, 55, 30);
		contentPane.add(panel_1);
		JLabel lblNewLabel_1 = new JLabel("Lista:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(30, 144, 255));
		panel_1_1.setBounds(10, 163, 55, 30);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gruppo:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel sfondo = new JLabel("");
		sfondo.setIcon(new ImageIcon(this.getClass().getResource("/istockphoto-899394070-612x612.jpg")));
		sfondo.setBounds(0, 0, 440, 270);
		contentPane.add(sfondo);
	}

}
