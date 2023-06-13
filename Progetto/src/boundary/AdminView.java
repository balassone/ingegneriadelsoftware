package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

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
	
	/*
	 * AdminView consiste in una finestra dotata di 3 pulsanti, a seconda di chi utilizzerà il sistema.
	 * 
	 * Si assume che il centralinista che si logga sia il Centralinista con ID=2;
	 * Si assume che l'agente di vendita che si logga sia l'Agente con CF="ABCDEF00D11H123N"
	 * 
	 * */
	
	public AdminView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\simone\\Documents\\Call Center\\ingegneriadelsoftware-main\\ingegneriadelsoftware-main\\media\\ciuccio.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Crea Lista");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CreaLista().setVisible(true);
				
			}
		});
		btnNewButton.setBounds(34, 62, 136, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Aggiungi Numero");
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AggiungiNumero().setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(34, 125, 136, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Rimuovi Numero");
		btnNewButton_2.setBackground(new Color(30, 144, 255));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new RimuoviNumero().setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(34, 189, 136, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Crea Gruppo");
		btnNewButton_3.setBackground(new Color(30, 144, 255));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CreaGruppo().setVisible(true);
				
			}
		});
		btnNewButton_3.setBounds(249, 62, 136, 36);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Rimuovi Gruppo");
		btnNewButton_4.setBackground(new Color(30, 144, 255));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new RimuoviGruppo().setVisible(true);				
			}
		});
		btnNewButton_4.setBounds(249, 125, 136, 36);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Assegna Lista");
		btnNewButton_5.setBackground(new Color(30, 144, 255));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AssegnaListaGruppo().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(249, 189, 136, 36);
		contentPane.add(btnNewButton_5);
		
		JLabel sfondo = new JLabel("");
		sfondo.setIcon(new ImageIcon("C:\\Users\\simone\\Documents\\Call Center\\ingegneriadelsoftware-main\\ingegneriadelsoftware-main\\media\\istockphoto-899394070-612x612.jpg"));
		sfondo.setBounds(0, 0, 440, 270);
		contentPane.add(sfondo);
	}
}
