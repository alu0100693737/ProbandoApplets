package T5AppletsYMultimediaJava;
import javax.swing.*;

public class DisplayLabel extends JApplet {
  public DisplayLabel() {
    add(new JLabel("¡Bien!", JLabel.CENTER));
  }
  
  public static void main(String[] args) {
    // 1. Create a frame
    JFrame frame = new JFrame("El applet se encuentra en el frame");

    // 2. Create an instance of the applet
    DisplayLabel applet = new DisplayLabel();

    // 3. Add the applet to the frame
    frame.add(applet);

    // 4. Display the frame
    frame.setSize(300, 100);
    frame.setLocationRelativeTo(null); // Center the frame   
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
