package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaElaborado extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTipo;
	private JTextField textFieldCantidad;
	private JTextField textFieldDescp;
	private JTextField textFieldCant;
	private JTextField textFieldCaducidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaElaborado frame = new AltaElaborado();
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
	public AltaElaborado() {
		setTitle("Crear Producto Elaborado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 765);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipo.setBounds(12, 48, 117, 26);
		contentPane.add(lblTipo);
		
		JLabel lblCalidad = new JLabel("Calidad:");
		lblCalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCalidad.setBounds(12, 118, 117, 26);
		contentPane.add(lblCalidad);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescripcion.setBounds(12, 188, 117, 26);
		contentPane.add(lblDescripcion);
		
		JLabel lblPlanDeProduccion = new JLabel("Plan de Produccion:");
		lblPlanDeProduccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlanDeProduccion.setBounds(12, 267, 175, 26);
		contentPane.add(lblPlanDeProduccion);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidad.setBounds(12, 343, 117, 26);
		contentPane.add(lblCantidad);
		
		JLabel lblCaducidad = new JLabel("Caducidad:");
		lblCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCaducidad.setBounds(12, 430, 117, 33);
		contentPane.add(lblCaducidad);
		
		JLabel lblUnidad = new JLabel("Unidad:");
		lblUnidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUnidad.setBounds(12, 523, 117, 26);
		contentPane.add(lblUnidad);
		
		JLabel lblSemielaborados = new JLabel("SemiElaborados:");
		lblSemielaborados.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSemielaborados.setBounds(12, 610, 175, 26);
		contentPane.add(lblSemielaborados);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldTipo.setBounds(242, 52, 193, 33);
		contentPane.add(textFieldTipo);
		textFieldTipo.setColumns(10);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(242, 122, 193, 33);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		textFieldDescp = new JTextField();
		textFieldDescp.setBounds(242, 192, 193, 33);
		contentPane.add(textFieldDescp);
		textFieldDescp.setColumns(10);
		
		JComboBox comboBoxPdP = new JComboBox();
		comboBoxPdP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CODIGO PARA TRAER TODOS LOS PDP
			}
		});
		comboBoxPdP.setBounds(242, 271, 193, 33);
		contentPane.add(comboBoxPdP);
		
		textFieldCant = new JTextField();
		textFieldCant.setBounds(242, 347, 193, 33);
		contentPane.add(textFieldCant);
		textFieldCant.setColumns(10);
		
		textFieldCaducidad = new JTextField();
		textFieldCaducidad.setBounds(242, 437, 193, 33);
		contentPane.add(textFieldCaducidad);
		textFieldCaducidad.setColumns(10);
		
		JComboBox comboBoxUnidad = new JComboBox();
		comboBoxUnidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CODIGO PARA TRAER TODAS LAS UNIDADES
				
			}
		});
		comboBoxUnidad.setBounds(242, 527, 193, 33);
		contentPane.add(comboBoxUnidad);
		
		JButton btnCrearProducto = new JButton("Crear Producto");
		btnCrearProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//CODIGO PARA ALTA DEL PRODUCTO
				
			}
		});
		btnCrearProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCrearProducto.setBounds(544, 196, 181, 55);
		contentPane.add(btnCrearProducto);
		
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
		btnVolver.setBounds(544, 351, 181, 55);
		contentPane.add(btnVolver);
	}
}
