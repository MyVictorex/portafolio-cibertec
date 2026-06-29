import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class tarea4 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try { new tarea4().setVisible(true); }
            catch (Exception e) { e.printStackTrace(); }
        });
    }

    public tarea4() {
        setTitle("Generar Reportes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 457, 339);

        contentPane = new PanelFondo();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblTipo = new JLabel("Tipo de Reporte");
        lblTipo.setBounds(10, 11, 100, 14);
        contentPane.add(lblTipo);

        JComboBox<String> cboTipo = new JComboBox<>();
        cboTipo.setModel(new DefaultComboBoxModel<>(new String[]{
            "Ventas por modelo",
            "Ventas en relación a la venta óptima",
            "Precios en relación al precio promedio",
            "Promedios, menores y mayores"
        }));
        cboTipo.setBounds(122, 7, 271, 22);
        contentPane.add(cboTipo);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(10, 42, 414, 208);
        contentPane.add(scroll);

        JButton btnGenerar = new JButton("Generar");
        btnGenerar.setBounds(50, 266, 89, 23);
        btnGenerar.addActionListener(e -> mostrarReporte(cboTipo.getSelectedIndex()));
        contentPane.add(btnGenerar);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(280, 266, 89, 23);
        btnCerrar.addActionListener(e -> dispose());
        contentPane.add(btnCerrar);
    }

    private void mostrarReporte(int tipo) {
        textArea.setText("");

        switch (tipo) {

            case 0:
                textArea.append("=== VENTAS POR MODELO ===\n\n");
                textArea.append("Mabe Anafe Gas 4 Quemadores   | 12 unidades | S/ 10,800.00\n");
                textArea.append("Indurama MCI-5141NG            |  8 unidades | S/  6,000.00\n");
                textArea.append("Electrolux E24G1L2CGPS0        | 15 unidades | S/  8,250.00\n");
                textArea.append("Oster OG24BEEA752              |  5 unidades | S/  2,000.00\n");
                textArea.append("Mademsa Gourmet 5200G          | 10 unidades | S/  6,800.00\n");
                textArea.append("\nTotal general: S/ 33,850.00\n");
                break;

            case 1:
                textArea.append("=== VENTAS VS VENTA ÓPTIMA (10 unidades) ===\n\n");
                textArea.append("Mabe Anafe Gas 4 Quemadores   | 12 uds | ✔ Superó la meta\n");
                textArea.append("Indurama MCI-5141NG            |  8 uds | ✘ No alcanzó la meta\n");
                textArea.append("Electrolux E24G1L2CGPS0        | 15 uds | ✔ Superó la meta\n");
                textArea.append("Oster OG24BEEA752              |  5 uds | ✘ No alcanzó la meta\n");
                textArea.append("Mademsa Gourmet 5200G          | 10 uds | ✔ Alcanzó la meta\n");
                break;

            case 2:
                textArea.append("=== PRECIOS VS PRECIO PROMEDIO ===\n\n");
                textArea.append("Precio promedio: S/ 676.00\n\n");
                textArea.append("Mabe Anafe Gas 4 Quemadores   | S/ 900.00 | ↑ Sobre el promedio\n");
                textArea.append("Indurama MCI-5141NG            | S/ 750.00 | ↑ Sobre el promedio\n");
                textArea.append("Electrolux E24G1L2CGPS0        | S/ 550.00 | ↓ Bajo el promedio\n");
                textArea.append("Oster OG24BEEA752              | S/ 400.00 | ↓ Bajo el promedio\n");
                textArea.append("Mademsa Gourmet 5200G          | S/ 680.00 | ↑ Sobre el promedio\n");
                break;

            case 3:
                textArea.append("=== PROMEDIOS, MENORES Y MAYORES ===\n\n");
                textArea.append("Total ventas registradas : 50 unidades\n");
                textArea.append("Total recaudado          : S/ 33,850.00\n");
                textArea.append("Promedio por modelo      : S/ 6,770.00\n\n");
                textArea.append("Mayor venta : Mabe Anafe Gas 4 Quemadores\n");
                textArea.append("              12 unidades | S/ 10,800.00\n\n");
                textArea.append("Menor venta : Oster OG24BEEA752\n");
                textArea.append("              5 unidades  | S/  2,000.00\n");
                break;
        }
    }
}