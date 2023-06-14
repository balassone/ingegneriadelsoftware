package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class NoteChiamata extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoteChiamata frame = new NoteChiamata();
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
	
	public NoteChiamata() {
		super();
	}
	
	public NoteChiamata(String CF) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/ciuccio.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(173, 305, 30, 30);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_1);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnAnnulla.setBackground(new Color(30, 144, 255));
		btnAnnulla.setForeground(new Color(255, 255, 255));
		btnAnnulla.setBounds(492, 305, 89, 30);
		contentPane.add(btnAnnulla);
		
		btnAnnulla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 40, 571, 252);
		contentPane.add(textPane);
		
		textField = new JTextField();
		textField.setBounds(203, 305, 56, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Visualizza");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				if(!id.isEmpty()) {
					textPane.setText(Controller.visualizzaNoteChiamata(CF, Integer.parseInt(id)));
					textPane.setEditable(false);
				}
			}
		});
		btnNewButton.setBounds(300, 305, 105, 30);
		contentPane.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(10, 11, 105, 30);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Note Chiamata:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		panel_1.add(lblNewLabel_1_1);
		
		JLabel sfondo = new JLabel("");
		sfondo.setIcon(new ImageIcon(this.getClass().getResource("/bigger.jpg")));
		sfondo.setBounds(0, 0, 591, 356);
		contentPane.add(sfondo);
	}
}
