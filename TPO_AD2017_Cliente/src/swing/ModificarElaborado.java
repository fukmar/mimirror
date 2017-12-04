package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bd.BusinessDelegate;
import dto.*;
import exceptions.ElaboradoException;
public class ModificarElaborado extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIngresar;
	private JTextField textCodigo;
	private JTextField textTipo;
	private JTextField textDescripcion;
	private JTextField textCantidad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarElaborado frame = new ModificarElaborado();
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
	public ModificarElaborado() {
		setTitle("Modificar Elaborado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 758);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresarCodigoDe = new JLabel("Ingresar codigo de Producto:");
		lblIngresarCodigoDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngresarCodigoDe.setBounds(47, 94, 249, 29);
		contentPane.add(lblIngresarCodigoDe);
		
		textFieldIngresar = new JTextField();
		textFieldIngresar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldIngresar.setBounds(341, 94, 439, 29);
		contentPane.add(textFieldIngresar);
		textFieldIngresar.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				try {
					ElaboradoDTO elab = BusinessDelegate.getInstance().getElaboradoByCod(7);
					textCantidad.setText(elab.getCantidad().toString());
					textCodigo.setText(elab.getCodElab().toString());
					textDescripcion.setText(elab.getDescripcion());
					textTipo.setText(elab.getTipo());
					textCantidad.setEditable(true);
					textCodigo.setEditable(true);
					textDescripcion.setEditable(true);
					textTipo.setEditable(true);
					
				} catch (NumberFormatException | RemoteException | ElaboradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(491, 155, 124, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigo.setBounds(47, 285, 130, 37);
		contentPane.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textCodigo.setBounds(136, 285, 232, 37);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipo.setBounds(394, 290, 130, 27);
		contentPane.add(lblTipo);
		
		textTipo = new JTextField();
		textTipo.setEditable(false);
		textTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textTipo.setBounds(491, 285, 289, 37);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescripcion.setBounds(47, 399, 105, 29);
		contentPane.add(lblDescripcion);
		
		textDescripcion = new JTextField();
		textDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textDescripcion.setEditable(false);
		textDescripcion.setBounds(168, 394, 612, 42);
		contentPane.add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModificar.setBounds(175, 633, 153, 50);
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
		btnVolver.setBounds(564, 633, 124, 50);
		contentPane.add(btnVolver);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidad.setBounds(263, 504, 105, 29);
		contentPane.add(lblCantidad);
		
		textCantidad = new JTextField();
		textCantidad.setEditable(false);
		textCantidad.setBounds(415, 502, 200, 37);
		contentPane.add(textCantidad);
		textCantidad.setColumns(10);
		
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
