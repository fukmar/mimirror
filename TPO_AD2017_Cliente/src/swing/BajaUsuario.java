package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bd.BusinessDelegate;
import dto.UsuariosDTO;
import exceptions.UsuarioException;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class BajaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textIngresa;
	private JTextField textLogin;
	private JTextField textPassword;
	private JTextField textNombre;
	private JTextField textApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaUsuario frame = new BajaUsuario();
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
	public BajaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Ingresar login de usuario:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(12, 78, 215, 28);
		contentPane.add(lblLogin);
		
		textIngresa = new JTextField();
		textIngresa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textIngresa.setBounds(247, 83, 378, 33);
		contentPane.add(textIngresa);
		textIngresa.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UsuariosDTO user=BusinessDelegate.getInstance().buscarUserPorLogin(textIngresa.getText());
					textIngresa.setEditable(false);
					textLogin.setText(user.getLogin());
					textPassword.setText(user.getPassword());
					textNombre.setText(user.getNombre());
					textApellido.setText(user.getApellido());
					
				} catch (RemoteException | UsuarioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(376, 140, 115, 41);
		contentPane.add(btnBuscar);
		
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
		btnVolver.setBounds(301, 490, 150, 41);
		contentPane.add(btnVolver);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Principal.class.getResource("/swing/logo.jpg")));
		//lblIcono.setBounds((int) ((int) width/2.65), (int) ((int) height/2.9), 418, 278);
		lblIcono.setBounds((int) width-400, (int) ((int) height-((int)height*0.40)), 418, 278);
		contentPane.add(lblIcono);
		
		JLabel lblLogin_1 = new JLabel("Login:");
		lblLogin_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin_1.setBounds(12, 248, 115, 28);
		contentPane.add(lblLogin_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(314, 256, 115, 20);
		contentPane.add(lblPassword);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(12, 386, 93, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellido.setBounds(309, 388, 120, 28);
		contentPane.add(lblApellido);
		
		textLogin = new JTextField();
		textLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textLogin.setEditable(false);
		textLogin.setBounds(74, 253, 153, 33);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPassword.setEditable(false);
		textPassword.setBounds(439, 253, 186, 33);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNombre.setEditable(false);
		textNombre.setBounds(89, 385, 138, 31);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textApellido.setEditable(false);
		textApellido.setBounds(439, 389, 186, 31);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UsuariosDTO usua = BusinessDelegate.getInstance().buscarUserPorLogin(textIngresa.getText());
					BusinessDelegate.getInstance().borrarUsuario(usua);
					JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
					textIngresa.setEditable(true);
					textIngresa.setText("");
					textLogin.setText("");
					textPassword.setText("");
					textNombre.setText("");
					textApellido.setText("");
					
					
				} catch (RemoteException | UsuarioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEliminar.setBounds(43, 490, 138, 41);
		contentPane.add(btnEliminar);
	}
}
