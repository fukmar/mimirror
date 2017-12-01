package swing;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;



public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Sistema Restaurante");
		setAlwaysOnTop(true);
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 698);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 10, 2000, 26);
		
		
		
		JMenu mnNewMenu = new JMenu("Materiales");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAlta = new JMenuItem("Nuevo Material");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaMaterial altaM=new AltaMaterial();
				setVisible(false);
				altaM.setExtendedState(JFrame.MAXIMIZED_BOTH);
				altaM.setVisible(true);
			
			}
		});
		mntmAlta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		contentPane.setLayout(null);
		mnNewMenu.add(mntmAlta);
		
		JMenuItem mntmModificarDeposito = new JMenuItem("Modificar Material");
		mntmModificarDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BajaMaterial mm=new BajaMaterial();
				setVisible(false);
				mm.setExtendedState(JFrame.MAXIMIZED_BOTH);
				mm.setVisible(true);
			}
		});
		mntmModificarDeposito.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.add(mntmModificarDeposito);
		
		JMenuItem mntmEliminarFactura = new JMenuItem("Eliminar Material");
		mntmEliminarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarMaterial bj=new ModificarMaterial();
				setVisible(false);
				bj.setExtendedState(JFrame.MAXIMIZED_BOTH);
				bj.setVisible(true);
			}
		});
		mntmEliminarFactura.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.add(mntmEliminarFactura);
		
		JMenu mnComandas = new JMenu("Platos");
		mnComandas.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		menuBar.add(mnComandas);
		
		JMenu mnElaborados = new JMenu("Elaborados");
		mnElaborados.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnComandas.add(mnElaborados);
		
		JMenuItem mntmNuevoPlatoElaborado = new JMenuItem("Nuevo Plato Elaborado");
		mntmNuevoPlatoElaborado.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnElaborados.add(mntmNuevoPlatoElaborado);
		
		JMenuItem mntmModificarPlatoElaborado = new JMenuItem("Modificar Plato Elaborado");
		mntmModificarPlatoElaborado.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnElaborados.add(mntmModificarPlatoElaborado);
		
		JMenuItem mntmEliminarPlatoElaborado = new JMenuItem("Eliminar Plato Elaborado");
		mntmEliminarPlatoElaborado.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnElaborados.add(mntmEliminarPlatoElaborado);
		
		JMenu mnSemielaborados = new JMenu("SemiElaborados");
		mnSemielaborados.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnComandas.add(mnSemielaborados);
		
		JMenuItem mntmNuevoPlatoSemielaborado = new JMenuItem("Nuevo Plato SemiElaborado");
		mntmNuevoPlatoSemielaborado.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnSemielaborados.add(mntmNuevoPlatoSemielaborado);
		
		JMenuItem mntmModificarPlatoSemielaborado = new JMenuItem("Modificar Plato SemiElaborado");
		mntmModificarPlatoSemielaborado.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnSemielaborados.add(mntmModificarPlatoSemielaborado);
		
		JMenuItem mntmEliminarPlatoSemielaborado = new JMenuItem("Eliminar Plato SemiElaborado");
		mntmEliminarPlatoSemielaborado.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnSemielaborados.add(mntmEliminarPlatoSemielaborado);
		contentPane.add(menuBar);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmNuevoUsuario = new JMenuItem("Nuevo Usuario");
		mntmNuevoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaUsuario au=new AltaUsuario();
				setVisible(false);
				au.setExtendedState(JFrame.MAXIMIZED_BOTH);
				au.setVisible(true);
			}
		});
		mnUsuarios.add(mntmNuevoUsuario);
		
		JMenuItem mntmEliminarUsuario = new JMenuItem("Eliminar Usuario");
		mntmEliminarUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaUsuario el=new BajaUsuario();
				setVisible(false);
				el.setExtendedState(JFrame.MAXIMIZED_BOTH);
				el.setVisible(true);
			}
		});
		
		JMenuItem mntmModificarUsuario = new JMenuItem("Modificar Usuario");
		mntmModificarUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarUsuario el=new ModificarUsuario();
				setVisible(false);
				el.setExtendedState(JFrame.MAXIMIZED_BOTH);
				el.setVisible(true);
			}
				
			
		});
		mnUsuarios.add(mntmModificarUsuario);
		
		mnUsuarios.add(mntmEliminarUsuario);
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Principal.class.getResource("/swing/logo.jpg")));
		lblIcono.setBounds((int) ((int) width/2.65), (int) ((int) height/2.9), 418, 278);
		//lblIcono.setBounds((int) width-400, (int) ((int) height-((int)height*0.40)), 418, 278);
		contentPane.add(lblIcono);
		
		
	}
}
