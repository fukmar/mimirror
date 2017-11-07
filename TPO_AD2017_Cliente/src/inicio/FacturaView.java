package inicio;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class FacturaView extends JInternalFrame {
	private JTextField CodFacturaField;
	private JTextField textField_1;
	private JTable tableFactura;
	private JTextField textFieldTotalFactura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacturaView frame = new FacturaView();
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
	public FacturaView() {
		setTitle("Facturaci\u00F3n");
		setName("");
		setIconifiable(true);
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(new MigLayout("", "[grow][][][grow][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][grow][][][]", "[][][][][][][][206.00,grow][][]"));
		
		JLabel TextoCodigoFactura = new JLabel("Factura");
		getContentPane().add(TextoCodigoFactura, "cell 0 0");
		
		CodFacturaField = new JTextField();
		getContentPane().add(CodFacturaField, "cell 3 0,growx");
		CodFacturaField.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		getContentPane().add(lblFecha, "cell 28 0,alignx trailing");
		
		textField_1 = new JTextField();
		getContentPane().add(textField_1, "cell 32 0,growx");
		textField_1.setColumns(10);
		
		JLabel lblMozo = new JLabel("Mozo");
		getContentPane().add(lblMozo, "cell 0 2");
		
		JComboBox MozocomboBox = new JComboBox();
		getContentPane().add(MozocomboBox, "cell 3 2,growx");
		
		JLabel lblMesa = new JLabel("Mesa");
		getContentPane().add(lblMesa, "cell 0 3");
		
		JComboBox MesacomboBox = new JComboBox();
		getContentPane().add(MesacomboBox, "cell 3 3,growx");
		
		JScrollPane scrollPaneFactura = new JScrollPane();
		getContentPane().add(scrollPaneFactura, "cell 1 7 36 1,aligny center");
		
		tableFactura = new JTable();
		tableFactura.setPreferredScrollableViewportSize(new Dimension(800, 400));
		tableFactura.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableFactura.setRowHeight(20);
		tableFactura.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableFactura.setAutoCreateRowSorter(true);
		tableFactura.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Cantidad", "Plato", "Precio Unit", "Subtotal"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Float.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableFactura.getColumnModel().getColumn(1).setPreferredWidth(400);
		tableFactura.getColumnModel().getColumn(1).setMinWidth(400);
		String[] datos = { "Suprema Napolitana con Fritas", "Pollo al verdeo", "Ensalada Ceasar", "Pepsi Light" };
		JComboBox comboBox3 = new JComboBox(datos);
		DefaultCellEditor defaultCellEditor=new DefaultCellEditor(comboBox3);
		scrollPaneFactura.setViewportView(tableFactura);
		
		JButton guardarFactura = new JButton("Guardar Factura");
		guardarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(guardarFactura, "cell 1 8");
		
		JButton buscarFactura = new JButton("Buscar Factura");
		buscarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buscarFactura.setActionCommand("BuscarComanda");
		getContentPane().add(buscarFactura, "cell 3 8");
		
		JButton cancelarFactura = new JButton("Cancelar Factura");
		cancelarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancelarFactura.setActionCommand("CancelarComanda");
		getContentPane().add(cancelarFactura, "cell 5 8");
		
		JLabel lblTotalFactura = new JLabel("Total ARS");
		getContentPane().add(lblTotalFactura, "cell 33 8");
		
		textFieldTotalFactura = new JTextField();
		getContentPane().add(textFieldTotalFactura, "cell 35 8,growx");
		textFieldTotalFactura.setColumns(10);

	}

	public FacturaView(JTextField codFacturaField) {
		super();
		CodFacturaField = codFacturaField;
	}

}
