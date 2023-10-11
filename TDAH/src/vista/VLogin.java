package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.LoginDAO;
import modelo.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class VLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtusuario;
	private JTextField txtcontrasenia;
	private JTextField txtemail;
	private JLabel lblcontrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VLogin frame = new VLogin();
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
	public VLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("           id:");
		lblid.setBounds(32, 64, 46, 14);
		contentPane.add(lblid);
		
		JLabel lblusuario = new JLabel("   usuario:");
		lblusuario.setBounds(32, 101, 56, 14);
		contentPane.add(lblusuario);
		
		lblcontrasenia = new JLabel(" contrasenia:");
		lblcontrasenia.setBounds(32, 139, 71, 14);
		contentPane.add(lblcontrasenia);
		
		JLabel lblemail = new JLabel("      email:");
		lblemail.setBounds(32, 183, 46, 14);
		contentPane.add(lblemail);
		
		txtid = new JTextField();
		txtid.setBounds(124, 61, 86, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(124, 98, 86, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		txtcontrasenia = new JTextField();
		txtcontrasenia.setBounds(124, 136, 86, 20);
		contentPane.add(txtcontrasenia);
		txtcontrasenia.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(124, 180, 86, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(250, 60, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtusuario.getText().isEmpty() || txtcontrasenia.getText().isEmpty() || txtemail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"llena todos los campos");
				}else {
					guardar();
				}
			}
		});
		contentPane.add(btnGuardar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtusuario.getText().isEmpty() || txtcontrasenia.getText().isEmpty() || txtemail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"llena todos los campos");
				}else {
					actualizar();
				}
				
			}
		});
		btnActualizar.setBounds(250, 108, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtusuario.getText().isEmpty() || txtcontrasenia.getText().isEmpty() || txtemail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"llena todos los campos");
				}else {
					consultar();	
				}
			}
		});
		btnConsultar.setBounds(250, 162, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elimnar();
			}
		});
		btnEliminar.setBounds(250, 205, 89, 23);
		contentPane.add(btnEliminar);
	}
	private boolean guardar() {
		Login l = new Login();
		LoginDAO ld = new LoginDAO();
		l.setUsuario(txtusuario.getText());
		l.setContrasenia(txtcontrasenia.getText());
		l.setEmail(txtemail.getText());
		boolean g=ld.guardarLogin(l);
		return g;
	}
	private void consultar() {
		LoginDAO ld=new LoginDAO();
		Login l=new Login();
		l.setUsuario(txtusuario.getText());
		l.setContrasenia(txtcontrasenia.getText());
		l.setEmail(txtemail.getText());
		ld.consultarLogin(l);
	}
	public boolean actualizar() {
		Login l=new Login();
		l.setUsuario(txtusuario.getText());
		l.setContrasenia(txtcontrasenia.getText());
		l.setEmail(txtemail.getText());
		LoginDAO ld= new LoginDAO();
		boolean b=ld.actualizar(l);
		return b;
		
	}
	public boolean elimnar() {
		Login l = new Login();
		l.setUsuario(txtusuario.getText());
		LoginDAO ld= new LoginDAO();
		boolean b=ld.eliminarLogin(l);
		return b;
		
	}
}
