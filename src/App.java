// Importing the necessary libraries to run the program.
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * It creates a window with a combo box and two buttons.
 */
public class App extends JFrame {

    public static void main(String[] args) throws Exception {

       // Creating an array of the enum values.
        UnitsList[] units = UnitsList.values();
        MoneyList[] money = MoneyList.values();
        String[] moneyName = new String[money.length];
        String[] unit = new String[units.length];

       // Creating an array of the enum values.
        for (int i = 0; i < money.length; i++) {
            moneyName[i] = money[i].getName();
        }
        for (int i = 0; i < units.length; i++) {
            unit[i] = units[i].getName();
        }

        // Creating the GUI.
        JFrame ventanaPrincipal = new JFrame();
        JPanel principalPanel = new JPanel();
        JPanel selectionPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        JButton buttonSeleccionar = new JButton("Seleccionar");
        JButton buttonCancelar = new JButton("Cancelar");
        JComboBox<String> comboBox = new JComboBox<String>(
                new String[] { "Convertidor de temperatura", "Convertidor de monedas" });

        // Setting the size of the panel and adding the label and combo box to the panel.
        selectionPanel.setPreferredSize(new Dimension(300, 60));
        selectionPanel.add(new JLabel("Seleccione un convertidor"));
        selectionPanel.add(comboBox);
        buttonsPanel.add(buttonSeleccionar);
        buttonsPanel.add(buttonCancelar);

        // Setting the layout of the panel, the size of the panel, and adding the selection panel and
        // buttons panel to the principal panel.
        principalPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 0));
        principalPanel.setPreferredSize(new Dimension(350, 110));
        principalPanel.add(selectionPanel);
        principalPanel.add(buttonsPanel);

        ventanaPrincipal.add(principalPanel);

       // This is setting the title of the window, the default close operation, the size of the window,
       // the location of the window, if the window is resizable, and if the window is visible.
        ventanaPrincipal.setTitle("Menu Inicio");
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(350, 140);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setVisible(true);

        // Creating an action listener for the button.
        buttonSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = (String) comboBox.getSelectedItem();
                if (opcionSeleccionada.equals("Convertidor de temperatura")) {
                    Converter convertidorDeTemperatura = new Converter(ventanaPrincipal,
                            "Convertidor de temperatura", "Convertidor de temperatura", unit, unit);
                    convertidorDeTemperatura.setVisible(true);
                } else if (opcionSeleccionada.equals("Convertidor de monedas")) {
                    Converter moneyConverter = new Converter(ventanaPrincipal, "Convertidor de monedas",
                            "Ingrese monto a convertir", moneyName, moneyName);
                    moneyConverter.setVisible(true);

                }
                ventanaPrincipal.setVisible(false);
            }
        });

      // Closing the window.
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();
            }
        });
    }
}
