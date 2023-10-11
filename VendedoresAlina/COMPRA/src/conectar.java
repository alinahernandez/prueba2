import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class conectar {
	Connection c = conexiones();
}
	try {
		
	
	private Object textField;
	private Object textField_1;
	private Object textField_2;
	
		String sql="INSERT INTO campo VALUES(?,?,?)";
		PreparedStatement ptm=c.prepareStatement(sql);
		ptm.setString(1, textField.getText());
		ptm.setString(2, textField_1.getText());
		ptm.setString(3, textField_2.getText());
		int k = ptm.executeUpdate();
		if (k>1) {
			JOptionPane.showMessageDialog(null, "Se agrego el registro");
			limpiar();
		}
		else {
			JOptionPane.showMessageDialog(null, "No agrego el registro");
		}
	
		// TODO Auto-generated method stub

	 catch (Exception e) {
	private JOptionPane ex; {
		JOptionPane.showMessageDialog(null, "" + ex.getMessage());


	}
	private void limpiar() {
		// TODO Auto-generated method stub
		
	}
	private Connection conexiones() {
		// TODO Auto-generated method stub
		return null;
	}}

	
		
		
	
	
	
		
	


