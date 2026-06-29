import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tarea2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtPre;
    private JTextField txtAn;
    private JTextField txtAl;
    private JTextField txtFon;
    private JTextField txtQue;

    // Sin "final" para poder modificarlos con btnGrabar
    private static String[] precios    = {"900", "750", "550", "400", "680"};
    private static String[] altos      = {"85 cm", "80 cm", "85 cm", "75 cm", "80 cm"};
    private static String[] anchos     = {"60 cm", "58 cm", "55 cm", "50 cm", "58 cm"};
    private static String[] fondos     = {"55 cm", "52 cm", "50 cm", "45 cm", "55 cm"};
    private static String[] quemadores = {
        "4 quemadores a gas", "4 quemadores a gas",
        "4 quemadores a gas", "4 quemadores eléctricos",
        "4 quemadores a gas"
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Tarea2 frame = new Tarea2();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Tarea2() {
        setTitle("Modificar Cocina");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 437, 318);

        contentPane = new PanelFondo();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblModelo.setBounds(10, 21, 88, 14);
        contentPane.add(lblModelo);

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPrecio.setBounds(10, 55, 88, 14);
        contentPane.add(lblPrecio);

        JLabel lblAncho = new JLabel("Ancho");
        lblAncho.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAncho.setBounds(10, 97, 88, 14);
        contentPane.add(lblAncho);

        JLabel lblAlto = new JLabel("Alto");
        lblAlto.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAlto.setBounds(10, 144, 88, 14);
        contentPane.add(lblAlto);

        JLabel lblFondo = new JLabel("Fondo");
        lblFondo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblFondo.setBounds(10, 195, 88, 14);
        contentPane.add(lblFondo);

        JLabel lblQuemadores = new JLabel("Quemadores");
        lblQuemadores.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuemadores.setBounds(10, 236, 100, 14);
        contentPane.add(lblQuemadores);

        JComboBox<String> cboMo = new JComboBox<>();
        cboMo.setModel(new DefaultComboBoxModel<>(new String[]{
            "Mabe Anafe Gas 4 Quemadores AC4GMI",
            "Indurama MCI-5141NG",
            "Electrolux E24G1L2CGPS0",
            "Oster OG24BEEA752",
            "Mademsa Gourmet 5200G"
        }));
        cboMo.setBounds(108, 17, 133, 22);
        cboMo.addActionListener(e -> cargarDatos(cboMo.getSelectedIndex()));
        contentPane.add(cboMo);

        txtPre = new JTextField();
        txtPre.setBounds(107, 52, 134, 20);
        contentPane.add(txtPre);

        txtAn = new JTextField();
        txtAn.setBounds(108, 96, 133, 20);
        contentPane.add(txtAn);

        txtAl = new JTextField();
        txtAl.setBounds(108, 143, 133, 20);
        contentPane.add(txtAl);

        txtFon = new JTextField();
        txtFon.setBounds(109, 194, 132, 20);
        contentPane.add(txtFon);

        txtQue = new JTextField();
        txtQue.setBounds(108, 235, 133, 20);
        contentPane.add(txtQue);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(317, 35, 89, 23);
        btnCerrar.addActionListener(e -> dispose());
        contentPane.add(btnCerrar); // ← faltaba

        JButton btnGrabar = new JButton("Grabar");
        btnGrabar.setBounds(317, 95, 89, 23);
        btnGrabar.addActionListener(e -> {
            int index = cboMo.getSelectedIndex();
            precios[index]    = txtPre.getText();
            anchos[index]     = txtAn.getText();
            altos[index]      = txtAl.getText();
            fondos[index]     = txtFon.getText();
            quemadores[index] = txtQue.getText();
            JOptionPane.showMessageDialog(this,
                "Datos guardados correctamente.",
                "Modificar cocina",
                JOptionPane.INFORMATION_MESSAGE);
        });
        contentPane.add(btnGrabar);

        cargarDatos(0); // carga el primer modelo al abrir
    }

    private void cargarDatos(int index) {
        txtPre.setText(precios[index]);
        txtAn.setText(anchos[index]);
        txtAl.setText(altos[index]);
        txtFon.setText(fondos[index]);
        txtQue.setText(quemadores[index]);
    }
}