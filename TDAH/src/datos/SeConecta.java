package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SeConecta {
	
	 private Connection con;
	public Connection Conectar() {
		try {
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/TDAH","root","");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"error al conectar" +e);
		}
		return con;
	}

}
