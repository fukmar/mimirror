package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bd.BusinessDelegate;
import dto.MateriaPrimaDTO;
import exceptions.MateriaPrimaException;

import javax.swing.border.CompoundBorder;

public class BajaMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIngresar;
	private JButton btnEliminar;
	private JButton btnVolver;
	private JTextField textCodigo;
	private JTextField textFieldCantidad;
	private JTextField textFieldDes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaMaterial frame = new BajaMaterial();
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
	//PRUEBA
	public BajaMaterial() {
		setTitle("Baja de Material");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 572);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresar codigo de Material:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(33, 54, 234, 22);
		contentPane.add(lblNewLabel);
		
		textFieldIngresar = new JTextField();
		textFieldIngresar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldIngresar.setBounds(315, 56, 272, 30);
		contentPane.add(textFieldIngresar);
		textFieldIngresar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MateriaPrimaDTO materia;
				try {
					materia = BusinessDelegate.getInstance().getMateriaPrimaByCod(Integer.parseInt(textFieldIngresar.getText()));
					textFieldIngresar.setEditable(false);
					textFieldCantidad.setText(materia.getCantidad().toString());
					textFieldDes.setText(materia.getDescripcion());
					textCodigo.setText(textFieldIngresar.getText());
					
				} catch (NumberFormatException | RemoteException | MateriaPrimaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(381, 100, 135, 37);
		contentPane.add(btnBuscar);
		
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MateriaPrimaDTO materia;
				try {
					materia = BusinessDelegate.getInstance().getMateriaPrimaByCod(Integer.parseInt(textFieldIngresar.getText()));
					BusinessDelegate.getInstance().eliminarMateria(materia);
				} catch (NumberFormatException | RemoteException | MateriaPrimaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEliminar.setBounds(97, 448, 151, 46);
		contentPane.add(btnEliminar);
		
		btnVolver = new JButton("Volver");
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
		btnVolver.setBounds(356, 448, 135, 46);
		contentPane.add(btnVolver);
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Principal.class.getResource("/swing/logo.jpg")));
		//lblIcono.setBounds((int) ((int) width/2.65), (int) ((int) height/2.9), 418, 278);
		lblIcono.setBounds((int) width-400, (int) ((int) height-((int)height*0.40)), 418, 278);
		contentPane.add(lblIcono);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigo.setBounds(24, 191, 106, 30);
		contentPane.add(lblCodigo);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescripcion.setBounds(33, 330, 126, 30);
		contentPane.add(lblDescripcion);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidad.setBounds(366, 200, 125, 21);
		contentPane.add(lblCantidad);
		
		textCodigo = new JTextField();
		textCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textCodigo.setEditable(false);
		textCodigo.setBounds(97, 197, 170, 37);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCantidad.setEditable(false);
		textFieldCantidad.setBounds(509, 194, 151, 37);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		textFieldDes = new JTextField();
		textFieldDes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldDes.setEditable(false);
		textFieldDes.setBounds(147, 322, 526, 46);
		contentPane.add(textFieldDes);
		textFieldDes.setColumns(10);
		
	}
}
