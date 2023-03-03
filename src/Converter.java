// It's importing the classes that are going to be used in the class.
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Converter extends JFrame {
    String regex = "\\d+(\\.\\d+)?";
    double textoNumero;
    MoneyList[] money = MoneyList.values();

    public Converter(JFrame ventanaPrincipal, String title, String labelTitle, String[] listValuesComboBox,
            String[] listValuesComboBox2) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 480);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // Creating the components of the window.
        JLabel label = new JLabel(labelTitle);
        JLabel converterDe = new JLabel("Convertir de:");
        JLabel converterTo = new JLabel("Convertir a:");
        JPanel principalPanel = new JPanel();
        JPanel labelPanel = new JPanel();
        JPanel labelConverterDe = new JPanel();
        JPanel labelConverterTo = new JPanel();
        JPanel comboBoxPanel1 = new JPanel();
        JPanel comboBoxPanel2 = new JPanel();
        JPanel textFieldPanel = new JPanel();
        JPanel converterButtonPanel = new JPanel();
        JPanel cancelButtonPanel = new JPanel();
        JPanel resultPanel = new JPanel();
        JTextField textField = new JTextField();
        JTextField resultTextField = new JTextField();
        JComboBox<String> comboBox = new JComboBox<String>(listValuesComboBox);
        JComboBox<String> comboBox2 = new JComboBox<String>(listValuesComboBox2);
        JButton buttonConvertir = new JButton("Convertir");
        JButton buttonCancelar = new JButton("Cancelar");
        DecimalFormat df = new DecimalFormat("#.###");
        Temperature temp = new Temperature();
        Api call_api = new Api();

        // Setting the rounding mode to ceiling.
        df.setRoundingMode(RoundingMode.CEILING);

        // Setting the alignment of the label to the left, setting the font of the text field to 20,
        // setting the result text field to not editable and setting the text field to 0.
        label.setHorizontalAlignment(JLabel.LEFT);
        textField.setFont(getFont().deriveFont(20.0f));
        resultTextField.setEditable(false);
        textField.setText("0");

        // Setting the font size of the components.
        comboBox.setFont(getFont().deriveFont(20.0f));
        comboBox2.setFont(getFont().deriveFont(20.0f));
        buttonConvertir.setFont(getFont().deriveFont(20.0f));
        resultTextField.setFont(getFont().deriveFont(20.0f));

        // Setting the size of the panel, the layout and adding the button to the panel.
        cancelButtonPanel.setPreferredSize(new Dimension(300, 40));
        cancelButtonPanel.setLayout(new BorderLayout());
        cancelButtonPanel.add(buttonCancelar, BorderLayout.EAST);

        // Setting the layout of the result panel to BorderLayout, setting the preferred size of the
        // result panel to 300x40 and adding the result text field to the center of the result panel.
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setPreferredSize(new Dimension(300, 40));
        resultPanel.add(resultTextField, BorderLayout.CENTER);

        // Setting the size of the panel, the layout and adding the button to the panel.
        labelPanel.setPreferredSize(new Dimension(300, 30));
        labelPanel.setLayout(new BorderLayout());
        labelPanel.add(label, BorderLayout.WEST);
        labelConverterDe.setPreferredSize(new Dimension(300, 30));
        labelConverterDe.setLayout(new BorderLayout());
        labelConverterDe.add(converterDe, BorderLayout.WEST);
        labelConverterTo.setPreferredSize(new Dimension(300, 30));
        labelConverterTo.setLayout(new BorderLayout());
        labelConverterTo.add(converterTo, BorderLayout.WEST);

        // Setting the size of the panel, the layout and adding the button to the panel.
        comboBoxPanel1.setPreferredSize(new Dimension(300, 40));
        comboBoxPanel1.setLayout(new BorderLayout());
        comboBoxPanel1.add(comboBox);
        comboBoxPanel2.setPreferredSize(new Dimension(300, 40));
        comboBoxPanel2.setLayout(new BorderLayout());
        comboBoxPanel2.add(comboBox2);

        // Setting the size of the panel, the layout and adding the button to the panel.
        textFieldPanel.setPreferredSize(new Dimension(300, 40));
        textFieldPanel.setLayout(new BorderLayout());
        textFieldPanel.add(textField, BorderLayout.CENTER);

        // Setting the size of the panel, the layout and adding the button to the panel.
        converterButtonPanel.setPreferredSize(new Dimension(300, 40));
        converterButtonPanel.setLayout(new BorderLayout());
        converterButtonPanel.add(buttonConvertir, BorderLayout.CENTER);

        // Adding the components to the panel.
        principalPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        principalPanel.setPreferredSize(new Dimension(350, 100));
        principalPanel.add(labelPanel);
        principalPanel.add(textFieldPanel);
        principalPanel.add(new Espacio());
        principalPanel.add(labelConverterDe);
        principalPanel.add(comboBoxPanel1);
        principalPanel.add(new Espacio());
        principalPanel.add(labelConverterTo);
        principalPanel.add(comboBoxPanel2);
        principalPanel.add(new Espacio());
        principalPanel.add(resultPanel);
        principalPanel.add(new Espacio());
        principalPanel.add(converterButtonPanel);
        principalPanel.add(new Espacio());
        principalPanel.add(cancelButtonPanel);

        // Adding the principalPanel to the JFrame.
        add(principalPanel);

        // The action listener of the button.
        buttonConvertir.addActionListener(new ActionListener() {
            @Override
            // The action listener of the button.
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = (String) comboBox.getSelectedItem();
                String opcionSeleccionada2 = (String) comboBox2.getSelectedItem();
                int indexOpcionSeleccionada = comboBox.getSelectedIndex();
                int indexOpcionSeleccionada2 = comboBox2.getSelectedIndex();
                String texto = textField.getText();
                System.out.println(title);
                
                if (texto.matches(regex)) {
                    textoNumero = Double.parseDouble(texto.replace(",", ""));

                    // Checking if the title of the window is "Convertidor de temperatura" and if it
                    // is, it is calling the method setCalculateTemperature from the class Temperature.
                    if (title.equals("Convertidor de temperatura")) {
                        temp.setCalculateTemperature(textoNumero, opcionSeleccionada, opcionSeleccionada2);
                        double resultadoNumero = (temp.getInputResolved());
                        String resultado = "" + df.format(resultadoNumero);
                        resultTextField.setText(resultado);
                        temp.setInputResolved(0.0);
                    }

                    // Calling the method setConverter_de from the class Api and setting the value of
                    // the variable converter_de to the value of the variable reference from the class
                    // MoneyList.
                    else if (title.equals("Convertidor de monedas")) {
                        call_api.setConverter_de(money[indexOpcionSeleccionada].getReference());
                        call_api.setConverter_a(money[indexOpcionSeleccionada2].getReference());
                        call_api.CallApi(Converter.this);
                        double resulDivisa = call_api.getDivisa_value() * textoNumero;
                        String resultadoDivisa = "" + df.format(resulDivisa);
                        resultTextField.setText(resultadoDivisa);

                    }

                // Creating a new window with the title "Error" and the message "El valor ingresado no
                // es un número válido" and setting it to visible.
                } else {
                    ErrorWindow errorWindow = new ErrorWindow(Converter.this,"Error", "El valor ingresado no es un número válido");
                    errorWindow.setVisible(true);
                }

            }
        });

        // Closing the current window and opening the previous window.
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Converter.this.dispose();
                ventanaPrincipal.setVisible(true);
            }
        });
    }
}