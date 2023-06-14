package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class LoginAgente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAgente frame = new LoginAgente();
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
	public LoginAgente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/ciuccio.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(25, 25, 112));
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(75, 109, 40, 30);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("CF:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cf = textField.getText();
				if(!cf.isEmpty()) {
					if(Controller.trovaAgente(cf)>0) {
						JOptionPane.showMessageDialog(btnNewButton, "Benvenuto, Agente!", "Login effettuato", JOptionPane.PLAIN_MESSAGE);
						new AgenteView(cf).setVisible(true);
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Agente Non Esistente", "Error", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(25, 25, 112));
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 191, 30);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Login Agente di Vendita");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnNewButton.setBounds(167, 160, 89, 36);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(114, 109, 231, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel sfondo = new JLabel("");
		sfondo.setIcon(new ImageIcon(this.getClass().getResource("/istockphoto-899394070-612x612.jpg")));
		sfondo.setBounds(0, 0, 440, 270);
		contentPane.add(sfondo);
	}
}
