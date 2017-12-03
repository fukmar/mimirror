package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.BusinessDelegate;
import dto.DepositoDTO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.SectorDTO;
import exceptions.MesaException;
import exceptions.MozoException;
import exceptions.SectorException;

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

public class AltaMesa extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCantPers;
	private JTextField textFieldCapacidad;
	private JTextField textFieldEstado;

	/**
	 * Launch the application.
	 */
	//    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaMesa frame = new AltaMesa();
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
	public AltaMesa() {
		setTitle("Crear Mesa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 723);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCantidadDePersonas = new JLabel("Cantidad de personas:");
		lblCantidadDePersonas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadDePersonas.setBounds(33, 64, 218, 33);
		contentPane.add(lblCantidadDePersonas);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCapacidad.setBounds(33, 163, 218, 33);
		contentPane.add(lblCapacidad);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEstado.setBounds(32, 260, 172, 33);
		contentPane.add(lblEstado);
		
		JLabel label = new JLabel("");
		label.setBounds(33, 292, 56, 16);
		contentPane.add(label);
		
		JLabel lblSector = new JLabel("Sector:");
		lblSector.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSector.setBounds(32, 378, 56, 16);
		contentPane.add(lblSector);
		
		textFieldCantPers = new JTextField();
		textFieldCantPers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCantPers.setBounds(252, 71, 340, 33);
		contentPane.add(textFieldCantPers);
		textFieldCantPers.setColumns(10);
		
		textFieldCapacidad = new JTextField();
		textFieldCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCapacidad.setColumns(10);
		textFieldCapacidad.setBounds(252, 163, 340, 33);
		contentPane.add(textFieldCapacidad);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEstado.setColumns(10);
		textFieldEstado.setBounds(252, 260, 340, 33);
		contentPane.add(textFieldEstado);
		
		JComboBox comboBoxSector = new JComboBox();
		List<SectorDTO> sectores;
		try {
			sectores = BusinessDelegate.getInstance().mostrarSectores();
			for(SectorDTO sector:sectores) {
				comboBoxSector.addItem(sector.getCodSector());
			}
		} catch (RemoteException | SectorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		comboBoxSector.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxSector.setBounds(252, 377, 340, 33);
		contentPane.add(comboBoxSector);
		
		
		JComboBox comboBoxMozo = new JComboBox();
		comboBoxMozo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxMozo.setBounds(252, 480, 340, 33);
		try {
			List<MozoDTO> mozos=new ArrayList<MozoDTO>();
			mozos = BusinessDelegate.getInstance().mostrarMozos();
			for(MozoDTO mozo:mozos) {
				comboBoxMozo.addItem(mozo.getDni().toString());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MozoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane.add(comboBoxMozo);
		JButton btnCrearMesa = new JButton("Crear Mesa");
		btnCrearMesa.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				
		
				MozoDTO mozo=null;
				
				SectorDTO sector=new SectorDTO("dsgdfhg", null);
				mozo=new MozoDTO(Integer.parseInt(comboBoxMozo.getSelectedItem().toString()), ".", ".", (float) 1);
				Integer codSec=Integer.parseInt(comboBoxSector.getSelectedItem().toString());
				sector.setCodSector(1);
				sector.setDescripcion(null);
				sector.setSalon(null);
				MesaDTO mesa= new MesaDTO(69, Integer.parseInt(textFieldCantPers.getText()), Integer.parseInt(textFieldCapacidad.getText()), Integer.parseInt(textFieldEstado.getText()), mozo, sector);
				JOptionPane.showMessageDialog(null, "Mesa creada exitosamente", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
				try {
					BusinessDelegate.getInstance().grabarMesa(mesa);
				} catch (RemoteException | MesaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		btnCrearMesa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCrearMesa.setBounds(92, 560, 159, 53);
		contentPane.add(btnCrearMesa);
		
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
		btnVolver.setBounds(329, 560, 180, 53);
		contentPane.add(btnVolver);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Principal.class.getResource("/swing/logo.jpg")));
		//lblIcono.setBounds((int) ((int) width/2.65), (int) ((int) height/2.9), 418, 278);
		lblIcono.setBounds((int) width-400, (int) ((int) height-((int)height*0.40)), 418, 278);
		contentPane.add(lblIcono);
		
		JLabel lblMozoAsignado = new JLabel("Mozo asignado:");
		lblMozoAsignado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMozoAsignado.setBounds(33, 480, 159, 33);
		contentPane.add(lblMozoAsignado);
		
		
	}
}
