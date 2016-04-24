package T5AppletsYMultimediaJava;
import java.awt.FontMetrics;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelMensaje extends JPanel {
  private String message = "Prog. de Apps. Interactivas";       /** The message to be displayed */
  private int xCoordinate = 20;                     /** The x coordinate where the message is displayed */
  private int yCoordinate = 20; /** The y coordinate where the message is displayed */
  private boolean centered; /** Indicate whether the message is displayed in the center */
  private int interval = 10; /** The interval for moving the message horizontally and vertically */
  public PanelMensaje() { /** Construct with default properties */
  }

  public PanelMensaje(String message) { /** Construct a message panel with a specified message */
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
    repaint();
  }

  public int getXCoordinate() {
    return xCoordinate;
  }

  public void setXCoordinate(int x) {
    this.xCoordinate = x;
    repaint();
  }

  public int getYCoordinate() {
    return yCoordinate;
  }

  public void setYCoordinate(int y) {
    this.yCoordinate = y;
    repaint();
  }

  public boolean isCentered() {
    return centered;
  }

  /** Set a new centered */
  public void setCentered(boolean centered) {
    this.centered = centered;
    repaint();
  }

  /** Return interval */
  public int getInterval() {
    return interval;
  }

  /** Set a new interval */
  public void setInterval(int interval) {
    this.interval = interval;
    repaint();
  }

  /** Paint the message */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (centered) {
      // Get font metrics for the current font
      FontMetrics fm = g.getFontMetrics();

      // Find the center location to display
      int stringWidth = fm.stringWidth(message);
      int stringAscent = fm.getAscent();
      // Get the position of the leftmost character in the baseline
      xCoordinate = getWidth() / 2 - stringWidth / 2;
      yCoordinate = getHeight() / 2 + stringAscent / 2;
    }

    g.drawString(message, xCoordinate, yCoordinate);
  }

  /** Move the message left */
  public void moveLeft() {
    xCoordinate -= interval;
    repaint();
  }

  /** Move the message right */
  public void moveRight() {
    xCoordinate += interval;
    repaint();
  }

  /** Move the message up */
  public void moveUp() {
    yCoordinate -= interval;
    repaint();
  }

  /** Move the message down */
  public void moveDown() {
    yCoordinate += interval;
    repaint();
  }

  /** Override get method for preferredSize */
  public Dimension getPreferredSize() {
    return new Dimension(200, 30);
  }
}
