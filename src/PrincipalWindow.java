import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalWindow extends JFrame {

    public PrincipalWindow() {
        setTitle("Menu Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 140);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel principalPanel = new JPanel();
        JPanel selectionPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        JButton buttonSeleccionar = new JButton("Seleccionar");
        JButton buttonCancelar = new JButton("Cancelar");
        JComboBox<String> comboBox = new JComboBox<String>(
                new String[] { "Convertidor de temperatura", "Convertidor de monedas" });

        selectionPanel.setPreferredSize(new Dimension(300, 60));
        selectionPanel.add(new JLabel("Seleccione un convertidor"));
        selectionPanel.add(comboBox);
        buttonsPanel.add(buttonSeleccionar);
        buttonsPanel.add(buttonCancelar);

        principalPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 0));
        principalPanel.setPreferredSize(new Dimension(350, 110));
        principalPanel.add(selectionPanel);
        principalPanel.add(buttonsPanel);

        add(principalPanel);

        buttonSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = (String) comboBox.getSelectedItem();
                MoneyConverter moneyConverter = new MoneyConverter(PrincipalWindow.this);
                moneyConverter.setVisible(true);
                PrincipalWindow.this.setVisible(false);
            }
        });

        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrincipalWindow.this.dispose();
            }
        });

    }

}
