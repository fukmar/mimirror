package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import dto.*;
import exceptions.DepositoException;
import exceptions.UnidadException;
import bd.BusinessDelegate;
import swing.*;

public class AltaMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDescripcion;
	private JLabel lblCantidad;
	private JTextField textFieldCantidad;
	private JComboBox comboBoxUnidades;
	private JButton btnCrearMaterial;
	private JButton btnVolver;
	private JLabel lblDeposito;
	private JComboBox comboBoxDepositos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaMaterial frame = new AltaMaterial();
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
	public AltaMaterial() {
		setTitle("Alta Material");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 790, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnCrearMaterial = new JButton("Crear Material");
		btnCrearMaterial.setBounds(168, 311, 152, 48);
		btnCrearMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String descrip=textFieldDescripcion.getText();
				Float cantidad=Float.parseFloat(textFieldCantidad.getText());
				try {
					UnidadDTO uni= BusinessDelegate.getInstance().UnidadByDescp("pruebaUnidadSi");
					//UnidadDTO uni= BusinessDelegate.getInstance().UnidadByCod(Integer.parseInt(comboBoxUnidades.getSelectedItem().toString()));
					MateriaPrimaDTO materia= new MateriaPrimaDTO(descrip, uni, cantidad);
					BusinessDelegate.getInstance().grabarMateriaPrima(materia);
					JOptionPane.showMessageDialog(null, "Material creado exitosamente", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
					textFieldCantidad.setText("");
					textFieldDescripcion.setText("");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		contentPane.setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(45, 48, 81, 20);
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(168, 45, 592, 26);
		textFieldDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDescripcion.setToolTipText("");
		contentPane.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(54, 114, 62, 20);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(168, 111, 146, 26);
		textFieldCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		comboBoxUnidades = new JComboBox();
		comboBoxUnidades.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxUnidades.setBounds(325, 114, 157, 23);
		try {
			List<UnidadDTO> unidades= BusinessDelegate.getInstance().mostrarUnidades();
			//System.out.println("");
			for(UnidadDTO uni:unidades) {
				comboBoxUnidades.addItem(uni.getDescripcion());
			}
		} catch (RemoteException | UnidadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.add(comboBoxUnidades);
		
		lblDeposito = new JLabel("Deposito");
		lblDeposito.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeposito.setBounds(55, 194, 81, 16);
		contentPane.add(lblDeposito);
		btnCrearMaterial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnCrearMaterial);
		
		btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Principal principal = new Principal();
				principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
				principal.setVisible(true);
				
			}
		});
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnVolver.setBounds(325, 311, 119, 48);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnVolver);
		
		comboBoxDepositos = new JComboBox();
		comboBoxDepositos.setBounds(168, 192, 183, 22);
		try {
			List<DepositoDTO> unidades= BusinessDelegate.getInstance().mostrarDepositos();
			//System.out.println("");
			for(DepositoDTO uni:unidades) {
				comboBoxDepositos.addItem(Integer.toString(uni.getCodDeposito()));
			}
		} catch (RemoteException | DepositoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.add(comboBoxDepositos);
	
	}
}
