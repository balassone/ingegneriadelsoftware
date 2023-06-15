package boundary;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/images/ciuccio.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/images/inkpx-word-art2.png")));
		lblNewLabel.setBounds(87, 50, 475, 128);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new AdminView().setVisible(true);
				
			}
		});
		btnNewButton.setBounds(50, 220, 126, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Centralinista");
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new LoginCentralinista().setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(262, 220, 126, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Agente");
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(30, 144, 255));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new LoginAgente().setVisible(true);
				
				
			}
		});
		btnNewButton_2.setBounds(474, 220, 126, 36);
		contentPane.add(btnNewButton_2);
		
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/images/ciuccio.png"));
		int newWidth = imageIcon.getIconWidth() / 10;
        int newHeight = imageIcon.getIconHeight() / 10;
		ImageIcon resizedIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(resizedIcon);
		lblNewLabel_1.setBounds(430, 2, 91, 91);
		contentPane.add(lblNewLabel_1);
		
		JLabel sfondo = new JLabel("");
		sfondo.setIcon(new ImageIcon(MainFrame.class.getResource("/images/bigger.jpg")));
		sfondo.setBounds(0, 0, 650, 450);
		contentPane.add(sfondo);
	}
}
