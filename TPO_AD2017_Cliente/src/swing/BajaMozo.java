package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaMozo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDocumento;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldComision;
	private JTextField textFieldIngresar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaMozo frame = new BajaMozo();
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
	public BajaMozo() {
		setTitle("Eliminar Mozo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 742);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresarDni = new JLabel("Documento Nacional de Identidad:");
		lblIngresarDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngresarDni.setBounds(86, 166, 295, 28);
		contentPane.add(lblIngresarDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(211, 275, 198, 28);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellido.setBounds(204, 380, 175, 28);
		contentPane.add(lblApellido);
		
		JLabel lblPorcentajeDeComision = new JLabel("Porcentaje de Comision:");
		lblPorcentajeDeComision.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPorcentajeDeComision.setBounds(168, 504, 213, 22);
		contentPane.add(lblPorcentajeDeComision);
		
		textFieldDocumento = new JTextField();
		textFieldDocumento.setEditable(false);
		textFieldDocumento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldDocumento.setBounds(390, 166, 421, 35);
		contentPane.add(textFieldDocumento);
		textFieldDocumento.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNombre.setBounds(390, 272, 261, 35);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setEditable(false);
		textFieldApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldApellido.setBounds(391, 378, 260, 35);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldComision = new JTextField();
		textFieldComision.setEditable(false);
		textFieldComision.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldComision.setBounds(393, 498, 258, 35);
		contentPane.add(textFieldComision);
		textFieldComision.setColumns(10);
		
		JButton btnBorrar = new JButton("Eliminar Mozo");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBorrar.setBounds(275, 615, 147, 48);
		contentPane.add(btnBorrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
				principal.setVisible(true);
			}
		});
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
		btnVolver.setBounds(487, 615, 147, 48);
		contentPane.add(btnVolver);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Principal.class.getResource("/swing/logo.jpg")));
		//lblIcono.setBounds((int) ((int) width/2.65), (int) ((int) height/2.9), 418, 278);
		lblIcono.setBounds((int) width-400, (int) ((int) height-((int)height*0.40)), 418, 278);
		contentPane.add(lblIcono);
		
		JLabel lblIngresarDniDel = new JLabel("Ingresar DNI del Mozo:");
		lblIngresarDniDel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngresarDniDel.setBounds(26, 40, 244, 28);
		contentPane.add(lblIngresarDniDel);
		
		textFieldIngresar = new JTextField();
		textFieldIngresar.setBounds(237, 40, 352, 28);
		contentPane.add(textFieldIngresar);
		textFieldIngresar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(637, 40, 136, 48);
		contentPane.add(btnBuscar);
	}

}
