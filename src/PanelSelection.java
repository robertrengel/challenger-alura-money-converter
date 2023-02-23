import java.awt.*;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelSelection extends JPanel {

    private JComboBox<String> comboBox = new JComboBox<String>(
            new String[] { "Convertidor de temperatura", "Convertidor de monedas" });

    public PanelSelection() {
        setPreferredSize(new Dimension(300, 60));
        add(new JLabel("Seleccione un convertidor"));
        add(comboBox);
    }

    public JComboBox<String> getComboBox() {
        return this.comboBox;

    }

}