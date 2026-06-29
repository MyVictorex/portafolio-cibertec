import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tarea1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtPre;
    private JTextField txtAn;
    private JTextField txtAl;
    private JTextField txtFon;
    private JTextField txtQue;

    private static final String[] precios    = {"900.0", "750.0", "550.0", "400.0", "680.0"};
    private static final String[] altos      = {"85 cm", "80 cm", "85 cm", "75 cm", "80 cm"};
    private static final String[] anchos     = {"60 cm", "58 cm", "55 cm", "50 cm", "58 cm"};
    private static final String[] fondos     = {"55 cm", "52 cm", "50 cm", "45 cm", "55 cm"};
    private static final String[] quemadores = {
        "4 quemadores a gas", "4 quemadores a gas",
        "4 quemadores a gas", "4 quemadores eléctricos",
        "4 quemadores a gas"
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Tarea1 frame = new Tarea1();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Tarea1() {
        setTitle("Consultar cocina");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ← no cierra toda la app
        setBounds(100, 100, 450, 300);

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
        txtPre.setEditable(false); // consulta, no se edita
        txtPre.setBounds(107, 52, 134, 20);
        contentPane.add(txtPre);

        txtAn = new JTextField();
        txtAn.setEditable(false);
        txtAn.setBounds(108, 96, 133, 20);
        contentPane.add(txtAn);

        txtAl = new JTextField();
        txtAl.setEditable(false);
        txtAl.setBounds(108, 143, 133, 20);
        contentPane.add(txtAl);

        txtFon = new JTextField();
        txtFon.setEditable(false);
        txtFon.setBounds(109, 194, 132, 20);
        contentPane.add(txtFon);

        txtQue = new JTextField();
        txtQue.setEditable(false);
        txtQue.setBounds(108, 235, 133, 20);
        contentPane.add(txtQue);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(317, 35, 89, 23);
        btnCerrar.addActionListener(e -> dispose());
        contentPane.add(btnCerrar); // ← faltaba esta línea

        cargarDatos(0); // carga el primer modelo al abrir
    }

    private void cargarDatos(int index) {
        txtPre.setText(precios[index]);
        txtAl.setText(altos[index]);
        txtAn.setText(anchos[index]);
        txtFon.setText(fondos[index]);
        txtQue.setText(quemadores[index]);
    }
}