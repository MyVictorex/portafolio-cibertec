import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tarea3 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtPre;
    private JTextField txtCa;
    private JTextArea textArea;

    // Datos de los modelos
    private static final String[] modelos = {
        "Mabe Anafe Gas 4 Quemadores AC4GMI",
        "Indurama MCI-5141NG",
        "Electrolux E24G1L2CGPS0",
        "Oster OG24BEEA752",
        "Mademsa Gourmet 5200G"
    };
    private static final double[] preciosBase = {900.0, 750.0, 550.0, 400.0, 680.0};

    // Registro de ventas compartido con tarea4
    public static final String[] modelosVendidos   = new String[100];
    public static final int[]    cantidadesVendidas = new int[100];
    public static final double[] totalesVendidos    = new double[100];
    public static int totalVentas = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try { new tarea3().setVisible(true); }
            catch (Exception e) { e.printStackTrace(); }
        });
    }

    public tarea3() {
        setTitle("Vender");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 460, 347);

        contentPane = new PanelFondo();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblModelo.setBounds(10, 23, 82, 14);
        contentPane.add(lblModelo);

        JLabel lblPrecio = new JLabel("Precio (S/)");
        lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPrecio.setBounds(10, 65, 90, 14);
        contentPane.add(lblPrecio);

        JLabel lblCantidad = new JLabel("Cantidad");
        lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCantidad.setBounds(10, 102, 82, 14);
        contentPane.add(lblCantidad);

        JComboBox<String> cboMo = new JComboBox<>();
        cboMo.setModel(new DefaultComboBoxModel<>(modelos));
        cboMo.setBounds(102, 19, 200, 22);
        cboMo.addActionListener(e -> {
            int i = cboMo.getSelectedIndex();
            txtPre.setText(String.valueOf(preciosBase[i]));
        });
        contentPane.add(cboMo);

        txtPre = new JTextField();
        txtPre.setEditable(false); // el precio lo pone el sistema
        txtPre.setBounds(102, 62, 150, 20);
        contentPane.add(txtPre);

        txtCa = new JTextField();
        txtCa.setBounds(102, 99, 150, 20);
        contentPane.add(txtCa);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(10, 127, 424, 170);
        contentPane.add(textArea);

        JButton btnVen = new JButton("Vender");
        btnVen.setBounds(320, 34, 89, 23);
        btnVen.addActionListener(e -> realizarVenta(cboMo));
        contentPane.add(btnVen);

        JButton btnCerr = new JButton("Cerrar");
        btnCerr.setBounds(320, 79, 89, 23);
        btnCerr.addActionListener(e -> dispose());
        contentPane.add(btnCerr);

        // Carga el precio del primer modelo al abrir
        txtPre.setText(String.valueOf(preciosBase[0]));
    }

    private void realizarVenta(JComboBox<String> cboMo) {
        // Validar cantidad
        String cantTexto = txtCa.getText().trim();
        if (cantTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor ingrese una cantidad.",
                "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(cantTexto);
            if (cantidad <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "La cantidad debe ser un número entero positivo.",
                "Cantidad inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int index       = cboMo.getSelectedIndex();
        String modelo   = modelos[index];
        double precio   = preciosBase[index];
        double subtotal = precio * cantidad;

        // Descuentos fijos según cantidad
        double porcDescuento;
        if      (cantidad <= 5)  porcDescuento = 0.00;
        else if (cantidad <= 10) porcDescuento = 0.05;
        else if (cantidad <= 15) porcDescuento = 0.10;
        else                     porcDescuento = 0.15;

        double descuento = subtotal * porcDescuento;
        double total     = subtotal - descuento;

        // Guardar en registro compartido con tarea4
        if (totalVentas < 100) {
            modelosVendidos[totalVentas]   = modelo;
            cantidadesVendidas[totalVentas] = cantidad;
            totalesVendidos[totalVentas]    = total;
            totalVentas++;
        }

        // Mostrar resumen en el textArea
        textArea.append("=== Venta registrada ===\n");
        textArea.append("Modelo   : " + modelo + "\n");
        textArea.append("Precio   : S/ " + precio + "\n");
        textArea.append("Cantidad : " + cantidad + "\n");
        textArea.append("Subtotal : S/ " + String.format("%.2f", subtotal) + "\n");
        textArea.append("Descuento: " + (int)(porcDescuento * 100) + "% = S/ "
                        + String.format("%.2f", descuento) + "\n");
        textArea.append("TOTAL    : S/ " + String.format("%.2f", total) + "\n\n");

        txtCa.setText(""); // limpia cantidad para la siguiente venta
    }
}