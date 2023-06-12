package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.Controller;
import entity.EntityNumeroTelefonico;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class CentralinistaView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<String> nums;
	private int i;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CentralinistaView frame = new CentralinistaView();
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
	
	public CentralinistaView() {
		super();
	}
	public CentralinistaView(int id) {
		nums = Controller.numeriDaChiamare(id);
		i=0;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Prossimo Numero!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(nums.get(i));
				i=(i+1)%(nums.size());
			}
		});
		btnNewButton.setBounds(49, 43, 157, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(242, 44, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("Centralinista: "+Controller.datiCentralinista(id));
		lblNewLabel.setBounds(10, 11, 307, 14);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Registra Esito");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EsitoTelefonata(id).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(115, 115, 205, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Referenzia Appuntamenti");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Referenzia().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(115, 171, 205, 23);
		contentPane.add(btnNewButton_2);
	}

}
