package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarLicuadoras extends JDialog implements ActionListener {
	private JScrollPane scpPane;
	private JButton btnListar;
	private JButton btnCerrar;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarLicuadoras dialog = new ListarLicuadoras();
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
	public ListarLicuadoras() {
		setTitle("Listar Licuadoras");
		setBounds(100, 100, 518, 620);
		getContentPane().setLayout(null);
		
		scpPane = new JScrollPane();
		scpPane.setBounds(10, 10, 484, 501);
		getContentPane().add(scpPane);
		
		txtS = new JTextArea();
		scpPane.setViewportView(txtS);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(92, 527, 100, 33);
		getContentPane().add(btnListar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(309, 527, 100, 33);
		getContentPane().add(btnCerrar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnListar(ActionEvent e) {
		listarLicuadoras();
	}
	
	void listarLicuadoras() {
		txtS.setText("LISTADO DE LICUADORAS" + "\n" + "\n");
		
		txtS.append("Modelo: " + LicuadorasProyect.modelo0 + "\n");
		txtS.append("Precio: " + LicuadorasProyect.precio0 + "\n");
		txtS.append("Potencia: " + LicuadorasProyect.potencia0 + "\n");
		txtS.append("Capacidad: " + LicuadorasProyect.capacidad0 + "\n");
		txtS.append("Velocidades: " + LicuadorasProyect.velocidades0 + "\n" + "\n");
		
		txtS.append("Modelo: " + LicuadorasProyect.modelo1 + "\n");
		txtS.append("Precio: " + LicuadorasProyect.precio1 + "\n");
		txtS.append("Potencia: " + LicuadorasProyect.potencia1 + "\n");
		txtS.append("Capacidad: " + LicuadorasProyect.capacidad1 + "\n");
		txtS.append("Velocidades: " + LicuadorasProyect.velocidades1 + "\n" + "\n");
		
		txtS.append("Modelo: " + LicuadorasProyect.modelo2 + "\n");
		txtS.append("Precio: " + LicuadorasProyect.precio2 + "\n");
		txtS.append("Potencia: " + LicuadorasProyect.potencia2 + "\n");
		txtS.append("Capacidad: " + LicuadorasProyect.capacidad2 + "\n");
		txtS.append("Velocidades: " + LicuadorasProyect.velocidades2 + "\n" + "\n");
		
		txtS.append("Modelo: " + LicuadorasProyect.modelo3 + "\n");
		txtS.append("Precio: " + LicuadorasProyect.precio3 + "\n");
		txtS.append("Potencia: " + LicuadorasProyect.potencia3 + "\n");
		txtS.append("Capacidad: " + LicuadorasProyect.capacidad3 + "\n");
		txtS.append("Velocidades: " + LicuadorasProyect.velocidades3 + "\n" + "\n");
		
		txtS.append("Modelo: " + LicuadorasProyect.modelo4 + "\n");
		txtS.append("Precio: " + LicuadorasProyect.precio4 + "\n");
		txtS.append("Potencia: " + LicuadorasProyect.potencia4 + "\n");
		txtS.append("Capacidad: " + LicuadorasProyect.capacidad4 + "\n");
		txtS.append("Velocidades: " + LicuadorasProyect.velocidades4 + "\n" + "\n");
	}
	
}
