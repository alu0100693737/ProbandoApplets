package T5AppletsYMultimediaJava;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BallControl extends JPanel {
  private Ball ball = new Ball();
  private JButton jbtSuspend = new JButton("Suspend");
  private JButton jbtResume = new JButton("Resume");
  private JScrollBar jsbDelay = new JScrollBar();

  public BallControl() {
    // Group buttons in a panel
    JPanel panel = new JPanel();
    panel.add(jbtSuspend);
    panel.add(jbtResume);

    // Add ball and buttons to the panel
    ball.setBorder(new javax.swing.border.LineBorder(Color.RED));
    jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
    ball.setDelay(jsbDelay.getMaximum());
    setLayout(new BorderLayout());
    add(jsbDelay, BorderLayout.NORTH);
    add(ball, BorderLayout.CENTER);
    add(panel, BorderLayout.SOUTH);

    // Register listeners
    jbtSuspend.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ball.suspend();
      }
    });
    jbtResume.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ball.resume();
      }
    });
    jsbDelay.addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        ball.setDelay(jsbDelay.getMaximum() - e.getValue());
      }
    });
  }
}


/**
    * The BallControl class extends JPanel to display the ball with a scroll bar and two control
		  buttons. 
		* When the Suspend button is clicked, the ball’s suspend() method is invoked to suspend
		  the ball movement (line 29). 
		* When the Resume button is clicked, the ball’s resume() method is invoked to resume the 
		  ball movement (line 34). 
		* The bouncing speed can be changed using the scroll bar.
*/

/* vim: set nu:ts=2:sw=2: */
