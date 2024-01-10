package conexion_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConexion {
	
	public static Connection ObtenerConexion() {
				Connection con = null;
					try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/abarrotes_java";
					String usuario = "root";
					String contrase = "";
					
					con = DriverManager.getConnection(url,usuario,contrase);
					
					
				} catch (ClassNotFoundException e) {
					System.out.println("Error en el driver");
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("Error al conectar a la Base");
					e.printStackTrace();
				}	
				return con;

}
}
