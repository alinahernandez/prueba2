package proyectoSellers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NegocioSeller {

	private JFrame frmSellers;
	private String sellerCode;
	private String firstName;
	private String emailAddres;
	private JTextField txtSellerCode;
	private JTextField txtfirstName;
	private JTextField txtemailAddres;
	private JTextField textField;

	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setEmailAddres(String emailAddres) {
		this.emailAddres = emailAddres;
	}

	public JFrame getFrmSellers() {
		return frmSellers;
	}

	public String getSellerCode() {
		return sellerCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmailAddres() {
		return emailAddres;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NegocioSeller window = new NegocioSeller();
					window.frmSellers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NegocioSeller() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSellers = new JFrame();
		frmSellers.setBounds(100, 100, 450, 300);
		frmSellers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSellers.getContentPane().setLayout(null);

		JLabel lblsellerCode = new JLabel("seller code:");
		lblsellerCode.setBounds(36, 38, 86, 14);
		frmSellers.getContentPane().add(lblsellerCode);

		txtSellerCode = new JTextField();
		txtSellerCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtSellerCode.getText().length()>=5) {
					e.consume();
					JOptionPane.showMessageDialog(null,"la longitud maxima es de 5");
				}
			}
		});
		txtSellerCode.setBounds(154, 35, 86, 20);
		frmSellers.getContentPane().add(txtSellerCode);
		txtSellerCode.setColumns(10);

		JLabel lblFirstName = new JLabel("first name:");
		lblFirstName.setBounds(36, 83, 86, 14);
		frmSellers.getContentPane().add(lblFirstName);

		JLabel lblEmailAddress = new JLabel("email Addres:");
		lblEmailAddress.setBounds(36, 124, 86, 14);
		frmSellers.getContentPane().add(lblEmailAddress);

		txtfirstName = new JTextField();
		txtfirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtfirstName.getText().length()>=50) {
					e.consume();
					JOptionPane.showMessageDialog(null,"la longitud maxima es de 50");
				}
			}
		});
		txtfirstName.setColumns(10);
		txtfirstName.setBounds(154, 80, 86, 20);
		frmSellers.getContentPane().add(txtfirstName);

		txtemailAddres = new JTextField();
		txtemailAddres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtemailAddres.getText().length()>=50) {
					e.consume();
					JOptionPane.showMessageDialog(null,"la longitud maxima es de 50");
				}
			}
		});
		txtemailAddres.setColumns(10);
		txtemailAddres.setBounds(154, 121, 86, 20);
		frmSellers.getContentPane().add(txtemailAddres);

		JButton btnSaveSeller = new JButton("Save Seller");
		btnSaveSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSellerCode.getText().isEmpty() || txtfirstName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"El codigo y el nombre son obligatorios");
				}else {
					if(saveSeller()) {
						limpiarCampos();
					}
				}
			}
		});
		btnSaveSeller.setBounds(36, 168, 89, 23);
		frmSellers.getContentPane().add(btnSaveSeller);

		JButton btnfindSeller = new JButton("Find Seller");
		btnfindSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSellerCode.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"ingresa el cogigo para buscar");
				}else {
					findSeller();
				}
			}
		});
		btnfindSeller.setBounds(154, 168, 89, 23);
		frmSellers.getContentPane().add(btnfindSeller);

		JButton btnUpdateSeller = new JButton("Update Seller");
		btnUpdateSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSellerCode.getText().isEmpty() || txtfirstName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"El codigo y el nombre son obligatorios");
				}else {
					if(updateSeller()) {
						limpiarCampos();
					}
				}
			}
		});
		btnUpdateSeller.setBounds(275, 168, 89, 23);
		frmSellers.getContentPane().add(btnUpdateSeller);

		JButton btndeleteSeller = new JButton("Delete Seller");
		btndeleteSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSellerCode.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"llena el campo sellercode");
				}else if(deleteSeller()) {	
					limpiarCampos();
				}
			}
		});
		btndeleteSeller.setBounds(164, 212, 89, 23);
		frmSellers.getContentPane().add(btndeleteSeller);

		textField = new JTextField();
		textField.setBounds(154, 121, 86, 20);
		frmSellers.getContentPane().add(textField);
		textField.setColumns(10);
	}
	public void limpiarCampos() {
		txtSellerCode.setText("");
		txtfirstName.setText("");
		txtemailAddres.setText("");
	}
	public boolean saveSeller() {
		sellerCode = txtSellerCode.getText();
		firstName = txtfirstName.getText();
		emailAddres = txtemailAddres.getText();
		DataSeller ds=new DataSeller();
		return ds.saveSeller(this);
	}
	public boolean findSeller() {
		DataSeller ds= new DataSeller();
		sellerCode = txtSellerCode.getText();
		boolean encontrado=ds.findSeller(this);
		txtfirstName.setText(firstName);
		txtemailAddres.setText(emailAddres);
		return encontrado;
		
	}
	public boolean updateSeller() {
		sellerCode = txtSellerCode.getText();
		firstName = txtfirstName.getText();
		emailAddres = txtemailAddres.getText();
		DataSeller ds=new DataSeller();
		return ds.updateSeller(this);
	}
	public boolean deleteSeller() {
		sellerCode = txtSellerCode.getText();
		DataSeller ds= new DataSeller();
		return ds.delateSeller(this);
		
	}
}
