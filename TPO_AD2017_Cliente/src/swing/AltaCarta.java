package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaCarta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCarta frame = new AltaCarta();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
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
	public AltaCarta() {
		setTitle("Crear Carta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 532);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSalon = new JLabel("Salon:");
		lblSalon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSalon.setBounds(12, 32, 84, 30);
		contentPane.add(lblSalon);
		
		JLabel lblArea = new JLabel("Area:");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArea.setBounds(12, 119, 73, 38);
		contentPane.add(lblArea);
		
		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLocal.setBounds(12, 215, 84, 38);
		contentPane.add(lblLocal);
		
		JButton btnCrearCarta = new JButton("Crear Carta");
		btnCrearCarta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCrearCarta.setBounds(70, 333, 156, 38);
		contentPane.add(btnCrearCarta);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
				principal.setVisible(true);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(256, 333, 178, 38);
		contentPane.add(btnVolver);
		
		JComboBox comboBoxSalon = new JComboBox();
		comboBoxSalon.setBounds(123, 32, 294, 30);
		contentPane.add(comboBoxSalon);
		
		JComboBox comboBoxArea = new JComboBox();
		comboBoxArea.setBounds(123, 129, 294, 28);
		contentPane.add(comboBoxArea);
		
		JComboBox comboBoxLocal = new JComboBox();
		comboBoxLocal.setBounds(123, 215, 299, 30);
		contentPane.add(comboBoxLocal);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Principal.class.getResource("/swing/logo.jpg")));
		//lblIcono.setBounds((int) ((int) width/2.65), (int) ((int) height/2.9), 418, 278);
		lblIcono.setBounds((int) width-400, (int) ((int) height-((int)height*0.40)), 418, 278);
		contentPane.add(lblIcono);
	}
}
