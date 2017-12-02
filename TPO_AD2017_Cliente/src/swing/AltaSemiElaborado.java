package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AltaSemiElaborado extends JFrame {

	private JPanel contentPane;
	private JTextField textTipo;
	private JTextField textCalidad;
	private JTextField textDescripcion;
	private JTextField textCantidad;
	private JTextField textCaducidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaSemiElaborado frame = new AltaSemiElaborado();
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
	public AltaSemiElaborado() {
		setTitle("Crear Plato SemiElaborado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1077, 745);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipo.setBounds(12, 60, 134, 36);
		contentPane.add(lblTipo);
		
		JLabel lblCalidad = new JLabel("Calidad:");
		lblCalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCalidad.setBounds(12, 138, 134, 36);
		contentPane.add(lblCalidad);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescripcion.setBounds(12, 218, 134, 36);
		contentPane.add(lblDescripcion);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidad.setBounds(12, 312, 134, 36);
		contentPane.add(lblCantidad);
		
		JLabel lblCaducidad = new JLabel("Caducidad:");
		lblCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCaducidad.setBounds(12, 399, 134, 36);
		contentPane.add(lblCaducidad);
		
		JLabel lblUnidad = new JLabel("Unidad:");
		lblUnidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUnidad.setBounds(12, 490, 134, 36);
		contentPane.add(lblUnidad);
		
		textTipo = new JTextField();
		textTipo.setBounds(175, 66, 318, 36);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		textCalidad = new JTextField();
		textCalidad.setColumns(10);
		textCalidad.setBounds(175, 147, 318, 36);
		contentPane.add(textCalidad);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(175, 227, 318, 36);
		contentPane.add(textDescripcion);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(175, 312, 318, 36);
		contentPane.add(textCantidad);
		
		textCaducidad = new JTextField();
		textCaducidad.setColumns(10);
		textCaducidad.setBounds(175, 400, 318, 36);
		contentPane.add(textCaducidad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(175, 490, 318, 36);
		contentPane.add(comboBox);
		
		JButton btnCrearProducto = new JButton("Crear Producto");
		btnCrearProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCrearProducto.setBounds(672, 153, 167, 52);
		contentPane.add(btnCrearProducto);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(672, 320, 167, 52);
		contentPane.add(btnVolver);
	}

}
