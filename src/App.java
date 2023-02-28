import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App extends JFrame {
    
    public static void main(String[] args) throws Exception {
        
        UnitsList[] units = UnitsList.values();
        MoneyList[] money = MoneyList.values();
        String[] unit = { units[0].getName(), units[1].getName(), units[2].getName() };
        String[] moneyName = { money[0].getName(), money[1].getName(), money[2].getName(), money[3].getName(), money[4].getName()};

        JFrame ventanaPrincipal = new JFrame();
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

        ventanaPrincipal.add(principalPanel);

        ventanaPrincipal.setTitle("Menu Inicio");
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(350, 140);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setVisible(true);

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

        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();
            }
        });

        
         
    }

  

}


