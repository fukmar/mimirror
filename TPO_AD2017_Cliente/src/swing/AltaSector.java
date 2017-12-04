package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.BusinessDelegate;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.ActionEvent;
import dto.*;
import exceptions.SalonException;
import exceptions.UnidadException;
import javafx.scene.control.ComboBox;

import javax.swing.JComboBox;

public class AltaSector extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDesc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaSector frame = new AltaSector();
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
	public AltaSector() {
		setTitle("Crear Sector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 740);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescripcion.setBounds(41, 89, 106, 39);
		contentPane.add(lblDescripcion);
		
		JLabel lblSalon = new JLabel("Salon:");
		lblSalon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSalon.setBounds(41, 202, 95, 53);
		contentPane.add(lblSalon);
		
		JComboBox comboBoxSalon = new JComboBox();
		comboBoxSalon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		try {
			List<SalonDTO> salones= BusinessDelegate.getInstance().mostrarSalones();
			//System.out.println("");
			for(SalonDTO salon:salones) {
				comboBoxSalon.addItem(salon.getCodSalon().toString());
			}
		} catch (RemoteException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SalonException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBoxSalon.setBounds(196, 211, 334, 39);
		contentPane.add(comboBoxSalon);
		
		textFieldDesc = new JTextField();
		textFieldDesc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldDesc.setBounds(196, 90, 334, 36);
		contentPane.add(textFieldDesc);
		textFieldDesc.setColumns(10);
		
		JButton btnCrearSector = new JButton("Crear Sector");
		btnCrearSector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalonDTO salon= new SalonDTO(null, null);
				salon.setCodSalon(Integer.parseInt(comboBoxSalon.getSelectedItem().toString()));
				SectorDTO sector = new SectorDTO(textFieldDesc.getText(), salon);
				//BusinessDelegate.getInstance().grabarSector(sector);
				
			}
		});
		btnCrearSector.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCrearSector.setBounds(126, 340, 152, 53);
		contentPane.add(btnCrearSector);
		
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
		btnVolver.setBounds(347, 340, 152, 53);
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
