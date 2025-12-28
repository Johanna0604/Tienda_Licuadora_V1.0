package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarDescuentos extends JDialog implements ActionListener {
	private JLabel lblCantidad1;
	private JLabel lblCantidad2;
	private JLabel lblCantidad3;
	private JLabel lblCantidad4;
	private JTextField txtPorcentaje1;
	private JTextField txtPorcentaje2;
	private JTextField txtPorcentaje3;
	private JTextField txtPorcentaje4;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private double porcentaje1, porcentaje2, porcentaje3, porcentaje4;
	private double nuevoPorcentaje1, nuevoPorcentaje2, nuevoPorcentaje3, nuevoPorcentaje4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarDescuentos dialog = new ConfigurarDescuentos();
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
	public ConfigurarDescuentos() {
		setTitle("Configurar Descuentos");
		setBounds(100, 100, 533, 224);
		getContentPane().setLayout(null);
		
		lblCantidad1 = new JLabel("1 a 5 unidades");
		lblCantidad1.setBounds(24, 35, 232, 13);
		getContentPane().add(lblCantidad1);
		
		lblCantidad2 = new JLabel("6 a 10 unidades");
		lblCantidad2.setBounds(24, 73, 246, 13);
		getContentPane().add(lblCantidad2);
		
		lblCantidad3 = new JLabel("11 a 15 unidades");
		lblCantidad3.setBounds(24, 117, 232, 13);
		getContentPane().add(lblCantidad3);
		
		lblCantidad4 = new JLabel("M\u00E1s de 15 unidades");
		lblCantidad4.setBounds(24, 156, 232, 13);
		getContentPane().add(lblCantidad4);
		
		txtPorcentaje1 = new JTextField();
		txtPorcentaje1.setBounds(266, 32, 96, 19);
		getContentPane().add(txtPorcentaje1);
		txtPorcentaje1.setColumns(10);
		
		txtPorcentaje2 = new JTextField();
		txtPorcentaje2.setBounds(266, 70, 96, 19);
		getContentPane().add(txtPorcentaje2);
		txtPorcentaje2.setColumns(10);
		
		txtPorcentaje3 = new JTextField();
		txtPorcentaje3.setBounds(266, 114, 96, 19);
		getContentPane().add(txtPorcentaje3);
		txtPorcentaje3.setColumns(10);
		
		txtPorcentaje4 = new JTextField();
		txtPorcentaje4.setBounds(266, 153, 96, 19);
		getContentPane().add(txtPorcentaje4);
		txtPorcentaje4.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(412, 31, 85, 21);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(412, 69, 85, 21);
		getContentPane().add(btnCancelar);
		
		getPorcentaje1();
		getPorcentaje2();
		getPorcentaje3();
		getPorcentaje4();
		mostrarDatos(porcentaje1, porcentaje2, porcentaje3, porcentaje4);
	}
	
	double getPorcentaje1() {
		porcentaje1 = LicuadorasProyect.porcentaje1;
		return porcentaje1;
	}
	double getPorcentaje2() {
		porcentaje2 = LicuadorasProyect.porcentaje2;
		return porcentaje2;
	}
	double getPorcentaje3() {
		porcentaje3 = LicuadorasProyect.porcentaje3;
		return porcentaje3;
	}
	double getPorcentaje4() {
		porcentaje4 = LicuadorasProyect.porcentaje4;
		return porcentaje4;
	}
	
	void mostrarDatos(double porcentaje1, double porcentaje2, double porcentaje3, double porcentaje4) {
		txtPorcentaje1.setText(String.valueOf(porcentaje1));
		txtPorcentaje2.setText(String.valueOf(porcentaje2));
		txtPorcentaje3.setText(String.valueOf(porcentaje3));
		txtPorcentaje4.setText(String.valueOf(porcentaje4));
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
	
		//Metodos para aceptar y guardar nuevos valores de porcentajes
		aceptarDescuentos();
		
	}
	
	//Metodos para traer nuevos valores de porcentajes
	void aceptarDescuentos() {
		try {
			nuevoPorcentaje1 = Double.parseDouble(txtPorcentaje1.getText());
			nuevoPorcentaje2 = Double.parseDouble(txtPorcentaje2.getText());
			nuevoPorcentaje3 = Double.parseDouble(txtPorcentaje3.getText());
			nuevoPorcentaje4 = Double.parseDouble(txtPorcentaje4.getText());
			
			if (nuevoPorcentaje1 < 0 || nuevoPorcentaje1 > 100 || nuevoPorcentaje2 < 0 || nuevoPorcentaje2 > 100 ||
				nuevoPorcentaje3 < 0 || nuevoPorcentaje3 > 100 || nuevoPorcentaje4 < 0 || nuevoPorcentaje4 > 100) {
				
				JOptionPane.showMessageDialog(
					this,
					"Los porcentajes deben estar entre 0 y 100",
					"Error",
					JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			LicuadorasProyect.porcentaje1 = nuevoPorcentaje1;
			LicuadorasProyect.porcentaje2 = nuevoPorcentaje2;
			LicuadorasProyect.porcentaje3 = nuevoPorcentaje3;
			LicuadorasProyect.porcentaje4 = nuevoPorcentaje4;
			
			JOptionPane.showMessageDialog(this,
					"Los valores han sido actualizados correctamente",
					"Exito",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
		catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this,
				"Ingrese valores numéricos válidos",
				"Error",
				JOptionPane.ERROR_MESSAGE);
		}
	}


	
	
		//MEtodo para cerrar dialogo
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
