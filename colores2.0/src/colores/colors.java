package colores;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;

public class colors {

	private JFrame frmColores;
	private JComboBox cmbOPCIONES;
	private JLabel lblOpciones;
	private JLabel lblOpciones_1;
	private JSlider sldnumero;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					colors window = new colors();
					window.frmColores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public colors() {
		initialize();
		cambiarColor();
	}
	public void cambiarColor() {
		lblOpciones_1.setText(""+sldnumero.getValue());
		String color=String.valueOf(cmbOPCIONES.getSelectedItem());
		switch (color) {
		case "Rojo":
			lblOpciones.setBackground(Color.red);
			break;
		case "Azul":
			lblOpciones.setBackground(Color.blue);
			break;
		case "verde":
			lblOpciones.setBackground(Color.green);
			break;
		case "Rosa":
			lblOpciones.setBackground(Color.pink);
			break;
		case "Negro":
			lblOpciones.setBackground(Color.black);
			break;
			default:
				break;
		
		}
		
	}
	
	private void initialize() {
		frmColores = new JFrame();
		frmColores.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Pictures\\cecytem logo.jpg"));
		frmColores.setTitle("Colores2.0");
		frmColores.setBounds(100, 100, 586, 415);
		frmColores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmColores.setLocationRelativeTo(null);
		frmColores.getContentPane().setLayout(null);
		
		cmbOPCIONES = new JComboBox();
		cmbOPCIONES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor();
				
			}
		});
		cmbOPCIONES.setModel(new DefaultComboBoxModel(new String[] {"Rojo", "Azul", "Verde", "Rosa", "Negro"}));
		cmbOPCIONES.setBounds(57, 131, 154, 22);
		frmColores.getContentPane().add(cmbOPCIONES);
		
		lblOpciones = new JLabel("OPCIONES");
		lblOpciones.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblOpciones.setBounds(57, 98, 96, 22);
		frmColores.getContentPane().add(lblOpciones);
		
		lblOpciones_1 = new JLabel("");
		lblOpciones_1.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblOpciones_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpciones_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblOpciones_1.setOpaque(true);
		lblOpciones_1.setBounds(80, 198, 359, 129);
		frmColores.getContentPane().add(lblOpciones_1);
		
		sldnumero = new JSlider();
		sldnumero.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cambiarColor();	
			}
		});
		sldnumero.setValue(1);
		sldnumero.setMinimum(1);
		sldnumero.setBounds(57, 49, 200, 26);
		frmColores.getContentPane().add(sldnumero);
		
		JLabel lblNewLabel = new JLabel("numero");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 17));
		lblNewLabel.setBounds(57, 11, 77, 26);
		frmColores.getContentPane().add(lblNewLabel);
	}
}
