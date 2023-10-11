package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Login;

public class LoginDAO {

	SeConecta sc=new SeConecta();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean guardarLogin(Login l) {
		boolean guardado=false;
	    String sql="insert into logins values(0,?,?,?)";
	    con = sc.Conectar();
	    try {
			int guardada=0;
			boolean exist=validarUsuario(l.getUsuario());
			if(exist == false) {
				ps=con.prepareStatement(sql);
				ps.setString(1,l.getUsuario());
				ps.setString(2,l.getContrasenia());
				ps.setString(3,l.getEmail());
			guardada =ps.executeUpdate();
			if (guardada>0) {
				JOptionPane.showMessageDialog(null,"GUARDADO");
				guardado=true;
			}else {
				JOptionPane.showMessageDialog(null," NO GUARDADO");
			}}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"error al conectar" +e);
		}
	    
		return guardado ;
	}
	
	public boolean  validarUsuario(String us) {
		String sql="select *from logins where usuario=?";
		con=sc.Conectar();
		boolean existe=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,us);
			rs=ps.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null,"usar otro usuario");
				existe=true;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"error al validar:" +e);
		}
		return existe;
		
	}

	public void consultarLogin(Login l) {
		con=sc.Conectar();
		String sql="select *from logins where usuario=? and contrasenia=? and email=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,l.getUsuario());
			ps.setString(2,l.getContrasenia());
			ps.setString(3,l.getEmail());
			rs=ps.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null,"bienvenido:  " +rs.getString(2));
			}else {
				JOptionPane.showMessageDialog(null,"algo incorrecto!!!");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"error al consultar" +e);
		}
		}

	public boolean actualizar(Login l) {
		boolean actualizado =false;
		con=sc.Conectar();
		 try {
			ps=con.prepareStatement("update logins set contrasenia=?,email=? where  usuario=?");
			ps.setString(1,l.getContrasenia());
			ps.setString(2,l.getEmail());
			ps.setString(3,l.getUsuario());
			int actualizar=ps.executeUpdate();
			if(actualizar>0) {
				JOptionPane.showMessageDialog(null,"actulizado");
			}else {
				JOptionPane.showMessageDialog(null,"intentelo otra vez");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"error al conectar" +e);
		}
		return actualizado;
		
	}
	public boolean eliminarLogin(Login l) {
		boolean eliminado=false;
		con=sc.Conectar();
		
		try {
			ps=con.prepareStatement("delete  from logins  where usuario=?");
			ps.setString(1,l.getUsuario());
			int eliminar=ps.executeUpdate();
			if(eliminar>0) {
			  JOptionPane.showMessageDialog(null,"eliminado");
			  eliminado=true;
			}else {
				JOptionPane.showMessageDialog(null," no eliminado");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"error al conectar" +e);
		}
		return eliminado;
		
	}
	
}
