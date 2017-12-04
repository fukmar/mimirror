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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarSector extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIngresar;
	private JTextField textFieldCod;
	private JTextField textFieldDescp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarSector frame = new ModificarSector();
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
	public ModificarSector() {
		setTitle("Modificar Sector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 742);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresarCodigoDe = new JLabel("Ingresar codigo de sector:");
		lblIngresarCodigoDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngresarCodigoDe.setBounds(35, 71, 249, 42);
		contentPane.add(lblIngresarCodigoDe);
		
		textFieldIngresar = new JTextField();
		textFieldIngresar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldIngresar.setBounds(306, 71, 332, 42);
		contentPane.add(textFieldIngresar);
		textFieldIngresar.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigo.setBounds(35, 271, 150, 22);
		contentPane.add(lblCodigo);
		
		textFieldCod = new JTextField();
		textFieldCod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCod.setEditable(false);
		textFieldCod.setBounds(130, 268, 231, 33);
		contentPane.add(textFieldCod);
		textFieldCod.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescripcion.setBounds(373, 268, 172, 33);
		contentPane.add(lblDescripcion);
		
		textFieldDescp = new JTextField();
		textFieldDescp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldDescp.setEditable(false);
		textFieldDescp.setBounds(493, 268, 307, 33);
		contentPane.add(textFieldDescp);
		textFieldDescp.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(424, 151, 163, 42);
		contentPane.add(btnBuscar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModificar.setBounds(196, 400, 150, 50);
		contentPane.add(btnModificar);
		
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
		btnVolver.setBounds(431, 400, 172, 50);
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
