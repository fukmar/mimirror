package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.BusinessDelegate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import dto.*;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaMozo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDocumento;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldComision;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaMozo frame = new AltaMozo();
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
	public AltaMozo() {
		setTitle("Crear Mozo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 682);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresarDni = new JLabel("Documento Nacional de Identidad:");
		lblIngresarDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngresarDni.setBounds(12, 63, 295, 28);
		contentPane.add(lblIngresarDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(137, 172, 198, 28);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellido.setBounds(130, 278, 175, 28);
		contentPane.add(lblApellido);
		
		JLabel lblPorcentajeDeComision = new JLabel("Porcentaje de Comision:");
		lblPorcentajeDeComision.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPorcentajeDeComision.setBounds(94, 402, 213, 22);
		contentPane.add(lblPorcentajeDeComision);
		
		textFieldDocumento = new JTextField();
		textFieldDocumento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldDocumento.setBounds(316, 63, 421, 35);
		contentPane.add(textFieldDocumento);
		textFieldDocumento.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNombre.setBounds(316, 169, 261, 35);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldApellido.setBounds(317, 275, 260, 35);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldComision = new JTextField();
		textFieldComision.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldComision.setBounds(319, 396, 258, 35);
		contentPane.add(textFieldComision);
		textFieldComision.setColumns(10);
		
		JButton btnCrearMozo = new JButton("Crear Mozo");
		btnCrearMozo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MozoDTO mozo= new  MozoDTO(Integer.parseInt(textFieldDocumento.getText()), textFieldNombre.getText(), textFieldApellido.getText(),Float.parseFloat(textFieldComision.getText()) );
				//BusinessDelegate.getInstance().grabarMozo(mozo);
				JOptionPane.showMessageDialog(null, "Mozo creado exitosamente", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
				textFieldDocumento.setText("");
				textFieldNombre.setText("");
				textFieldApellido.setText("");
				textFieldComision.setText("");		
				
			}
		});
		btnCrearMozo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCrearMozo.setBounds(201, 513, 147, 48);
		contentPane.add(btnCrearMozo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Principal principal = new Principal();
				principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
				principal.setVisible(true);
				
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(413, 513, 147, 48);
		contentPane.add(btnVolver);
		
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
