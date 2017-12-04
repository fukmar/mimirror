package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.BusinessDelegate;
import dto.MesaDTO;
import exceptions.MesaException;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class BajaMesa extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIngresar;
	private JTextField textFieldCod;
	private JTextField textFieldCapac;
	private JTextField textFieldEst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaMesa frame = new BajaMesa();
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
	public BajaMesa() {
		setTitle("Eliminar Mesa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 708);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresarCodigoDe = new JLabel("Ingresar codigo de Mesa:");
		lblIngresarCodigoDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngresarCodigoDe.setBounds(39, 94, 221, 29);
		contentPane.add(lblIngresarCodigoDe);
		
		textFieldIngresar = new JTextField();
		textFieldIngresar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldIngresar.setBounds(301, 99, 360, 29);
		contentPane.add(textFieldIngresar);
		textFieldIngresar.setColumns(10);
		
		JLabel lblCodigoDeMesa = new JLabel("Codigo de mesa:");
		lblCodigoDeMesa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigoDeMesa.setBounds(39, 241, 153, 29);
		contentPane.add(lblCodigoDeMesa);
		
		textFieldCod = new JTextField();
		textFieldCod.setEditable(false);
		textFieldCod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCod.setBounds(218, 246, 182, 24);
		contentPane.add(textFieldCod);
		textFieldCod.setColumns(10);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCapacidad.setBounds(413, 249, 114, 21);
		contentPane.add(lblCapacidad);
		
		textFieldCapac = new JTextField();
		textFieldCapac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCapac.setEditable(false);
		textFieldCapac.setBounds(514, 246, 182, 24);
		contentPane.add(textFieldCapac);
		textFieldCapac.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEstado.setBounds(216, 366, 98, 16);
		contentPane.add(lblEstado);
		
		textFieldEst = new JTextField();
		textFieldEst.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEst.setEditable(false);
		textFieldEst.setBounds(326, 365, 221, 24);
		contentPane.add(textFieldEst);
		textFieldEst.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MesaDTO mesa=BusinessDelegate.getInstance().BuscarMesaPorCod(Integer.parseInt(textFieldIngresar.getText()));
					textFieldCod.setText(mesa.getCodMesa().toString());
					textFieldCapac.setText(mesa.getCapacidad().toString());
					textFieldEst.setText(mesa.getEstado().toString());
					//textFieldIngresar.setEditable(false);
				} catch (NumberFormatException | RemoteException | MesaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(413, 150, 134, 59);
		contentPane.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MesaDTO mesa= BusinessDelegate.getInstance().BuscarMesaPorCod(Integer.parseInt(textFieldCod.getText()));
					//BusinessDelegate.getInstance().borrarMesa(mesa);
				} catch (NumberFormatException | RemoteException | MesaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEliminar.setBounds(176, 493, 138, 59);
		contentPane.add(btnEliminar);
		
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
		btnVolver.setBounds(387, 493, 140, 59);
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
