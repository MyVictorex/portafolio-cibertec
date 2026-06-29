import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

public class Proyectar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyectar frame = new Proyectar();
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
	public Proyectar() {
		setTitle("Listar Cocinas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        dispose(); // cierra solo esta ventana, no toda la app
		    }
		});
		btnCerrar.setBounds(39, 256, 89, 23);
		contentPane.add(btnCerrar);

		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(10, 10, 427, 240);
		contentPane.add(textArea_1);
		
		
		JButton btnListar = new JButton("Listar");
		contentPane.add(btnListar);
		
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        String[] nombresCocinas = {"Mabe Anafe Gas 4 Quemadores AC4GMI", "Indurama MCI-5141NG", "Electrolux E24G1L2CGPS0", "Oster OG24BEEA752", "Mademsa Gourmet 5200G"};
		        String[] precios = {"S/ 900.00", "S/ 750.00", "S/ 550.00", "S/ 400.00", "S/ 680.00"};
		        String[] alto= {"85 cm","80 cm","85 cm","75 cm","80 cm"};
		        String[] ancho= { "60 cm","58 cm","55 cm","50 cm","58 cm"};
		        String[] fondo= {"55 cm","52 cm","50 cm","45 cm","55 cm"};
		        String[] quemadores = {"4 quemadores a gas", "4 quemadores a gas", "4 quemadores a gas", "4 quemadores eléctricos", "4 quemadores a gas"};
	

		        textArea_1.setText("");
                
                for (int i = 0; i < nombresCocinas.length; i++) {
                	textArea_1.append("Modelo: " + nombresCocinas[i] + "\n");
                	textArea_1.append("Precio: " + precios[i] + "\n");
                	textArea_1.append("Alto: " + alto[i] + "\n");
                	textArea_1.append("Ancho: " + ancho[i] + "\n");
                	textArea_1.append("Fondo: " + fondo[i] + "\n");
                	textArea_1.append("Quemadores: " + quemadores[i] + "\n\n");
                }
		        
				
			}
		});
		btnListar.setBounds(309, 256, 89, 23);

	}
}
