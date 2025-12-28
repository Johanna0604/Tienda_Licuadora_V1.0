package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcercaDeTienda extends JDialog implements ActionListener {
	private JLabel lblNombreProyecto;
	private JLabel lblAutores;
	private JLabel lblAutor1;
	private JLabel lblAutor2;
	private JLabel lblAutor3;
	private JLabel lblAutor4;
	private JLabel lblAutor5;
	private JButton btnCerrar;
	private JLabel lblAutor0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcercaDeTienda dialog = new AcercaDeTienda();
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
	public AcercaDeTienda() {
		setTitle("Acerca de Tienda Licuadoras");
		setBounds(100, 100, 450, 371);
		getContentPane().setLayout(null);
		
		lblNombreProyecto = new JLabel("Tienda de Licuadoras 1.0");
		lblNombreProyecto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombreProyecto.setBounds(95, 49, 276, 13);
		getContentPane().add(lblNombreProyecto);
		
		lblAutores = new JLabel("Autores");
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAutores.setBounds(176, 103, 114, 13);
		getContentPane().add(lblAutores);
		
		lblAutor1 = new JLabel("Derlyn Esteban Laurente Hilarion");
		lblAutor1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAutor1.setBounds(105, 153, 244, 13);
		getContentPane().add(lblAutor1);
		
		lblAutor2 = new JLabel("Johanna del Rocio Orellana Vargas");
		lblAutor2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAutor2.setBounds(95, 169, 258, 21);
		getContentPane().add(lblAutor2);
		
		lblAutor3 = new JLabel("Josue Benjam\u00EDn Monz\u00F3n Torres");
		lblAutor3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAutor3.setBounds(105, 191, 241, 21);
		getContentPane().add(lblAutor3);
		
		lblAutor4 = new JLabel("Juan Salvador Toni");
		lblAutor4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAutor4.setBounds(152, 217, 184, 13);
		getContentPane().add(lblAutor4);
		
		lblAutor5 = new JLabel("Marco Antonio Paucar");
		lblAutor5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAutor5.setBounds(139, 240, 166, 13);
		getContentPane().add(lblAutor5);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(176, 276, 91, 21);
		getContentPane().add(btnCerrar);
		
		lblAutor0 = new JLabel("Abel Yauri Dionisio");
		lblAutor0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAutor0.setBounds(147, 130, 158, 13);
		getContentPane().add(lblAutor0);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
