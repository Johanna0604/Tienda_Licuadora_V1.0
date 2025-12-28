package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarObsequios extends JDialog implements ActionListener {
	private JLabel lblCantidad1;
	private JLabel lblCantidad2;
	private JLabel lblCantidad3;
	private JTextField txtObsequio1;
	private JTextField txtObsequio2;
	private JTextField txtObsequio3;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private String obsequio1, obsequio2, obsequio3;
	private String nuevoObsequio1, nuevoObsequio2, nuevoObsequio3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarObsequios dialog = new ConfigurarObsequios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarObsequios() {
		setTitle("Configurar Obsequio");
		setBounds(100, 100, 501, 200);
		getContentPane().setLayout(null);
		
		lblCantidad1 = new JLabel("1 unidad");
		lblCantidad1.setBounds(37, 41, 172, 13);
		getContentPane().add(lblCantidad1);
		
		lblCantidad2 = new JLabel("2 a 5 unidades");
		lblCantidad2.setBounds(37, 77, 172, 13);
		getContentPane().add(lblCantidad2);
		
		lblCantidad3 = new JLabel("6 a m\u00E1s unidades");
		lblCantidad3.setBounds(37, 113, 172, 13);
		getContentPane().add(lblCantidad3);
		
		txtObsequio1 = new JTextField();
		txtObsequio1.setBounds(196, 38, 135, 19);
		getContentPane().add(txtObsequio1);
		txtObsequio1.setColumns(10);
		
		txtObsequio2 = new JTextField();
		txtObsequio2.setBounds(196, 74, 135, 19);
		getContentPane().add(txtObsequio2);
		txtObsequio2.setColumns(10);
		
		txtObsequio3 = new JTextField();
		txtObsequio3.setBounds(196, 110, 135, 19);
		getContentPane().add(txtObsequio3);
		txtObsequio3.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(370, 37, 85, 21);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(370, 73, 85, 21);
		getContentPane().add(btnCancelar);
		
		getObsequio1();
		getObsequio2();
		getObsequio3();
		mostrarDatos();
		

	}
	
	String getObsequio1() {
		obsequio1= LicuadorasProyect.obsequio1;
		return obsequio1;
	}
	String getObsequio2() {
		obsequio2= LicuadorasProyect.obsequio2;
		return obsequio2;
	}
	String getObsequio3() {
		obsequio3= LicuadorasProyect.obsequio3;
		return obsequio3;
	}
	
	void mostrarDatos() {
		txtObsequio1.setText(String.valueOf(obsequio1));
		txtObsequio2.setText(String.valueOf(obsequio2));
		txtObsequio3.setText(String.valueOf(obsequio3));
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		aceptarObsequios();
		
		
	}
	
	void aceptarObsequios() {
		nuevoObsequio1 = txtObsequio1.getText().trim();
		nuevoObsequio2 = txtObsequio2.getText().trim();
		nuevoObsequio3 = txtObsequio3.getText().trim();
		
		if (nuevoObsequio1.isEmpty() || nuevoObsequio2.isEmpty() || nuevoObsequio3.isEmpty()) {
			JOptionPane.showMessageDialog(this,
				"Todos los campos son obligatorios",
				"Error",
				JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		LicuadorasProyect.obsequio1 = nuevoObsequio1;
		LicuadorasProyect.obsequio2 = nuevoObsequio2;
		LicuadorasProyect.obsequio3 = nuevoObsequio3;
		
		JOptionPane.showMessageDialog(this,
			"Los obsequios han sido actualizados correctamente",
			"Éxito",
			JOptionPane.INFORMATION_MESSAGE);
		dispose();
	}



	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
