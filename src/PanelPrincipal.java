import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;

public class PanelPrincipal extends JPanel {
    public PanelPrincipal(int wigth,int height) {
        setPreferredSize(new Dimension(wigth, height));
        setLayout(new FlowLayout(FlowLayout.CENTER, 300, 0));
    }
}
