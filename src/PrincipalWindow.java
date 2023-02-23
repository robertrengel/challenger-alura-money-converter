import javax.swing.JFrame;

public class PrincipalWindow extends JFrame {
    public PrincipalWindow(int wigth, int height, String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(wigth, height);
        //setSize(350, 140);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
    }
    
}
    

