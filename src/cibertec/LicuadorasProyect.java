package cibertec;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LicuadorasProyect extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar mnLicuadoras;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultarLicuadora;
	private JMenuItem mntmModificarLicuadora;
	private JMenuItem mntmListarLicuadora;

	// Datos mínimos de la primera licuadora
	public static String modelo0 = "Oster";
	public static double precio0 = 369.0;
	public static double potencia0 = 700.0;
	public static double capacidad0 = 1.25;
	public static int velocidades0 = 3;

	// Datos mínimos de la segunda licuadora
	public static String modelo1 = "Ninja";
	public static double precio1 = 549.0;
	public static double potencia1 = 1200.0;
	public static double capacidad1 = 2.1;
	public static int velocidades1 = 3;

	// Datos mínimos de la tercera licuadora
	public static String modelo2 = "Kitchenaid";
	public static double precio2 = 480.0;
	public static double potencia2 = 1700.0;
	public static double capacidad2 = 2.0;
	public static int velocidades2 = 3;

	// Datos mínimos de la cuarta licuadora
	public static String modelo3 = "Wurden";
	public static double precio3 = 235.0;
	public static double potencia3 = 700.0;
	public static double capacidad3 = 1.5;
	public static int velocidades3 = 3;

	// Datos mínimos de la quinta licuadora
	public static String modelo4 = "Electric Life";
	public static double precio4 = 260.0;
	public static double potencia4 = 500.0;
	public static double capacidad4 = 1.5;
	public static int velocidades4 = 3;
	
	//variables globales de porcentajes
	public static double porcentaje1 = 5.0;
	public static double porcentaje2 = 9.0;
	public static double porcentaje3 = 10.0;
	public static double porcentaje4 = 13.5;
	
	//variables globales de osbequios
	public static String obsequio1 = "TOSTADORA";
	public static String obsequio2 = "PLANCHA";
	public static String obsequio3 = "JUEGO DE PLATOS";
	
	
	
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenu mnAyuda;
	private JMenuItem mntmVender;
	private JMenuItem mntmConfDescuentos;
	private JMenuItem mntmConfObsequios;
	private JMenuItem mntmAcercaDeTienda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LicuadorasProyect frame = new LicuadorasProyect();
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
	public LicuadorasProyect() {
		setTitle("Tienda de Licuadoras 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		mnLicuadoras = new JMenuBar();
		setJMenuBar(mnLicuadoras);

		mnArchivo = new JMenu("Archivo");
		mnLicuadoras.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		mnLicuadoras.add(mnMantenimiento);

		mntmConsultarLicuadora = new JMenuItem("Consultar Licuadora");
		mntmConsultarLicuadora.addActionListener(this);
		mnMantenimiento.add(mntmConsultarLicuadora);

		mntmModificarLicuadora = new JMenuItem("Modificar Licuadora");
		mntmModificarLicuadora.addActionListener(this);
		mnMantenimiento.add(mntmModificarLicuadora);

		mntmListarLicuadora = new JMenuItem("Listar Licuadora");
		mntmListarLicuadora.addActionListener(this);
		mnMantenimiento.add(mntmListarLicuadora);
		
		mnVentas = new JMenu("Ventas");
		mnLicuadoras.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mnConfiguracion = new JMenu("Configuracion");
		mnLicuadoras.add(mnConfiguracion);
		
		mntmConfDescuentos = new JMenuItem("Configurar Descuentos");
		mntmConfDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmConfDescuentos);
		
		mntmConfObsequios = new JMenuItem("Configurar Obsequios");
		mntmConfObsequios.addActionListener(this);
		mnConfiguracion.add(mntmConfObsequios);
		
		mnAyuda = new JMenu("Ayuda");
		mnLicuadoras.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(e);
		}
		if (e.getSource() == mntmConfObsequios) {
			actionPerformedMntmConfObsequios(e);
		}
		if (e.getSource() == mntmConfDescuentos) {
			actionPerformedMntmConfDescuentos(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmListarLicuadora) {
			actionPerformedMntmListarLicuadora(e);
		}
		if (e.getSource() == mntmModificarLicuadora) {
			actionPerformedMntmModificarLicuadora(e);
		}
		if (e.getSource() == mntmConsultarLicuadora) {
			actionPerformedMntmConsultarLicuadora(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}

	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}

	protected void actionPerformedMntmConsultarLicuadora(ActionEvent e) {
		// Codigo para que se visualice el dialogo Consultar Licuadora
		ConsultarLicuadora cl = new ConsultarLicuadora();
		cl.setLocationRelativeTo(this);
		cl.setVisible(true);
	}

	protected void actionPerformedMntmModificarLicuadora(ActionEvent e) {
		// Codigo para que se visualice el dialogo Modificar Licuadora
		ModificarLicuadora ml = new ModificarLicuadora();
		ml.setLocationRelativeTo(this);
		ml.setVisible(true);
	}

	protected void actionPerformedMntmListarLicuadora(ActionEvent e) {
		// Codigo para que se visualice el dialogo Listar Licuadora
		ListarLicuadoras ll = new ListarLicuadoras();
		ll.setLocationRelativeTo(this);
		ll.setVisible(true);
	}
	
	protected void actionPerformedMntmVender(ActionEvent e) {
		// Codigo para que se visualice el dialogo Vender
		Vender v = new Vender();
		v.setLocationRelativeTo(this);
		v.setVisible(true);
	}
	
	protected void actionPerformedMntmConfDescuentos(ActionEvent e) {
		ConfigurarDescuentos cd = new ConfigurarDescuentos();
		cd.setLocationRelativeTo(this);
		cd.setVisible(true);
	}
	
	protected void actionPerformedMntmConfObsequios(ActionEvent e) {
		ConfigurarObsequios co = new ConfigurarObsequios();
		co.setLocationRelativeTo(this);
		co.setVisible(true);
	}
	
	protected void actionPerformedMntmAcercaDeTienda(ActionEvent e) {
		AcercaDeTienda adt = new AcercaDeTienda();
		adt.setLocationRelativeTo(this);
		adt.setVisible(true);
	}
}
