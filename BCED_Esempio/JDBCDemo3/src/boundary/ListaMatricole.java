package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListaMatricole extends JDialog {

	public ArrayList<String> matricole;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaMatricole dialog = new ListaMatricole();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaMatricole() {
		setBounds(100, 100, 450, 300);
		{
			getContentPane().setLayout(null);
		}
		
		JPanel Contentpanel = new JPanel();
		Contentpanel.setBounds(0, 11, 436, 215);
		getContentPane().add(Contentpanel);
		Contentpanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista Matricole");
		lblNewLabel.setBounds(10, 11, 122, 14);
		Contentpanel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 36, 291, 140);
		Contentpanel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 226, 426, 37);
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Cerca Studenti");
		btnNewButton.setBounds(145, 4, 135, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ArrayList<String> matricole = new ArrayList<String>();
				
							
				matricole = Controller.elencoMatricole();
				
				textArea.setText("");
				
				for(int i=0; i<matricole.size();i++) {
					
					textArea.append(matricole.get(i)+"\n");
					//System.out.println(matricole.get(i));
				}
				
			}
		});
		panel.setLayout(null);
		
		panel.add(btnNewButton);
				
	
	}
}
