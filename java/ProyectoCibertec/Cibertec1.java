import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cibertec1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cibertec1 frame = new Cibertec1();
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
	public Cibertec1() {
	    setTitle("Tienda modelos de cocina");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 477, 449);

	    JMenuBar menuBar = new JMenuBar();
	    setJMenuBar(menuBar);

	    // --- Archivo ---
	    JMenu mnArchivo = new JMenu("Archivo");
	    menuBar.add(mnArchivo);

	    JMenuItem mnSalir = new JMenuItem("Salir");
	    mnSalir.addActionListener(e -> System.exit(0));
	    mnArchivo.add(mnSalir);

	    // --- Mantenimiento ---
	    JMenu mnMantenimiento = new JMenu("Mantenimiento");
	    menuBar.add(mnMantenimiento);

	    JMenuItem mnConsultar = new JMenuItem("Consultar cocina");
	    mnConsultar.addActionListener(e -> new Tarea1().setVisible(true));
	    mnMantenimiento.add(mnConsultar);

	    JMenuItem mnModificar = new JMenuItem("Modificar cocina");
	    mnModificar.addActionListener(e -> new Tarea2().setVisible(true));
	    mnMantenimiento.add(mnModificar);

	    JMenuItem mnListar = new JMenuItem("Listar cocinas");
	    mnListar.addActionListener(e -> new Proyectar().setVisible(true));
	    mnMantenimiento.add(mnListar);

	    // --- Ventas ---
	    JMenu mnVentas = new JMenu("Ventas");
	    menuBar.add(mnVentas);

	    JMenuItem mnVender = new JMenuItem("Vender");
	    mnVender.addActionListener(e -> new tarea3().setVisible(true));
	    mnVentas.add(mnVender);

	    JMenuItem mnReportes = new JMenuItem("Generar reportes");
	    mnReportes.addActionListener(e -> new tarea4().setVisible(true));
	    mnVentas.add(mnReportes);

	    // --- Configuracion ---
	    JMenu mnConfiguracion = new JMenu("Configuracion");
	    menuBar.add(mnConfiguracion);

	    JMenuItem mnDescuentos = new JMenuItem("Configurar descuentos");
	    mnDescuentos.addActionListener(e -> new tarea5().setVisible(true));
	    mnConfiguracion.add(mnDescuentos);

	    JMenuItem mnObsequios = new JMenuItem("Configurar obsequios");
	    mnObsequios.addActionListener(e -> new tarea6().setVisible(true));
	    mnConfiguracion.add(mnObsequios);

	    JMenuItem mnCantidad = new JMenuItem("Configurar cantidad óptima");
	    mnCantidad.addActionListener(e -> new tarea7().setVisible(true));
	    mnConfiguracion.add(mnCantidad);

	    JMenuItem mnCuota = new JMenuItem("Configurar cuota diaria");
	    mnCuota.addActionListener(e -> new tarea8().setVisible(true));
	    mnConfiguracion.add(mnCuota);

	    // --- Ayuda ---
	    JMenu mnAyuda = new JMenu("Ayuda");
	    menuBar.add(mnAyuda);

	    JMenuItem mnAcerca = new JMenuItem("Acerca de la tienda");
	    mnAcerca.addActionListener(e -> new Prensentacion().setVisible(true));
	    mnAyuda.add(mnAcerca);

	    // Panel con fondo
	    contentPane = new PanelFondo();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	}
}
