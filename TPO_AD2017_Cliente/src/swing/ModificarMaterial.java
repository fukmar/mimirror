package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.BusinessDelegate;
import dto.MateriaPrimaDTO;
import exceptions.MateriaPrimaException;


import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

//PRUEBA
public class ModificarMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigoMaterial;
	private JTextField textFieldDescripcion;
	private JTextField textFieldCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarMaterial frame = new ModificarMaterial();
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
	public ModificarMaterial() {
		setTitle("Modificar Material");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 564);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoMat = new JLabel("Ingresar codigo de Material:");
		lblCodigoMat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigoMat.setBounds(12, 61, 254, 30);
		contentPane.add(lblCodigoMat);
		
		textFieldCodigoMaterial = new JTextField();
		textFieldCodigoMaterial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCodigoMaterial.setBounds(278, 66, 200, 22);
		contentPane.add(textFieldCodigoMaterial);
		textFieldCodigoMaterial.setColumns(10);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//AQUI VA EL CODIGO PARA BUSCAR EL MATERIAL A PARTIR DEL CODIGO INGRESADO
				try {
					MateriaPrimaDTO materia = BusinessDelegate.getInstance().getMateriaPrimaByCod(Integer.parseInt(textFieldCodigoMaterial.getText()));
					textFieldCodigoMaterial.setEditable(false);
					textFieldCantidad.setText(materia.getCantidad().toString());
					textFieldCantidad.setEditable(true);
					textFieldDescripcion.setText(materia.getDescripcion());
					textFieldDescripcion.setEditable(true);
					textFieldCodigoMaterial.setEditable(false);
					
				} catch (NumberFormatException | RemoteException | MateriaPrimaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(524, 65, 111, 41);
		contentPane.add(btnBuscar);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDescripcion.setBounds(278, 181, 317, 22);
		contentPane.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setEditable(false);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCantidad.setBounds(278, 294, 317, 22);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setEditable(false);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(59, 184, 130, 19);
		contentPane.add(lblDescripcion);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCantidad.setBounds(59, 297, 102, 16);
		contentPane.add(lblCantidad);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MateriaPrimaDTO materia;
				try {
					materia = BusinessDelegate.getInstance().getMateriaPrimaByCod(Integer.parseInt(textFieldCodigoMaterial.getText()));
					materia.setCantidad(Float.parseFloat(textFieldCantidad.getText()));
					materia.setDescripcion(textFieldDescripcion.getText());
					materia.setCodigo(Integer.parseInt(textFieldCodigoMaterial.getText()));
					BusinessDelegate.getInstance().actualizarMateriaPrima(materia);
					textFieldCantidad.setText("");
					textFieldDescripcion.setText("");
					textFieldCodigoMaterial.setText("");
					textFieldCodigoMaterial.setEditable(true);
					textFieldCantidad.setEditable(false);
					textFieldDescripcion.setEditable(false);
					
				} catch (NumberFormatException | RemoteException | MateriaPrimaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//
				//AQUI VA EL CODIGO PARA MODIFICAR LOS DATOS INGRESADOS
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModificar.setBounds(381, 419, 137, 41);
		contentPane.add(btnModificar);
		
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
		btnVolver.setBounds(116, 419, 124, 41);
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
