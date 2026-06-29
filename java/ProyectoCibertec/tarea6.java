import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class tarea6 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txt1;
    private JTextField txt2;
    private JTextField txt3;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try { new tarea6().setVisible(true); }
            catch (Exception e) { e.printStackTrace(); }
        });
    }

    public tarea6() {
        setTitle("Configurar Obsequios");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 448, 169);

        contentPane = new PanelFondo();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lbl1 = new JLabel("1 unidad");
        lbl1.setBounds(10, 11, 106, 14);
        contentPane.add(lbl1);

        JLabel lbl2 = new JLabel("2 a más unidades");
        lbl2.setBounds(10, 52, 106, 14);
        contentPane.add(lbl2);

        JLabel lbl3 = new JLabel("6 a más unidades");
        lbl3.setBounds(10, 91, 106, 14);
        contentPane.add(lbl3);

        txt1 = new JTextField("Ninguno");
        txt1.setBounds(126, 8, 120, 20);
        contentPane.add(txt1);

        txt2 = new JTextField("Instalación gratis");
        txt2.setBounds(126, 49, 120, 20);
        contentPane.add(txt2);

        txt3 = new JTextField("Kit de limpieza");
        txt3.setBounds(126, 88, 120, 20);
        contentPane.add(txt3);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(319, 23, 89, 23);
        btnAceptar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Obsequios guardados correctamente.",
                "Configurar obsequios",
                JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });
        contentPane.add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(319, 69, 89, 23);
        btnCancelar.addActionListener(e -> dispose());
        contentPane.add(btnCancelar);
    }
}