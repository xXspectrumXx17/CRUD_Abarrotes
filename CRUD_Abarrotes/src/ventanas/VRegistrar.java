package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion_mysql.MySqlConexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.PreparedStatement;

public class VRegistrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField caja1;
	private JTextField caja2;
	private JTextField caja3;
	private JTextField caja4;
	private JTextField caja5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRegistrar frame = new VRegistrar();
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
	public VRegistrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(56, 45, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setBounds(56, 72, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("apellidos");
		lblApellidos.setBounds(56, 104, 46, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblFecha = new JLabel("fecha de nacimiento");
		lblFecha.setBounds(56, 136, 102, 14);
		contentPane.add(lblFecha);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(56, 170, 46, 14);
		contentPane.add(lblTelefono);
		
		caja1 = new JTextField();
		caja1.setColumns(10);
		caja1.setBounds(122, 42, 86, 20);
		contentPane.add(caja1);
		
		caja2 = new JTextField();
		caja2.setColumns(10);
		caja2.setBounds(132, 72, 86, 20);
		contentPane.add(caja2);
		
		caja3 = new JTextField();
		caja3.setColumns(10);
		caja3.setBounds(122, 101, 86, 20);
		contentPane.add(caja3);
		
		caja4 = new JTextField();
		caja4.setColumns(10);
		caja4.setBounds(168, 133, 86, 20);
		contentPane.add(caja4);
		
		caja5 = new JTextField();
		caja5.setColumns(10);
		caja5.setBounds(112, 167, 86, 20);
		contentPane.add(caja5);
		
		JButton btnNewButton = new JButton("registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				PreparedStatement stmt = null;
				try {
					conexion = MySqlConexion.ObtenerConexion();
					
					String dni=caja1.getText();
					String nombre=caja2.getText();
					String apellidos=caja3.getText();
					String fechadenacimiento=caja4.getText();
					Long telefono = Long.parseLong(caja5.getText());
					String query= "INSERT INTO cliente VALUES(?,?,?,?,?)";
					stmt = conexion.prepareStatement(query);
					
					stmt.setString(1, dni);
					stmt.setString(2, nombre);
					stmt.setString(3, apellidos);
					stmt.setString(4, fechadenacimiento);
					stmt.setLong(5, telefono);
					
					stmt.execute();
					JOptionPane.showMessageDialog(null,"Cliente Agregado");
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(288, 41, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Regresar();
			}
		});
		btnRegresar.setBounds(288, 227, 89, 23);
		contentPane.add(btnRegresar);
	}

	protected void Regresar() {
		Login login = new Login();
		login.setVisible(true);
		this.dispose();
	}

}
