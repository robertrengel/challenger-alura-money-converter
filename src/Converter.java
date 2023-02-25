import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Converter extends JFrame {

    public Converter(PrincipalWindow principalWindow, String title, String labelTitle, String[] listValuesComboBox,
            String[] listValuesComboBox2) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 440);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JLabel label = new JLabel(labelTitle);
        JPanel principalPanel = new JPanel();
        JPanel labelPanel = new JPanel();
        JPanel comboBoxPanel1 = new JPanel();
        JPanel comboBoxPanel2 = new JPanel();
        JPanel textFieldPanel = new JPanel();
        JPanel converterButtonPanel = new JPanel();
        JPanel cancelButtonPanel = new JPanel();
        JPanel resultPanel = new JPanel();
        JFormattedTextField textField = new JFormattedTextField(NumberFormat.getInstance(Locale.getDefault()));
        JTextField resultTextField = new JTextField();
        JComboBox<String> comboBox = new JComboBox<String>(listValuesComboBox);
        JComboBox<String> comboBox2 = new JComboBox<String>(listValuesComboBox2);
        JButton buttonConvertir = new JButton("Convertir");
        JButton buttonCancelar = new JButton("Cancelar");

        label.setHorizontalAlignment(JLabel.LEFT);
        textField.setFont(getFont().deriveFont(20.0f));
        resultTextField.setEditable(false);
        // textField.setValue(0.0);

        comboBox.setFont(getFont().deriveFont(20.0f));
        comboBox2.setFont(getFont().deriveFont(20.0f));
        buttonConvertir.setFont(getFont().deriveFont(20.0f));
        resultTextField.setFont(getFont().deriveFont(20.0f));

        cancelButtonPanel.setPreferredSize(new Dimension(300, 40));
        cancelButtonPanel.setLayout(new BorderLayout());
        cancelButtonPanel.add(buttonCancelar, BorderLayout.EAST);

        resultPanel.setLayout(new BorderLayout());
        resultPanel.setPreferredSize(new Dimension(300, 40));
        resultPanel.add(resultTextField, BorderLayout.CENTER);

        labelPanel.setPreferredSize(new Dimension(300, 30));
        labelPanel.setLayout(new BorderLayout());
        labelPanel.add(label, BorderLayout.WEST);

        comboBoxPanel1.setPreferredSize(new Dimension(300, 40));
        comboBoxPanel1.setLayout(new BorderLayout());
        comboBoxPanel1.add(comboBox);

        comboBoxPanel2.setPreferredSize(new Dimension(300, 40));
        comboBoxPanel2.setLayout(new BorderLayout());
        comboBoxPanel2.add(comboBox2);

        textFieldPanel.setPreferredSize(new Dimension(300, 40));
        textFieldPanel.setLayout(new BorderLayout());
        textFieldPanel.add(textField, BorderLayout.CENTER);

        converterButtonPanel.setPreferredSize(new Dimension(300, 40));
        converterButtonPanel.setLayout(new BorderLayout());
        converterButtonPanel.add(buttonConvertir, BorderLayout.CENTER);

        principalPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        principalPanel.setPreferredSize(new Dimension(350, 100));
        principalPanel.add(labelPanel);
        principalPanel.add(textFieldPanel);
        principalPanel.add(new Espacio());
        principalPanel.add(comboBoxPanel1);
        principalPanel.add(new Espacio());
        principalPanel.add(comboBoxPanel2);
        principalPanel.add(new Espacio());
        principalPanel.add(resultPanel);
        principalPanel.add(new Espacio());
        principalPanel.add(converterButtonPanel);
        principalPanel.add(new Espacio());
        principalPanel.add(cancelButtonPanel);

        add(principalPanel);

        buttonConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = (String) comboBox.getSelectedItem();
                String opcionSeleccionada2 = (String) comboBox2.getSelectedItem();
                double texto = Double.parseDouble(textField.getText());
                Temperature temp = new Temperature(texto, opcionSeleccionada, opcionSeleccionada2);
                String resultado = "" + temp.getInputResolved();
                resultTextField.setText(resultado);
                //System.out.println(textField.getText());
            }
        });

        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Converter.this.dispose();
                principalWindow.setVisible(true);
            }
        });

    }

}