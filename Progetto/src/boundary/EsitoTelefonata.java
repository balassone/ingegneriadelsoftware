package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;
import exceptions.DataNonValida;
import exceptions.EsitoTelefonataNonValido;
import exceptions.OraNonValida;
import exceptions.NoteNonValide;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class EsitoTelefonata extends JFrame {

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
		super();
	}
	
	public EsitoTelefonata(int idCentralinista) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/ciuccio.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(new Color(30, 144, 255));
		panel_1_1_1_1.setBounds(10, 54, 50, 30);
		contentPane.add(panel_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Data:");
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		panel_1_1_1_1.add(lblNewLabel_4_1_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(30, 144, 255));
		panel_1_1_1.setBounds(10, 102, 50, 30);
		contentPane.add(panel_1_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Ora:");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		panel_1_1_1.add(lblNewLabel_4_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(30, 144, 255));
		panel_1_1.setBounds(10, 148, 50, 30);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Note:");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		panel_1_1.add(lblNewLabel_4_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 140, 30);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Registra Esito");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(60, 54, 80, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(60, 102, 80, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(60, 148, 364, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		String[] nums = {"1","2","3","4","5"};
		JComboBox comboBox = new JComboBox(nums);
		comboBox.setBounds(60, 198, 40, 30);
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
		
		JButton btnNewButton = new JButton("Registra");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret=0;
				String data = textField.getText();
				String ora = textField_1.getText();
				String note = textField_2.getText();
				String esitos = (String) comboBox.getSelectedItem();
				int esito = Integer.parseInt(esitos);
				
				try {
					Controller.isDataValida(data);
					Controller.isOraValida(ora);
					Controller.isNotaValida(note);
					ret = Controller.registraEsitoChiamata(data, ora, note, esito, idCentralinista);
					if(ret>0) {
						JOptionPane.showMessageDialog(btnNewButton, "Telefonata inserita correttamente con id="+ret, "Plain Text", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Telefonata non inserita", "Error", JOptionPane.PLAIN_MESSAGE);
					}
					if(esito==5) {
						new CreaAppuntamento(ret).setVisible(true);
					}
				
				} catch (OraNonValida ex) {
					JOptionPane.showMessageDialog(btnNewButton, "Ora Non Valida", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				 catch (DataNonValida da) {
					JOptionPane.showMessageDialog(btnNewButton, "Data Non Valida", "Error", JOptionPane.PLAIN_MESSAGE);
				} catch (NoteNonValide no) {
					JOptionPane.showMessageDialog(btnNewButton, "Note Non Valide", "Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
			
		});
		btnNewButton.setBounds(335, 227, 89, 30);
		contentPane.add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setForeground(new Color(255, 255, 255));
		textPane.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		textPane.setBackground(new Color(0, 80, 159));
		textPane.setBounds(219, 39, 190, 83);
		textPane.setText("1. occupato\n2. senza risposta\n3. da richiamare\n4. non interessato\n5. appuntamento fissato");
		contentPane.add(textPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(10, 198, 50, 30);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Esito:");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel_4);
		
		JLabel sfondo = new JLabel("");
		sfondo.setIcon(new ImageIcon(this.getClass().getResource("/images/istockphoto-899394070-612x612.jpg")));
		sfondo.setBounds(0, 0, 440, 270);
		contentPane.add(sfondo);
	}
}
