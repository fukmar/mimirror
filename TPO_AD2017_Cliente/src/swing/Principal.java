package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		setBounds(100, 100, 860, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(5, 5, 136, 26);
		
		JMenu mnNewMenu = new JMenu("Materiales");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAlta = new JMenuItem("Nuevo Material");
		mntmAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		contentPane.setLayout(null);
		mnNewMenu.add(mntmAlta);
		
		JMenuItem mntmModificarDeposito = new JMenuItem("Modificar Material");
		mnNewMenu.add(mntmModificarDeposito);
		
		JMenuItem mntmEliminarFactura = new JMenuItem("Eliminar Material");
		mnNewMenu.add(mntmEliminarFactura);
		
		JMenu mnComandas = new JMenu("Platos");
		menuBar.add(mnComandas);
		
		JMenu mnElaborados = new JMenu("Elaborados");
		mnComandas.add(mnElaborados);
		
		JMenuItem mntmNuevoPlatoElaborado = new JMenuItem("Nuevo Plato Elaborado");
		mnElaborados.add(mntmNuevoPlatoElaborado);
		
		JMenuItem mntmModificarPlatoElaborado = new JMenuItem("Modificar Plato Elaborado");
		mnElaborados.add(mntmModificarPlatoElaborado);
		
		JMenuItem mntmEliminarPlatoElaborado = new JMenuItem("Eliminar Plato Elaborado");
		mnElaborados.add(mntmEliminarPlatoElaborado);
		
		JMenu mnSemielaborados = new JMenu("SemiElaborados");
		mnComandas.add(mnSemielaborados);
		
		JMenuItem mntmNuevoPlatoSemielaborado = new JMenuItem("Nuevo Plato SemiElaborado");
		mnSemielaborados.add(mntmNuevoPlatoSemielaborado);
		
		JMenuItem mntmModificarPlatoSemielaborado = new JMenuItem("Modificar Plato SemiElaborado");
		mnSemielaborados.add(mntmModificarPlatoSemielaborado);
		
		JMenuItem mntmEliminarPlatoSemielaborado = new JMenuItem("Eliminar Plato SemiElaborado");
		mnSemielaborados.add(mntmEliminarPlatoSemielaborado);
		contentPane.add(menuBar);
	}
}
