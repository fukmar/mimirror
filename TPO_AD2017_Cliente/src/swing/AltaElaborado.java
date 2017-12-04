package swing;

import dto.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.BusinessDelegate;
import dto.PlanDeProduccionDTO;
import dto.SemiElaboradoDTO;
import dto.UnidadDTO;
import exceptions.PlanDeProduccionException;
import exceptions.SemiElaboradoException;
import exceptions.UnidadException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;

public class AltaElaborado extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTipo;
	private JTextField textFieldCalidad;
	private JTextField textFieldDescp;
	private JTextField textFieldCantidad;

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
		List<SemiElaboradoDTO> semiElabsGrande=new ArrayList<SemiElaboradoDTO>();
		setTitle("Crear Producto Elaborado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 861);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
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
		lblUnidad.setBounds(12, 718, 117, 26);
		contentPane.add(lblUnidad);
		
		JLabel lblSemielaborados = new JLabel("SemiElaborados:");
		lblSemielaborados.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSemielaborados.setBounds(12, 798, 175, 26);
		contentPane.add(lblSemielaborados);
	
		
		textFieldTipo = new JTextField();
		textFieldTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldTipo.setBounds(242, 52, 193, 33);
		contentPane.add(textFieldTipo);
		textFieldTipo.setColumns(10);
		
		JCalendar calendarCaducidad = new JCalendar();
		calendarCaducidad.setBounds(239, 441, 473, 247);
		contentPane.add(calendarCaducidad);
		
		textFieldCalidad = new JTextField();
		textFieldCalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCalidad.setBounds(242, 122, 193, 33);
		contentPane.add(textFieldCalidad);
		textFieldCalidad.setColumns(10);
		
		textFieldDescp = new JTextField();
		textFieldDescp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldDescp.setBounds(242, 192, 193, 33);
		contentPane.add(textFieldDescp);
		textFieldDescp.setColumns(10);
		
		JComboBox comboBoxPdP = new JComboBox();
		comboBoxPdP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		try {
			List<PlanDeProduccionDTO> pdp= BusinessDelegate.getInstance().mostrarPDPs();
			//System.out.println("");
			for(PlanDeProduccionDTO pdp1:pdp) {
				comboBoxPdP.addItem(pdp1.getCodigoPDP());
			}
		} catch (RemoteException | PlanDeProduccionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboBoxPdP.setBounds(242, 271, 193, 33);
		contentPane.add(comboBoxPdP);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCantidad.setBounds(242, 347, 193, 33);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JComboBox comboBoxUnidad = new JComboBox();
		comboBoxUnidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		try {
			List<UnidadDTO> unidades= BusinessDelegate.getInstance().mostrarUnidades();
			//System.out.println("");
			for(UnidadDTO uni:unidades) {
				comboBoxUnidad.addItem(uni.getDescripcion());
			}
		} catch (RemoteException | UnidadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboBoxUnidad.setBounds(242, 715, 193, 33);
		contentPane.add(comboBoxUnidad);
		
		JButton btnCrearProducto = new JButton("Crear Producto");
		btnCrearProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PlanDeProduccionDTO prod= BusinessDelegate.getInstance().obtenerPDPByCodPDP(Integer.parseInt(comboBoxPdP.getSelectedItem().toString()));
					UnidadDTO uni=BusinessDelegate.getInstance().UnidadByDescp(comboBoxUnidad.getSelectedItem().toString());
					ElaboradoDTO elab=new ElaboradoDTO(textFieldTipo.getText(), textFieldCalidad.getText(), textFieldDescp.getText(), Integer.parseInt(textFieldCantidad.getText()),calendarCaducidad.getDate() , uni, semiElabsGrande);
					elab.setPlan(prod);
					BusinessDelegate.getInstance().grabarElaborado(elab);
				} catch (RemoteException | UnidadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SemiElaboradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PlanDeProduccionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
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
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Principal.class.getResource("/swing/logo.jpg")));
		//lblIcono.setBounds((int) ((int) width/2.65), (int) ((int) height/2.9), 418, 278);
		lblIcono.setBounds((int) width-400, (int) ((int) height-((int)height*0.40)), 418, 278);
		contentPane.add(lblIcono);
		
		JComboBox comboBoxSemiElabor = new JComboBox();
		comboBoxSemiElabor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		try {
			List<SemiElaboradoDTO> semis= BusinessDelegate.getInstance().mostrarSemiElaborados();
			//System.out.println("");
			for(SemiElaboradoDTO semi:semis) {
				comboBoxSemiElabor.addItem(semi.getDescripcion());
			}
		} catch (RemoteException | SemiElaboradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboBoxSemiElabor.setBounds(242, 802, 325, 33);
		contentPane.add(comboBoxSemiElabor);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					List<SemiElaboradoDTO> semis=BusinessDelegate.getInstance().mostrarSemiElaborados();
					for(SemiElaboradoDTO semiel:semis) {
						if(semiel.getDescripcion().equals(comboBoxSemiElabor.getSelectedItem().toString())) {
							semiElabsGrande.add(semiel);
							JOptionPane.showMessageDialog(null, "SemiElaborado agregado exitosamente", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				} catch (RemoteException | SemiElaboradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAgregar.setBounds(593, 789, 147, 45);
		contentPane.add(btnAgregar);
		
		
		
		
	}
}
