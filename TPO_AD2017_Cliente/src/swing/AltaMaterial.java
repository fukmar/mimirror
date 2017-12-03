package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

//PRUEBA
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
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
import exceptions.MateriaPrima;
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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnCrearMaterial = new JButton("Crear Material");
		btnCrearMaterial.setBounds(168, 375, 172, 55);
		btnCrearMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String descrip=textFieldDescripcion.getText();
				Float cantidad=Float.parseFloat(textFieldCantidad.getText());
				try {
					UnidadDTO uni= BusinessDelegate.getInstance().UnidadByDescp((comboBoxUnidades.getSelectedItem().toString()));
					MateriaPrimaDTO materia= new MateriaPrimaDTO(descrip, uni, cantidad);
					BusinessDelegate.getInstance().grabarMateriaPrima(materia);
					JOptionPane.showMessageDialog(null, "Material creado exitosamente", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
					textFieldCantidad.setText("");
					textFieldDescripcion.setText("");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MateriaPrima e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		contentPane.setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(23, 52, 109, 28);
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(168, 45, 592, 35);
		textFieldDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldDescripcion.setToolTipText("");
		contentPane.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(23, 142, 86, 20);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(168, 136, 152, 35);
		textFieldCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		comboBoxUnidades = new JComboBox();
		comboBoxUnidades.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxUnidades.setBounds(351, 138, 172, 33);
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
		
		lblDeposito = new JLabel("Deposito:");
		lblDeposito.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeposito.setBounds(23, 230, 93, 24);
		contentPane.add(lblDeposito);
		btnCrearMaterial.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(btnCrearMaterial);
		
		btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Principal principal = new Principal();
				principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
				principal.setVisible(true);
				
			}
		});
		btnVolver.setBounds(424, 375, 139, 55);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(btnVolver);
		
		comboBoxDepositos = new JComboBox();
		comboBoxDepositos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxDepositos.setBounds(168, 226, 240, 33);
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
