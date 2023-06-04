package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Centralino;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
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
	public AdminView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Crea Lista");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CreaLista().setVisible(true);
				
			}
		});
		btnNewButton.setBounds(34, 62, 136, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Aggiungi Numero");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AggiungiNumero().setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(34, 125, 136, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Rimuovi Numero");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new RimuoviNumero().setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(34, 189, 136, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Crea Gruppo");
		btnNewButton_3.setBounds(249, 62, 136, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Rimuovi Gruppo");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new RimuoviGruppo().setVisible(true);				
			}
		});
		btnNewButton_4.setBounds(249, 125, 136, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Assegna Lista");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AssegnaListaGruppo().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(249, 189, 136, 23);
		contentPane.add(btnNewButton_5);
	}
}
