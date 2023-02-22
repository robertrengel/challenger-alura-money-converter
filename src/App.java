import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;
import java.awt.Dimension;

public class App {
    public static void main(String[] args) throws Exception {
        //List<String> list = Arrays.asList("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5");
        //String nombre = JOptionPane.showInputDialog(null, "Por favor, ingrese su nombre:");
        //JOptionPane.showInputDialog(null, args, nombre, 0);
        //JOptionPane.showInputDialog(null, list, "Lista de opciones", 0);
        //JOptionPane.showMessageDialog(null, "Hola, esto es un mensaje de prueba.");
        //JOptionPane.showOptionDialog(null, "Hola, esto es un mensaje de prueba.", "Mensaje de prueba", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        JFrame frame = new JFrame("Ejemplo JComboBox");
        JPanel panel = new JPanel();
        JLabel textField = new JLabel("Escoja una opcion");

        String[] opciones = {"Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        
        panel.setPreferredSize(new Dimension(400, 300));
        //frame.setSize(400, 300);
        panel.add(textField);
        panel.add(comboBox);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
