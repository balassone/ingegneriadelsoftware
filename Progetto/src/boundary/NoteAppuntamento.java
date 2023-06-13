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
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import control.Controller;
import exceptions.NoteNonValide;

import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class NoteAppuntamento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	//private JTextField textField_1;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\simone\\Documents\\Call Center\\ingegneriadelsoftware-main\\ingegneriadelsoftware-main\\media\\ciuccio.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] nums = {"0","1"};
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(30, 144, 255));
		panel_1_1.setBounds(20, 20, 140, 30);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Appuntamento:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(284, 300, 140, 30);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Esito [0: OK; 1: Fallito]");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(20, 300, 30, 30);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_1);
		JComboBox<String> comboBox = new JComboBox(nums);
		comboBox.setBounds(423, 300, 40, 30);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(50, 300, 56, 30);
		contentPane.add(textField);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(20, 50, 561, 206);
		contentPane.add(editorPane);
		
		JButton btnNewButton = new JButton("Visualizza");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				if(!id.isEmpty()) {
					editorPane.setText(Controller.ottieniNoteAppuntamento(CF, Integer.parseInt(id)));
					comboBox.setSelectedItem((Controller.ottieniEsitoAppuntamento(CF, Integer.parseInt(id))));
					
				}
			}
		});
		btnNewButton.setBounds(116, 300, 105, 30);
		contentPane.add(btnNewButton);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnAnnulla.setBackground(new Color(30, 144, 255));
		btnAnnulla.setForeground(new Color(255, 255, 255));
		btnAnnulla.setBounds(495, 356, 89, 30);
		contentPane.add(btnAnnulla);
		
		btnAnnulla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
		
		JButton btnNewButton_1 = new JButton("Modifica");
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret=0;
				String id = textField.getText();
				String testo = editorPane.getText();
				String esito = (String) comboBox.getSelectedItem();
				
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
		btnNewButton_1.setBounds(473, 300, 89, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel sfondo = new JLabel("");
		sfondo.setIcon(new ImageIcon("C:\\Users\\simone\\Documents\\Call Center\\ingegneriadelsoftware-main\\ingegneriadelsoftware-main\\media\\bigger.jpg"));
		sfondo.setBounds(0, 0, 590, 391);
		contentPane.add(sfondo);
	}
}
