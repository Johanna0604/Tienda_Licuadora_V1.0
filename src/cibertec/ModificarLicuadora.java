package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarLicuadora extends JDialog implements ActionListener {
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblPotencia;
	private JLabel lblCapacidad;
	private JLabel lblVelocidades;
	private JComboBox cboModelo;
	private JTextField txtPrecio;
	private JTextField txtPotencia;
	private JTextField txtCapacidad;
	private JTextField txtVelocidades;
	private JButton btnGuardar;
	private JButton btnCerrar;
	
	//declaramos variables privates del la ventana de dialogo ModificarLicuadora
	private int velocidades, indModelo;
	private double precio, potencia, capacidad;
	//Para guardar los nuevos valores a variables globales de LicuadorasProyect
	//declaramos variables con prefijo "nuevo" por comodidad
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarLicuadora dialog = new ModificarLicuadora();
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
	public ModificarLicuadora() {
		setTitle("Modificar Licuadora");
		setBounds(100, 100, 459, 257);
		getContentPane().setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 21, 45, 13);
		getContentPane().add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 56, 91, 13);
		getContentPane().add(lblPrecio);
		
		lblPotencia = new JLabel("Potencia (W)");
		lblPotencia.setBounds(10, 95, 122, 13);
		getContentPane().add(lblPotencia);
		
		lblCapacidad = new JLabel("Capacidad (l)");
		lblCapacidad.setBounds(10, 135, 122, 13);
		getContentPane().add(lblCapacidad);
		
		lblVelocidades = new JLabel("Velocidades");
		lblVelocidades.setBounds(10, 175, 108, 13);
		getContentPane().add(lblVelocidades);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Oster", "Ninja", "Kitchenaid", "Wurden", "Electric Life"}));
		cboModelo.setBounds(142, 21, 163, 21);
		getContentPane().add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(142, 56, 163, 19);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtPotencia = new JTextField();
		txtPotencia.setBounds(142, 92, 163, 19);
		getContentPane().add(txtPotencia);
		txtPotencia.setColumns(10);
		
		txtCapacidad = new JTextField();
		txtCapacidad.setBounds(142, 132, 163, 19);
		getContentPane().add(txtCapacidad);
		txtCapacidad.setColumns(10);
		
		txtVelocidades = new JTextField();
		txtVelocidades.setBounds(142, 172, 163, 19);
		getContentPane().add(txtVelocidades);
		txtVelocidades.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(339, 21, 85, 21);
		getContentPane().add(btnGuardar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(339, 52, 85, 21);
		getContentPane().add(btnCerrar);
		
		
		getModelo();
		cargarDatosLicuadora();
		mostrarDatos(precio, potencia, capacidad, velocidades);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}
	
	protected void actionPerformedCboModelo(ActionEvent e) {
		//Métodos creados para 
		getModelo();
		cargarDatosLicuadora();
		mostrarDatos(precio, potencia, capacidad, velocidades);
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		//Métodos creados para guardar data
		aceptarYGuardarValores();
		
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		
		dispose();
	}
	
	//----MÉTODOS----->
	
	// Métodos para cargar la data por cada nueva seleccion de licuadora
			int getModelo() {
				indModelo = cboModelo.getSelectedIndex();
				return indModelo;
				}
				
			
			void cargarDatosLicuadora() {
					
					switch (indModelo) {
						case 0: precio = LicuadorasProyect.precio0;
								potencia = LicuadorasProyect.potencia0;
								capacidad = LicuadorasProyect.capacidad0;
								velocidades = LicuadorasProyect.velocidades0;
								break;
						case 1: precio = LicuadorasProyect.precio1;
								potencia = LicuadorasProyect.potencia1;
								capacidad = LicuadorasProyect.capacidad1;
								velocidades = LicuadorasProyect.velocidades1;
								break;
						case 2: precio = LicuadorasProyect.precio2;
								potencia = LicuadorasProyect.potencia2;
								capacidad = LicuadorasProyect.capacidad2;
								velocidades = LicuadorasProyect.velocidades2;
								break;
						case 3: precio = LicuadorasProyect.precio3;
								potencia = LicuadorasProyect.potencia3;
								capacidad = LicuadorasProyect.capacidad3;
								velocidades = LicuadorasProyect.velocidades3;
								break;
						case 4: precio = LicuadorasProyect.precio4;
								potencia = LicuadorasProyect.potencia4;
								capacidad = LicuadorasProyect.capacidad4;
								velocidades = LicuadorasProyect.velocidades4;
								break;	
						}
				
				}
				
			void mostrarDatos(double precio, double potencia, double capacidad, int velocidades) {
				txtPrecio.setText(String.valueOf(precio));
				txtPotencia.setText(String.valueOf(potencia));
				txtCapacidad.setText(String.valueOf(capacidad));
				txtVelocidades.setText(String.valueOf(velocidades));
				
			}
		
		
		//Aceptar y Guardar de nuevos valores
		
		void aceptarYGuardarValores() {
			if (indModelo == 0)
				try {
					double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
					double nuevaPotencia = Double.parseDouble(txtPotencia.getText());
					double nuevaCapacidad = Double.parseDouble(txtCapacidad.getText());
					int nuevasVelocidades = Integer.parseInt(txtVelocidades.getText());
					
					if(nuevoPrecio < 0 || nuevaPotencia < 0 || nuevaCapacidad < 0 || nuevasVelocidades < 0) {
						JOptionPane.showMessageDialog(
								this, 
								"Ingrese números mayores a cero.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					LicuadorasProyect.precio0 = nuevoPrecio;
					LicuadorasProyect.potencia0 = nuevaPotencia;
					LicuadorasProyect.capacidad0 = nuevaCapacidad;
					LicuadorasProyect.velocidades0 = nuevasVelocidades;
					
					JOptionPane.showMessageDialog(
							this,
							"Los valores han sido actualizados correctamente",
							"Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					
					dispose();
					
				}
				catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(
							this,
							"Ingrese valores numéricos válidos.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
					
		
		else 
			if (indModelo == 1)
				try {
					double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
					double nuevaPotencia = Double.parseDouble(txtPotencia.getText());
					double nuevaCapacidad = Double.parseDouble(txtCapacidad.getText());
					int nuevasVelocidades = Integer.parseInt(txtVelocidades.getText());
					
					if(nuevoPrecio < 0 || nuevaPotencia < 0 || nuevaCapacidad < 0 || nuevasVelocidades <0) {
						JOptionPane.showMessageDialog(
								this, 
								"Ingrese números mayores a cero.",
								"ERROR",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					LicuadorasProyect.precio1 = nuevoPrecio;
					LicuadorasProyect.potencia1 = nuevaPotencia;
					LicuadorasProyect.capacidad1 = nuevaCapacidad;
					LicuadorasProyect.velocidades1 = nuevasVelocidades;
					
					JOptionPane.showMessageDialog(
							this,
							"Los valores han sido actualizados correctamente",
							"Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					
					dispose();
					
				}
				catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(
							this,
							"Ingrese valores numéricos válidos.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			
			
			else 
				if (indModelo == 2)
					try {
						double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
						double nuevaPotencia = Double.parseDouble(txtPotencia.getText());
						double nuevaCapacidad = Double.parseDouble(txtCapacidad.getText());
						int nuevasVelocidades = Integer.parseInt(txtVelocidades.getText());
						
						if(nuevoPrecio < 0 || nuevaPotencia < 0 || nuevaCapacidad < 0 || nuevasVelocidades <0) {
							JOptionPane.showMessageDialog(
									this, 
									"Ingrese números mayores a cero.",
									"ERROR",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						LicuadorasProyect.precio2 = nuevoPrecio;
						LicuadorasProyect.potencia2 = nuevaPotencia;
						LicuadorasProyect.capacidad2 = nuevaCapacidad;
						LicuadorasProyect.velocidades2 = nuevasVelocidades;
						
						JOptionPane.showMessageDialog(
								this,
								"Los valores han sido actualizados correctamente",
								"Éxito",
								JOptionPane.INFORMATION_MESSAGE);
						
						dispose();
						
					}
					catch (NumberFormatException ex){
						JOptionPane.showMessageDialog(
								this,
								"Ingrese valores numéricos válidos.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
					}
				
				else
					if (indModelo == 3)
						try {
							double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
							double nuevaPotencia = Double.parseDouble(txtPotencia.getText());
							double nuevaCapacidad = Double.parseDouble(txtCapacidad.getText());
							int nuevasVelocidades = Integer.parseInt(txtVelocidades.getText());
							
							if(nuevoPrecio < 0 || nuevaPotencia < 0 || nuevaCapacidad < 0 || nuevasVelocidades <0) {
								JOptionPane.showMessageDialog(
										this, 
										"Ingrese números mayores a cero.",
										"ERROR",
										JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							LicuadorasProyect.precio3 = nuevoPrecio;
							LicuadorasProyect.potencia3 = nuevaPotencia;
							LicuadorasProyect.capacidad3 = nuevaCapacidad;
							LicuadorasProyect.velocidades3 = nuevasVelocidades;
							
							JOptionPane.showMessageDialog(
									this,
									"Los valores han sido actualizados correctamente",
									"Éxito",
									JOptionPane.INFORMATION_MESSAGE);
							
							dispose();
							
						}
						catch (NumberFormatException ex){
							JOptionPane.showMessageDialog(
									this,
									"Ingrese valores numéricos válidos.",
									"Error",
									JOptionPane.ERROR_MESSAGE);
						}
			
					else
						if (indModelo == 4)
							try {
								double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
								double nuevaPotencia = Double.parseDouble(txtPotencia.getText());
								double nuevaCapacidad = Double.parseDouble(txtCapacidad.getText());
								int nuevasVelocidades = Integer.parseInt(txtVelocidades.getText());
								
								if(nuevoPrecio < 0 || nuevaPotencia < 0 || nuevaCapacidad < 0 || nuevasVelocidades <0) {
									JOptionPane.showMessageDialog(
											this, 
											"Ingrese números mayores a cero.",
											"ERROR",
											JOptionPane.ERROR_MESSAGE);
									return;
								}
								
								LicuadorasProyect.precio4 = nuevoPrecio;
								LicuadorasProyect.potencia4 = nuevaPotencia;
								LicuadorasProyect.capacidad4 = nuevaCapacidad;
								LicuadorasProyect.velocidades4 = nuevasVelocidades;
								
								JOptionPane.showMessageDialog(
										this,
										"Los valores han sido actualizados correctamente",
										"Éxito",
										JOptionPane.INFORMATION_MESSAGE);
								
								dispose();
								
							}
							catch (NumberFormatException ex){
								JOptionPane.showMessageDialog(
										this,
										"Ingrese valores numéricos válidos.",
										"Error",
										JOptionPane.ERROR_MESSAGE);
							}
	
		}	
	

}
