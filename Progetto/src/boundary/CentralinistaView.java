package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.Centralino;
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
	private ArrayList<EntityNumeroTelefonico> nums;
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
		nums = Centralino.numeriDaChiamare(2);
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
				textField.setText(nums.get(i).getNumero());
				i=(i+1)%(nums.size());
			}
		});
		btnNewButton.setBounds(49, 43, 157, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(242, 44, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Centralinista");
		lblNewLabel.setBounds(10, 11, 94, 14);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Registra Esito");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EsitoTelefonata().setVisible(true);
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
