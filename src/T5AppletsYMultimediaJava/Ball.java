package T5AppletsYMultimediaJava;

import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ball extends JPanel {
  private int delay = 10;

  // Create a timer with delay 1000 ms
  private Timer timer = new Timer(delay, new TimerListener());

  private int x = 0; private int y = 0; // Current ball position
  private int radius = 5; // Ball radius
  private int dx = 2; // Increment on ball's x-coordinate
  private int dy = 2; // Increment on ball's y-coordinate

  public Ball() {
    timer.start();
  }

  private class TimerListener implements ActionListener {
    /** Handle the action event */
    public void actionPerformed(ActionEvent e) {
      repaint();
    }
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(Color.RED);

    // Check boundaries
    if (x < radius) 
		  dx = Math.abs(dx);
    if (x > getWidth() - radius) 
		  dx = -Math.abs(dx);
    if (y < radius) 
		  dy = Math.abs(dy);
    if (y > getHeight() - radius) 
		  dy = -Math.abs(dy);

    // Adjust ball position
    x += dx;
    y += dy;
    g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
  }

  public void suspend() {
    timer.stop(); // Suspend timer
  }

  public void resume() {
    timer.start(); // Resume timer
  }

  public void setDelay(int delay) {
    this.delay = delay;
    timer.setDelay(delay);
  }
}


/**
    * Ball extends JPanel to display a moving ball. 
		* The timer listener implements ActionListener to listen for ActionEvent (line 21). 
		* Line 10 creates a Timer for a Ball.
		* The timer is started in line 18 when a Ball is constructed. 
		* The timer fires an ActionEvent at a fixed rate. 
		* The listener responds in line 24 to repaint the ball to animate ball movement.
		* The center of the ball is at (x, y), which changes to (x + dx, y + dy) on the 
		  next display (lines 44-45). 
		* The suspend and resume methods (lines 49-55) can be used to stop and start the timer. 
		* The setDelay(int) method (lines 57-60) sets a new delay.
*/

/* vim: set nu:ts=2:sw=2: */
