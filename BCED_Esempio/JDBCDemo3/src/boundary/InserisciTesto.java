package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InserisciTesto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_idTesto;
	private JTextField textField_nome;
	private JTextField textField_idCorso;
	private JTextField textOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InserisciTesto dialog = new InserisciTesto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InserisciTesto() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblidtesto = new JLabel("idTesto");
			lblidtesto.setBounds(10, 11, 48, 14);
			contentPanel.add(lblidtesto);
		}
		
		textField_idTesto = new JTextField();
		textField_idTesto.setEditable(false);
		textField_idTesto.setBounds(84, 8, 96, 20);
		contentPanel.add(textField_idTesto);
		textField_idTesto.setColumns(10);
		{
			JLabel lblNome = new JLabel("nome");
			lblNome.setBounds(9, 45, 49, 14);
			contentPanel.add(lblNome);
		}
		{
			textField_nome = new JTextField();
			textField_nome.setEditable(false);
			textField_nome.setBounds(84, 42, 96, 20);
			contentPanel.add(textField_nome);
			textField_nome.setColumns(10);
		}
		{
			JLabel lbl_idCorso = new JLabel("idCorso");
			lbl_idCorso.setBounds(10, 82, 49, 14);
			contentPanel.add(lbl_idCorso);
		}
		{
			textField_idCorso = new JTextField();
			textField_idCorso.setBounds(84, 79, 96, 20);
			contentPanel.add(textField_idCorso);
			textField_idCorso.setColumns(10);
			
		}
		
		JButton btn_checkCorso = new JButton("Check Corso");
		btn_checkCorso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				String id = textField_idCorso.getText();
				
				int i = Controller.CercaTesto(Integer.parseInt(id));
				
				if(i==1) {
					
					//se ho trovato il corso
					textField_idTesto.setEditable(true);
					textField_nome.setEditable(true);
					
					textOut.setText("Corso Trovato");
				
				}else {
					
					textOut.setText("Corso non trovato");
				}
			}
		});
		btn_checkCorso.setBounds(190, 78, 123, 23);
		contentPanel.add(btn_checkCorso);
		
		textOut = new JTextField();
		textOut.setEditable(false);
		textOut.setBounds(145, 164, 143, 20);
		contentPanel.add(textOut);
		textOut.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Inserisci Testo");
				
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {					
						
						
						int ret = -1;
						
						String id_corso = textField_idCorso.getText();
						String idTesto = textField_idTesto.getText();
						String nome = textField_nome.getText();
						
						ret = Controller.InserisciTesto(Integer.parseInt(idTesto), nome, Integer.parseInt(id_corso));
						
						
						System.out.println(ret);
						
						if(ret!=-1) {
							
							JOptionPane.showMessageDialog(okButton, "Testo inserito correttamente", "Plain Text", JOptionPane.PLAIN_MESSAGE);


						}else {
							
							JOptionPane.showMessageDialog(okButton, "Inserimennto non è andato a buon fine", "Error", JOptionPane.ERROR_MESSAGE);

						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
