package T5AppletsYMultimediaJava;
import javax.swing.*;

public class DisplayImageWithURL extends JApplet {
  public DisplayImageWithURL() {
    java.net.URL url = this.getClass().getResource("image/Spain.gif");
    add(new JLabel(new ImageIcon(url)));
  }

  /** Main method */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("DisplayImageWithURL");

    // Create an instance of the applet
    DisplayImageWithURL applet = new DisplayImageWithURL();
    applet.init();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, java.awt.BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Display the frame
    frame.setSize(200, 150);
    frame.setVisible(true);
  }
}
/**
    * The program displays an image from image/Spain.gif in the class directory.

		* The file image/Spain.gif is under the class directory, and its URL is obtained using the
		  getResource method (line 5). 

		* A label with an image icon is created in line 6. 

		* The image icon is obtained from the URL.

		* If you replace the code in lines 5-6 with the following code,
		  
			add(new JLabel(new ImageIcon("image/Spain.gif")));
		
		  you can still run the program standalone, but not from a browser
*/

/* vim: set nu:ts=2:sw=2: */
