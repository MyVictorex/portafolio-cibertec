import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class tarea8 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtConfi;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try { new tarea8().setVisible(true); }
            catch (Exception e) { e.printStackTrace(); }
        });
    }

    public tarea8() {
        setTitle("Configurar cuota diaria");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 435, 157);

        contentPane = new PanelFondo();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Configurar cuota diaria esperada (S/)");
        lblNewLabel.setBounds(10, 24, 220, 14);
        contentPane.add(lblNewLabel);

        txtConfi = new JTextField("1000");
        txtConfi.setBounds(213, 21, 185, 20);
        contentPane.add(txtConfi);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(39, 67, 89, 23);
        btnAceptar.addActionListener(e -> {
            try {
                Double.parseDouble(txtConfi.getText());
                JOptionPane.showMessageDialog(this,
                    "Cuota diaria guardada correctamente.",
                    "Configurar cuota diaria",
                    JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Ingrese solo un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        contentPane.add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(261, 67, 89, 23);
        btnCancelar.addActionListener(e -> dispose());
        contentPane.add(btnCancelar);
    }
}