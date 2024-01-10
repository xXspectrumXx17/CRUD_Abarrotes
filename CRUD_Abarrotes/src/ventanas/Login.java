package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Clientes2;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField caja1;
	private JTextField caja2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("nombre");
		lblNom.setBounds(120, 46, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblCodigo = new JLabel("codigo");
		lblCodigo.setBounds(120, 84, 46, 14);
		contentPane.add(lblCodigo);
		
		caja1 = new JTextField();
		caja1.setColumns(10);
		caja1.setBounds(191, 43, 86, 20);
		contentPane.add(caja1);
		
		caja2 = new JTextField();
		caja2.setColumns(10);
		caja2.setBounds(191, 81, 86, 20);
		contentPane.add(caja2);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nav();
			}
		});
		btnIniciar.setBounds(92, 149, 89, 23);
		contentPane.add(btnIniciar);
		
		JButton btnRegistrar = new JButton("registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrar();
			}
		});
		btnRegistrar.setBounds(220, 149, 89, 23);
		contentPane.add(btnRegistrar);
	}

	protected void nav() {

		try {
			String dni=caja2.getText();
			String nombre=caja1.getText();
			
			Clientes2 login = new Clientes2();
			Cliente c = new Cliente();
			
			c.setDni(dni);
			c.setNombre(nombre);
			
			Cliente cli = login.obtenerUsuario(c);
			
			if (cli != null) {
				c.setApellidos(cli.getApellidos());
				c.setFecha_nacimiento(cli.getFecha_nacimiento());
				c.setTelefono(cli.getTelefono());

				JOptionPane.showMessageDialog(null, "Bienvenido");
				Navegador nav = new Navegador();
				nav.cliente = c;
				nav.setVisible(true);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e1) {
			System.out.println(e1);
			JOptionPane.showMessageDialog(null, "No se pudo obtener el usuario", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void Registrar() {
		VRegistrar regis = new VRegistrar();
		regis.setVisible(true);
		this.dispose();
	}

}
