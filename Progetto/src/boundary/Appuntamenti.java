package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;
import entity.EntityAppuntamento;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Appuntamenti extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appuntamenti frame = new Appuntamenti();
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
	
	public Appuntamenti() {
		super();
	}
	public Appuntamenti(String CF) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 699, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 11, 663, 475);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("Ottieni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = new String();
				ArrayList<EntityAppuntamento> a = Controller.ottieniAppuntamenti(CF);
				for(int i=0; i<a.size(); i++) {
					s=s+a.get(i).toString();
				}
				textPane.setText(s);
			}
		});
		btnNewButton.setBounds(300, 497, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
