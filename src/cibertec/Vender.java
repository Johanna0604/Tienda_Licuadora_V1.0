package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vender extends JDialog implements ActionListener {
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JComboBox cboModelo;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnVender;
	private JButton btnCerrar;
	private JScrollPane scpPane;
	private JTextArea txtS;
	
	private int indModelo;
	private double precio;
	private int cantidad;
	//Privadas para el alert
	private double sumaTotalVentas;
	private int contadorVentas;
	private double cuotaDiaria = 50000;
	private double porcentajeCD;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender dialog = new Vender();
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
	public Vender() {
		setTitle("Vender");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 36, 96, 13);
		getContentPane().add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 59, 96, 13);
		getContentPane().add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 82, 96, 13);
		getContentPane().add(lblCantidad);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Oster", "Ninja", "Kitchenaid", "Wurden", "Electric Life"}));
		cboModelo.setBounds(137, 28, 96, 21);
		getContentPane().add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(137, 56, 96, 19);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(137, 79, 96, 19);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(321, 29, 85, 21);
		getContentPane().add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(321, 52, 85, 21);
		getContentPane().add(btnCerrar);
		
		scpPane = new JScrollPane();
		scpPane.setBounds(10, 105, 416, 148);
		getContentPane().add(scpPane);
		
		txtS = new JTextArea();
		scpPane.setViewportView(txtS);
		
		getModelo();
		obtenerPrecioSegunModelo();
		mostrarPrecio();

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		getModelo();
		obtenerPrecioSegunModelo();
		mostrarPrecio();
		
	}
	
	//-------MÉTODOS ----->
	
	//Métodos para traer, hallar y mostrar el precio
	
	int getModelo() {
		indModelo = cboModelo.getSelectedIndex();
		return indModelo;
	}
	
	
	double obtenerPrecioSegunModelo() {
		
		switch (indModelo) {
			case 0: precio = LicuadorasProyect.precio0;
			break;
			case 1: precio = LicuadorasProyect.precio1;
			break;
			case 2: precio = LicuadorasProyect.precio2;
			break;
			case 3: precio = LicuadorasProyect.precio3;
			break;
			case 4: precio = LicuadorasProyect.precio4;
			break;
		}
		
		return precio;
	}
	
	void mostrarPrecio() {
		txtPrecio.setText(String.valueOf(precio));
	}
	
	
	//Métodos para calcular la venta
	protected void actionPerformedBtnVender(ActionEvent e) {
		
		String itemModelo = getItemModelo();//Item Modelo Licuadora para imprimir en txtS
		obtenerPrecioSegunModelo(); //Informa al usuario de precios preestablecidos
		aceptarGuardarCantidad(); //validar y guardar cantidad
		//Proceso de datos
		double importeCompra = calcImporteCompra(cantidad);
		double importeDescuento = calcImporteDescuento(importeCompra, cantidad);
		double importePagar = calcImportePagar(importeCompra, importeDescuento);
		String obsequio = hallarObsequio(cantidad);
		//Resultados
		mostrarBoleta(itemModelo, precio, cantidad, importeCompra, importeDescuento, importePagar, obsequio, contadorVentas);
		//Métodos para mensaje de ALERTA!
		calcSumaVentas(importePagar);
		calcPorcentajeCuotaDiaria(cuotaDiaria, sumaTotalVentas);
		contarVentas();
		mostrarAlert();
	}
	
	
	
	void aceptarGuardarCantidad() {
		
		try {
	       cantidad =  Integer.parseInt(txtCantidad.getText());
	        if (cantidad <= 0) {
	            JOptionPane.showMessageDialog(
	            		this, "La cantidad debe ser mayor a cero",
	            		"Error",                         
	            		JOptionPane.ERROR_MESSAGE);
	            
	            txtCantidad.setText("");
		        txtCantidad.requestFocus();
		        return;
	        	}
	        
	            
			}
	            catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(this, 
	                    "Ingrese valores numéricos válidos", 
	                    "Error", 
	                    JOptionPane.ERROR_MESSAGE);
	                
	                txtCantidad.setText("");
	                txtCantidad.requestFocus();   
	            	}
	}
	
	double calcImporteCompra (int cantidad) {
		double importeCompra;
		importeCompra = precio * cantidad;
		return importeCompra;
	}
	
	double calcImporteDescuento(double importeCompra, int cantidad) {
		double importeDescuento;
		double porcentaje=0.0;
		
		//calcular porcentaje de acuerdo a al cantidad
		
		if(cantidad >= 1 && cantidad <= 5)
			porcentaje = LicuadorasProyect.porcentaje1;
		else
			if(cantidad >= 6 && cantidad <= 10)
				porcentaje = LicuadorasProyect.porcentaje2;
			else
				if(cantidad >= 11 && cantidad <= 15)
					porcentaje = LicuadorasProyect.porcentaje3;
				else
					if(cantidad > 15)
						porcentaje = LicuadorasProyect.porcentaje4;
		
		importeDescuento = (importeCompra * porcentaje)/100;
		return importeDescuento;
		
	}
	
	double calcImportePagar(double importeCompra, double importeDescuento) {
		double importePagar;
		importePagar = importeCompra - importeDescuento;
		
		return importePagar;
	}
	
	String hallarObsequio (int cantidad) {
		String obsequio;
		
		//hallar obsequiops de acuerdo a la cantidad
		
		if(cantidad == 1)
			obsequio = LicuadorasProyect.obsequio1;
		else
			if(cantidad >=2 && cantidad <= 5)
				obsequio = LicuadorasProyect.obsequio2;
			else
				obsequio = LicuadorasProyect.obsequio3;
		
		return obsequio;
		
	}
	
	String getItemModelo() {
		return cboModelo.getSelectedItem().toString();
		
	}
	
	void mostrarBoleta(String itemModelo, double precio, int cantidad, double importeCompra, double importeDescuento, double importePagar, String obsequio, int contadorVentas) {
		
		txtS.setText("BOLETA DE VENTA" + "\n" +  "\n" );
		txtS.append("Modelo 		: " + itemModelo + "\n" );
		txtS.append("Precio 		: S/" + precio + "\n" );
		txtS.append("Cantidad 		: " + cantidad + "\n" );
		txtS.append("Importe Compra 	: S/" + importeCompra + "\n" );
		txtS.append("Importe Descuento 	: S/" + importeDescuento + "\n" );
		txtS.append("Importe Pagar 		: S/" + importePagar + "\n" );
		txtS.append("Obsequio 		: " + obsequio);
	}
	
	//Métodos para datos que incluye el alert
	double calcSumaVentas(double importePagar) {
		sumaTotalVentas += importePagar;
		return sumaTotalVentas;
	}
	
	int contarVentas() {
		return contadorVentas++;
	}

	double calcPorcentajeCuotaDiaria(double cuotaDiaria, double sumaTotalVentas) {
		porcentajeCD = (sumaTotalVentas/cuotaDiaria)*100;
		return porcentajeCD;
	}
	
	//Metodo para mostrar el ALERT!!...
	void mostrarAlert() {
		if (contadorVentas %5 == 0) {
			JOptionPane.showMessageDialog(
				this, 
				"Venta nro " + contadorVentas + "\n"
				+ "Importe total general acumulado S/"+ String.format("%.2f", sumaTotalVentas) + "\n" 
				+ "Porcentaje de la cuota diaria: "+ String.format("%.2f", porcentajeCD) + "%",
				"Avance de ventas",
				JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	//Método para cerrar dialogo
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
