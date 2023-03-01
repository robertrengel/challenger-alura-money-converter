import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        // Crea un JFrame
        JFrame frame = new JFrame("Ejemplo Botón con JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crea un JPanel con FlowLayout centrado
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        panel.setPreferredSize(new Dimension(300, 100)); // Establece el tamaño del JPanel

        // Crea los componentes
        JLabel label = new JLabel("Selecciona una opción:");
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Opción 1", "Opción 2", "Opción 3"});
        JButton button = new JButton("Mostrar opciones");

        // Agrega los componentes al JPanel
        panel.add(label);
        panel.add(comboBox);
        panel.add(button);

        // Agrega el JPanel al JFrame
        frame.getContentPane().add(panel);
        

        // Configura la acción del botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene la opción seleccionada en el JComboBox
                String opcionSeleccionada = (String) comboBox.getSelectedItem();

                // Crea un nuevo JFrame
                JFrame opcionesFrame = new JFrame("Opciones para " + opcionSeleccionada);
                opcionesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Crea un JPanel con FlowLayout centrado
                JPanel opcionesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
                opcionesPanel.setPreferredSize(new Dimension(300, 100)); // Establece el tamaño del JPanel

                // Configura los componentes de la siguiente ventana según la opción seleccionada
                if (opcionSeleccionada.equals("Opción 1")) {
                    // Configura los componentes para la opción 1
                    JLabel opcionesLabel = new JLabel("Seleccionaste la opción 1");
                    opcionesPanel.add(opcionesLabel);
                } else if (opcionSeleccionada.equals("Opción 2")) {
                    // Configura los componentes para la opción 2
                    JLabel opcionesLabel = new JLabel("Seleccionaste la opción 2");
                    opcionesPanel.add(opcionesLabel);
                } else if (opcionSeleccionada.equals("Opción 3")) {
                    // Configura los componentes para la opción 3
                    JLabel opcionesLabel = new JLabel("Seleccionaste la opción 3");
                    opcionesPanel.add(opcionesLabel);
                }

                // Agrega el JPanel al JFrame de la siguiente ventana
                opcionesFrame.getContentPane().add(opcionesPanel);

                // Ajusta el tamaño del JFrame y lo muestra
                opcionesFrame.pack();
                opcionesFrame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                opcionesFrame.setVisible(true);
            }
        });

        // Ajusta el tamaño del JFrame y lo muestra
        frame.pack();
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        frame.setVisible(true);
    }
}
