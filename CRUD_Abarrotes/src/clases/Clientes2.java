package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import conexion_mysql.MySqlConexion;

public class Clientes2 {
	public Cliente obtenerUsuario(Cliente c) {
		Cliente cli = null;
		
		Connection cone = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		
		try {
			
		 cone = MySqlConexion.ObtenerConexion();
		 
		 String qry = "SELECT * FROM cliente WHERE dni = ? and nombre = ?";
		 
		 stmt = cone.prepareStatement(qry);
		 
		 stmt.setString(1, c.getDni());
		 stmt.setString(2, c.getNombre());
		 
		 rst = stmt.executeQuery();
		 
		 while(rst.next()) {
			 cli = new Cliente(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getLong(5));
		 }
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener al usuario");
		}
		return cli;
		
	}
}
