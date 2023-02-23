//import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelButtons extends JPanel {
    private JButton buttonSeleccionar = new JButton("Seleccionar");
    private JButton buttonCancelar = new JButton("Cancelar");

    public PanelButtons() {
        //setPreferredSize(new Dimension(300, 60));
        //setLayout(new FlowLayout(FlowLayout.CENTER, 300, 0));
        //add(new JLabel("Seleccione un convertidor"));
        //add(comboBox);
        add(buttonSeleccionar);
        add(buttonCancelar);
    }

    public JButton getButtonSeleccionar() {
        return this.buttonSeleccionar;
    }

    public JButton getButtonCancelar() {
        return this.buttonCancelar;
    }

}
