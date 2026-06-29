import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class tarea5 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField txt2;
    private JTextField txt3;
    private JTextField txt4;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try { new tarea5().setVisible(true); }
            catch (Exception e) { e.printStackTrace(); }
        });
    }

    public tarea5() {
        setTitle("Configurar porcentajes de descuento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new PanelFondo();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lbl1 = new JLabel("1 a 5 unidades");
        lbl1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl1.setBounds(10, 26, 130, 14);
        contentPane.add(lbl1);

        JLabel lbl2 = new JLabel("6 a 10 unidades");
        lbl2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl2.setBounds(10, 75, 130, 14);
        contentPane.add(lbl2);

        JLabel lbl3 = new JLabel("11 a 15 unidades");
        lbl3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl3.setBounds(10, 135, 132, 14);
        contentPane.add(lbl3);

        JLabel lbl4 = new JLabel("Más de 15 unidades");
        lbl4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl4.setBounds(10, 195, 142, 14);
        contentPane.add(lbl4);

        textField = new JTextField("0");
        textField.setBounds(152, 23, 103, 20);
        contentPane.add(textField);

        txt2 = new JTextField("5");
        txt2.setBounds(152, 72, 103, 20);
        contentPane.add(txt2);

        txt3 = new JTextField("10");
        txt3.setBounds(152, 132, 103, 20);
        contentPane.add(txt3);

        txt4 = new JTextField("15");
        txt4.setBounds(152, 192, 103, 20);
        contentPane.add(txt4);

        // Etiquetas %
        for (int[] pos : new int[][]{{264,26},{264,75},{264,135},{264,195}}) {
            JLabel pct = new JLabel("%");
            pct.setBounds(pos[0], pos[1], 20, 14);
            contentPane.add(pct);
        }

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(335, 46, 89, 23);
        btnAceptar.addActionListener(e -> {
            try {
                Double.parseDouble(textField.getText());
                Double.parseDouble(txt2.getText());
                Double.parseDouble(txt3.getText());
                Double.parseDouble(txt4.getText());
                JOptionPane.showMessageDialog(this,
                    "Descuentos guardados correctamente.",
                    "Configurar descuentos",
                    JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Ingrese solo números en los campos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        contentPane.add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(335, 107, 89, 23);
        btnCancelar.addActionListener(e -> dispose());
        contentPane.add(btnCancelar);
    }
}