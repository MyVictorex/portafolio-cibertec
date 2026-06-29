import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class tarea7 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try { new tarea7().setVisible(true); }
            catch (Exception e) { e.printStackTrace(); }
        });
    }

    public tarea7() {
        setTitle("Configurar cantidad óptima");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 447, 118);

        contentPane = new PanelFondo();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lbl = new JLabel("Cantidad óptima de unidades vendidas");
        lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl.setBounds(0, 11, 283, 14);
        contentPane.add(lbl);

        textField = new JTextField("10");
        textField.setBounds(293, 8, 89, 20);
        contentPane.add(textField);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(51, 45, 89, 23);
        btnAceptar.addActionListener(e -> {
            try {
                Integer.parseInt(textField.getText());
                JOptionPane.showMessageDialog(this,
                    "Cantidad óptima guardada correctamente.",
                    "Configurar cantidad óptima",
                    JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Ingrese solo un número entero.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        contentPane.add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(256, 45, 89, 23);
        btnCancelar.addActionListener(e -> dispose());
        contentPane.add(btnCancelar);
    }
}