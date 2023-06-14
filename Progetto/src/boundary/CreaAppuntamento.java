package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
import javax.swing.SwingConstants;
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/ciuccio.png")));
		this.callID=id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(30, 144, 255));
		panel_1_1_1.setBounds(10, 158, 70, 30);
		contentPane.add(panel_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CF Agente:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		panel_1_1_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(30, 144, 255));
		panel_1_1.setBounds(10, 102, 70, 30);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ora:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		panel_1_1.add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(10, 54, 70, 30);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Data:");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 200, 30);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Creazione Appuntamento");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(80, 54, 86, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 102, 86, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox(Controller.agentiDisponibili());
		comboBox.setBounds(80, 158, 146, 30);
		contentPane.add(comboBox);
		
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
		
		JButton btnNewButton = new JButton("Crea");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ret=0;
				String data = textField.getText();
				String ora = textField_1.getText();
				String agente = (String) comboBox.getSelectedItem();
				
				
				try {
					Controller.isDataValida(data);
				
					Controller.isOraValida(ora);
					
					ret = Controller.creaAppuntamento(data, ora, agente,callID);
					if(ret>0) {
						JOptionPane.showMessageDialog(btnNewButton, "Appuntamento inserito correttamente con id="+ret, "Plain Text", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Appuntamento non inserita", "Error", JOptionPane.PLAIN_MESSAGE);
					}
					
					// No controlli sull'agente perché si è forzati ad inserirne uno esistente
						
				} catch (OraNonValida ex) {
					JOptionPane.showMessageDialog(btnNewButton, "Ora Non Valida", "Error", JOptionPane.PLAIN_MESSAGE);
				
				} catch (DataNonValida ex) {
					JOptionPane.showMessageDialog(btnNewButton, "Data Non Valida", "Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(335, 227, 89, 30);
		contentPane.add(btnNewButton);
		
		JLabel sfondo = new JLabel("");
		sfondo.setIcon(new ImageIcon(this.getClass().getResource("/images/istockphoto-899394070-612x612.jpg")));
		sfondo.setBounds(0, 0, 440, 270);
		contentPane.add(sfondo);
	}
}

