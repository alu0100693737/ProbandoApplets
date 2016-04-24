package T5AppletsYMultimediaJava;
import javax.swing.*;

public class DisplayMessage extends JApplet {
  /** Initialize the applet */
  public void init() {
    // Get parameter values from the HTML file
    String mensaje = getParameter("MESSAGE");
    int x = Integer.parseInt(getParameter("X"));
    int y = Integer.parseInt(getParameter("Y"));

    // Create a mensaje panel
    PanelMensaje panelMensaje = new PanelMensaje(mensaje);
    panelMensaje.setXCoordinate(x);
    panelMensaje.setYCoordinate(y);

    // Add the mensaje panel to the applet
    add(panelMensaje);
  }
}
