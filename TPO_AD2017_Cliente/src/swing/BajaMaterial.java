package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.MateriaPrimaDTO;

import javax.swing.border.CompoundBorder;

public class BajaMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JButton btnEliminar;
	private JButton btnVolver;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresar codigo de Material:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(33, 54, 234, 22);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(315, 56, 207, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//AQUI SE TRAEN LAS MATERIAS CON ESE CODIGO Y LAS CARGAS A LA TABLA
				int numCols= table.getModel().getColumnCount();
				MateriaPrimaDTO materia = new MateriaPrimaDTO();
				Object [] fila = new Object[numCols];
				
				fila[0]=materia.getCodigo();
				fila[1]=materia.getDescripcion();
				((DefaultTableModel)table.getModel()).addRow(fila);
				
			}
		});
		btnBuscar.setBounds(356, 101, 135, 37);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 171, 554, 242);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descripcion"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEliminar.setBounds(97, 448, 151, 46);
		contentPane.add(btnEliminar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Principal principal = new Principal();
				principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
				principal.setVisible(true);
				
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(356, 448, 135, 46);
		contentPane.add(btnVolver);
		
		
	}
}
