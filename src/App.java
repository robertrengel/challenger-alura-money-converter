import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) throws Exception {

        PrincipalWindow menuInicio = new PrincipalWindow(350, 140, "Menu Inicio");
        PanelPrincipal panelPrincipal = new PanelPrincipal(350, 110);
        PanelSelection panelSelection = new PanelSelection();
        PanelButtons panelButtons = new PanelButtons();

        panelPrincipal.add(panelSelection);
        panelPrincipal.add(panelButtons);
        menuInicio.add(panelPrincipal);
        menuInicio.setVisible(true);
        
        panelButtons.getButtonSeleccionar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene la opción seleccionada en el JComboBox
                String opcionSeleccionada = (String) panelSelection.getComboBox().getSelectedItem();
                System.out.println();
                System.out.println("La opcion seleccionada es: " + opcionSeleccionada);
                
            }
        });
        
    }

}
