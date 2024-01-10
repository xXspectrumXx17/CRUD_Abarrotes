package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Navegador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public Cliente cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Navegador frame = new Navegador();
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
	public Navegador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("compras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nav();
			}
				
			
		});
		btnNewButton.setBounds(97, 76, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnProveedor = new JButton("proveedor");
		btnProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nav1();
			}
		});
		btnProveedor.setBounds(242, 76, 89, 23);
		contentPane.add(btnProveedor);
		
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nav2();
			}
		});
		btnHistorial.setBounds(169, 119, 89, 23);
		contentPane.add(btnHistorial);
	}

	protected void Nav2() {
		Historail  h = new Historail();
		h.setVisible(true);
		this.dispose();
		
	}

	protected void Nav1() {
		proveedor p = new proveedor();
		p.setVisible(true);
		this.dispose();
		
		
	}

	protected void Nav() {
		compras c = new compras();
		c.setVisible(true);
		this.dispose();
		
	}

}
