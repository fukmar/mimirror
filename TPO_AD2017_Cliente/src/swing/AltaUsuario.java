package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.BusinessDelegate;
import dto.UsuariosDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import enumns.*;

public class AltaUsuario extends JFrame {

	private JPanel contentPane;
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
					AltaUsuario frame = new AltaUsuario();
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
	public AltaUsuario() {
		setTitle("Creacion de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 634);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(12, 62, 143, 22);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(12, 141, 99, 28);
		contentPane.add(lblPassword);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(12, 243, 99, 19);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellido.setBounds(12, 339, 99, 22);
		contentPane.add(lblApellido);
		
		JLabel lblArea = new JLabel("Area:");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArea.setBounds(12, 444, 99, 28);
		contentPane.add(lblArea);
		
		textLogin = new JTextField();
		textLogin.setBounds(199, 62, 219, 22);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(199, 138, 219, 22);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(199, 240, 219, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(199, 339, 219, 22);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		JComboBox comboBoxArea = new JComboBox();
		comboBoxArea.setMaximumRowCount(15);
		comboBoxArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxArea.addItem("Caja");
		comboBoxArea.addItem("Salon");
		comboBoxArea.addItem("Administracion");
		comboBoxArea.addItem("Cocina");
		comboBoxArea.addItem("Cafeteria");
		comboBoxArea.addItem("Barra");
		comboBoxArea.setBounds(199, 441, 219, 31);
		contentPane.add(comboBoxArea);
		
		JButton btnCrear = new JButton("Crear Usuario");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AreaRest areaDeRest=null;
				String area=comboBoxArea.getSelectedItem().toString();
				switch(area){  
			    case "Caja": areaDeRest = AreaRest.Caja;break;  
			    case "Salon": areaDeRest = AreaRest.salon;break;  
			    case "Administracion": areaDeRest = AreaRest.Administracion;break;  
			    case "Cocina": areaDeRest = AreaRest.Cocina;break;  
			    case "Cafeteria": areaDeRest = AreaRest.Cafeteria;break;  
			    case "Barra": areaDeRest = AreaRest.Barra;break;  
			    }  
				UsuariosDTO usuario= new UsuariosDTO(textLogin.getText(), textPassword.getText(), textNombre.getText(), textApellido.getText(), areaDeRest);
				//BusinessDelegate.getInstance().grabarUsuario(usuario);
				JOptionPane.showMessageDialog(null, "Usuario creado exitosamente", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
				textApellido.setText("");
				textNombre.setText("");
				textLogin.setText("");
				textPassword.setText("");
				//CODIGO PARA DAR DE ALTA USUARIO
				
			}
		});
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCrear.setBounds(541, 158, 149, 77);
		contentPane.add(btnCrear);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Principal principal = new Principal();
				principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
				principal.setVisible(true);
				
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(541, 284, 149, 77);
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
