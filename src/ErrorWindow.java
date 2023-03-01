// Importing the classes that are needed for the program to run.
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorWindow extends JFrame {
    public ErrorWindow(String title, String message) {
        JFrame frame = new JFrame(title);
        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);
        JButton button = new JButton("Ok");

       // Setting the layout of the panel to a FlowLayout with a horizontal gap of 300 pixels and a
       // vertical gap of 0 pixels. It is then adding a new Espacio object, the label, another Espacio
       // object, and the button to the panel.
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 0));
        panel.add(new Espacio());
        panel.add(label);
        panel.add(new Espacio());
        panel.add(button);

        // Adding the panel to the frame, setting the default close operation to exit the program when
        // the window is closed, setting the size of the window to 450 pixels wide and 140 pixels tall,
        // setting the location of the window to the center of the screen, setting the window to not be
        // resizable, and setting the window to be visible.
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 140);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

     // Adding an action listener to the button. When the button is clicked, the action listener will
     // dispose of the frame and the ErrorWindow object.
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ;
                ErrorWindow.this.dispose();
            }
        });
    }
}