import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;

public class PanelFondo extends JPanel {
    
    public PanelFondo() {
        setLayout(null);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Fondo.png"));
        g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}