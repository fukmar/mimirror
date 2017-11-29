package inicio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class MenuPrincipal {
	ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("logo.jpg"));
	Image imagen = icono.getImage();
	ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(100,100,Image.SCALE_SMOOTH));
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JDesktopPane escritorio = new JDesktopPane();
		escritorio.setBackground(Color.WHITE);
		frame.getContentPane().add(escritorio, "2, 2, fill, fill");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\fmouzo\\Documents\\JAVA TPO2\\TPAppDistribuidas-master\\TPO_AD2017_Cliente\\src\\inicio\\logo.jpg"));
		lblNewLabel.setBounds(201, 209, 602, 324);
		escritorio.add(lblNewLabel);
		frame.setIconImage(imagen);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmSalir);
		
		JMenu mnComanda = new JMenu("Comanda");
		menuBar.add(mnComanda);
		
		JMenuItem mntmNuevaComanda = new JMenuItem("Nueva Comanda");
		mntmNuevaComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComandaView comandaVentana = new ComandaView();
				comandaVentana.setResizable(false);
				escritorio.add("Gesti�n de Comandas",comandaVentana);
				comandaVentana.show();
			}
		});
		mntmNuevaComanda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
		mnComanda.add(mntmNuevaComanda);
		
		JMenuItem mntmBuscarComanda = new JMenuItem("Buscar Comanda");
		mntmBuscarComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComandaView comandaVentana = new ComandaView();
				comandaVentana.setResizable(false);
				escritorio.add("Gesti�n de Comandas",comandaVentana);
				comandaVentana.show();
			}
		});
		mnComanda.add(mntmBuscarComanda);
		
		JMenuItem mntmModificarComanda = new JMenuItem("Modificar Comanda");
		mntmModificarComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComandaView comandaVentana = new ComandaView();
				comandaVentana.setResizable(false);
				escritorio.add("Gesti�n de Comandas",comandaVentana);
				comandaVentana.show();
			}
		});
		mnComanda.add(mntmModificarComanda);
		
		JMenuItem mntmCancelarComanda = new JMenuItem("Cancelar Comanda");
		mntmCancelarComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComandaView comandaVentana = new ComandaView();
				comandaVentana.setResizable(false);
				escritorio.add("Gesti�n de Comandas",comandaVentana);
				comandaVentana.show();
			}
		});
		mnComanda.add(mntmCancelarComanda);
		
		JMenu mnFacturacin = new JMenu("Facturaci\u00F3n");
		menuBar.add(mnFacturacin);
		
		JMenuItem mntmNuevaFactura = new JMenuItem("Nueva Factura");
		mntmNuevaFactura.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_MASK));
		mntmNuevaFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FacturaView facturaVentana = new FacturaView();
				facturaVentana.setResizable(false);
				escritorio.add("Facturaci�n",facturaVentana);
				facturaVentana.show();
			}
		});
		mnFacturacin.add(mntmNuevaFactura);
		
		JMenuItem mntmModificarFactura = new JMenuItem("Modificar Factura");
		mntmModificarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacturaView facturaVentana = new FacturaView();
				facturaVentana.setResizable(false);
				escritorio.add("Facturaci�n",facturaVentana);
				facturaVentana.show();
			}
		});
		mnFacturacin.add(mntmModificarFactura);
		
		JMenuItem mntmCancelarFactura = new JMenuItem("Cancelar Factura");
		mntmCancelarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacturaView facturaVentana = new FacturaView();
				facturaVentana.setResizable(false);
				escritorio.add("Facturaci�n",facturaVentana);
				facturaVentana.show();
			}
		});
		mnFacturacin.add(mntmCancelarFactura);
		
		JMenu mnMateriaprima = new JMenu("MateriaPrima");
		menuBar.add(mnMateriaprima);
		
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mnMateriaprima.add(mntmAlta);
		
		JMenuItem mntmModificacion = new JMenuItem("Modificacion");
		mnMateriaprima.add(mntmModificacion);
		
		JMenu mnSemielaborado = new JMenu("SemiElaborado");
		menuBar.add(mnSemielaborado);
		
		JMenuItem mntmAlta_1 = new JMenuItem("Alta");
		mnSemielaborado.add(mntmAlta_1);
		
		JMenuItem mntmModificacion_1 = new JMenuItem("Modificacion");
		mnSemielaborado.add(mntmModificacion_1);
		
		JMenu mnElaborado = new JMenu("Elaborado");
		menuBar.add(mnElaborado);
		
		JMenuItem mntmAlta_2 = new JMenuItem("Alta");
		mnElaborado.add(mntmAlta_2);
		
		JMenuItem mntmModificacion_2 = new JMenuItem("Modificacion");
		mnElaborado.add(mntmModificacion_2);
		
		JMenu mnReceta = new JMenu("Receta");
		menuBar.add(mnReceta);
		
		JMenuItem mntmAlta_3 = new JMenuItem("Alta");
		mnReceta.add(mntmAlta_3);
		
		JMenuItem mntmModificacion_3 = new JMenuItem("Modificacion");
		mnReceta.add(mntmModificacion_3);
	}
}
