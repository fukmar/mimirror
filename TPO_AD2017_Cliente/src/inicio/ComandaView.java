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

public class ComandaView extends JInternalFrame {
	private JTextField CodComandaField;
	private JTextField textField_1;
	private JTable tableComanda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComandaView frame = new ComandaView();
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
	public ComandaView() {
		setTitle("Gesti\u00F3n de Comandas");
		setName("");
		setIconifiable(true);
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(new MigLayout("", "[grow][][][grow][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][]", "[][][][][][][][206.00,grow][][]"));
		
		JLabel TextoCodigoComanda = new JLabel("Codigo Comanda");
		getContentPane().add(TextoCodigoComanda, "cell 0 0");
		
		CodComandaField = new JTextField();
		getContentPane().add(CodComandaField, "cell 3 0,growx");
		CodComandaField.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		getContentPane().add(lblFecha, "cell 34 0,alignx trailing");
		
		textField_1 = new JTextField();
		getContentPane().add(textField_1, "cell 37 0,growx");
		textField_1.setColumns(10);
		
		JLabel lblMozo = new JLabel("Mozo");
		getContentPane().add(lblMozo, "cell 0 2");
		
		JComboBox MozocomboBox = new JComboBox();
		getContentPane().add(MozocomboBox, "cell 3 2,growx");
		
		JButton btnCerrrarComanda = new JButton("Cerrrar Comanda");
		btnCerrrarComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnCerrrarComanda, "cell 19 2");
		
		JLabel lblMesa = new JLabel("Mesa");
		getContentPane().add(lblMesa, "cell 0 3");
		
		JComboBox MesacomboBox = new JComboBox();
		getContentPane().add(MesacomboBox, "cell 3 3,growx");
		
		JScrollPane scrollPaneComanda = new JScrollPane();
		getContentPane().add(scrollPaneComanda, "cell 1 7 39 1,aligny center");
		
		tableComanda = new JTable();
		tableComanda.setPreferredScrollableViewportSize(new Dimension(800, 400));
		tableComanda.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableComanda.setRowHeight(20);
		tableComanda.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableComanda.setAutoCreateRowSorter(true);
		tableComanda.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Cantidad", "Plato", "Precio Unit"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableComanda.getColumnModel().getColumn(1).setPreferredWidth(400);
		tableComanda.getColumnModel().getColumn(1).setMinWidth(400);
		String[] datos = { "Suprema Napolitana con Fritas", "Pollo al verdeo", "Ensalada Ceasar", "Pepsi Light" };
		JComboBox comboBox3 = new JComboBox(datos);
		DefaultCellEditor defaultCellEditor=new DefaultCellEditor(comboBox3);
		tableComanda.getColumnModel().getColumn(1).setCellEditor(defaultCellEditor);
		scrollPaneComanda.setViewportView(tableComanda);
		
		JButton guardarComanda = new JButton("Guardar Comanda");
		guardarComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(guardarComanda, "cell 1 8");
		
		JButton buscarComanda = new JButton("Buscar Comanda");
		buscarComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buscarComanda.setActionCommand("BuscarComanda");
		getContentPane().add(buscarComanda, "cell 3 8");
		
		JButton cancelarComanda = new JButton("Cancelar Comanda");
		cancelarComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancelarComanda.setActionCommand("CancelarComanda");
		getContentPane().add(cancelarComanda, "cell 4 8");

	}

}
