package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarLicuadora extends JDialog implements ActionListener {
	private JLabel lblModelo;
	private JComboBox cboModelo;
	private JButton btnCerrar;
	private JLabel lblPrecio;
	private JLabel lblPotencia;
	private JLabel lblCapacidad;
	private JLabel lblVelocidades;
	private JTextField txtPrecio;
	private JTextField txtPotencia;
	private JTextField txtCapacidad;
	private JTextField txtVelocidades;
	
	
	private JPanel contentPane;
	private JMenuBar mnLicuadoras;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultarLicuadora;
	private JMenuItem mntmModificarLicuadora;
	private JMenuItem mntmListarLicuadora;
	
	//creacion de variables privates de la ventana de dialogo ConsultarLicuadora
	private int velocidades, indModelo;
	private double precio, potencia, capacidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarLicuadora dialog = new ConsultarLicuadora();
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
	public ConsultarLicuadora() {
		setTitle("Consultar Licuadora");
		setBounds(100, 100, 459, 257);
		getContentPane().setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 28, 94, 13);
		getContentPane().add(lblModelo);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Oster", "Ninja", "Kitchenaid", "Wurden", "Electric Life"}));
		cboModelo.setBounds(133, 24, 184, 21);
		getContentPane().add(cboModelo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(355, 24, 85, 21);
		getContentPane().add(btnCerrar);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 69, 94, 13);
		getContentPane().add(lblPrecio);
		
		lblPotencia = new JLabel("Potencia (W)");
		lblPotencia.setBounds(10, 108, 113, 13);
		getContentPane().add(lblPotencia);
		
		lblCapacidad = new JLabel("Capacidad (l)");
		lblCapacidad.setBounds(10, 146, 113, 13);
		getContentPane().add(lblCapacidad);
		
		lblVelocidades = new JLabel("Velocidades");
		lblVelocidades.setBounds(10, 185, 123, 13);
		getContentPane().add(lblVelocidades);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(133, 66, 181, 19);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtPotencia = new JTextField();
		txtPotencia.setEditable(false);
		txtPotencia.setBounds(133, 105, 184, 19);
		getContentPane().add(txtPotencia);
		txtPotencia.setColumns(10);
		
		txtCapacidad = new JTextField();
		txtCapacidad.setEditable(false);
		txtCapacidad.setBounds(133, 143, 184, 19);
		getContentPane().add(txtCapacidad);
		txtCapacidad.setColumns(10);
		
		txtVelocidades = new JTextField();
		txtVelocidades.setEditable(false);
		txtVelocidades.setBounds(133, 182, 184, 19);
		getContentPane().add(txtVelocidades);
		txtVelocidades.setColumns(10);
		
		
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
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose(); // cierra la ventana de dialogo
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		getModelo();
		cargarDatosLicuadora();
		mostrarDatos(precio, potencia, capacidad, velocidades);
	}
	
	
	//-----MÉTODOS---->
	
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
		
	
	
	
}
