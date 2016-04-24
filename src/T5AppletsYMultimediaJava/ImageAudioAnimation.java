package T5AppletsYMultimediaJava;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class ImageAudioAnimation extends JApplet {
  private final static int NUMBER_OF_NATIONS = 7;
  private int current = 0;
  private ImageIcon[] icons = new ImageIcon[NUMBER_OF_NATIONS];
  private AudioClip[] audioClips = new AudioClip[NUMBER_OF_NATIONS];
  private AudioClip currentAudioClip;

  private int[] delays =
    {48000, 54000, 59000, 54000, 59000, 31000, 68000};
  private Timer timer = new Timer(delays[0], new TimerListener());

  private JLabel jlblImageLabel = new JLabel();
  private JButton jbtResume = new JButton("Resume");
  private JButton jbtSuspend = new JButton("Suspend");
  private JComboBox jcboNations = new JComboBox(new Object[]
    {"Denmark", "Germany", "China", "India", "Norway", "UK", "US"});

  public ImageAudioAnimation() {
    // Load image icons and audio clips
    for (int i = 0; i < NUMBER_OF_NATIONS; i++) {
      icons[i] = new ImageIcon(getClass().getResource("/image/flag" + i + ".gif"));
      audioClips[i] = Applet.newAudioClip(getClass().getResource("/audio/anthem" + i + ".mid"));
    }

    JPanel panel = new JPanel();
    panel.add(jbtResume);
    panel.add(jbtSuspend);
    panel.add(new JLabel("Select"));
    panel.add(jcboNations);
    add(jlblImageLabel, BorderLayout.CENTER);
    add(panel, BorderLayout.SOUTH);

    jbtResume.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        start();
      }
    });
    jbtSuspend.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        stop();
      }
    });
    jcboNations.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        stop();
        current = jcboNations.getSelectedIndex();
        presentNation(current);
        timer.start();
      }
    });

    timer.start();
    jlblImageLabel.setIcon(icons[0]);
    jlblImageLabel.setHorizontalAlignment(JLabel.CENTER);
    currentAudioClip = audioClips[0];
    currentAudioClip.play();
  }

  private class TimerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      current = (current + 1) % NUMBER_OF_NATIONS;
      presentNation(current);
    }
  }

  private void presentNation(int index) {
    jlblImageLabel.setIcon(icons[index]);
    jcboNations.setSelectedIndex(index);
    currentAudioClip = audioClips[index];
    currentAudioClip.play();
    timer.setDelay(delays[index]);
  }

  public void start() {
    timer.start();
    currentAudioClip.play();
  }

  public void stop() {
    timer.stop();
    currentAudioClip.stop();
  }

  /** Main method */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("ImageAudioAnimation");

    // Create an instance of the applet
    ImageAudioAnimation applet = new ImageAudioAnimation();
    applet.init();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Display the frame
    frame.setSize(400, 300);
    frame.setVisible(true);
  }
}

/**
    * A timer is created to control the animation (line 15).
		* The timer delay for each presentation is the play time for the anthem. 
		* You can find the play time for an audio file using RealPlayer or Windows Media. 
		* The delay times are stored in an array named delays (lines 13-14). 
		* The delay time for the first audio file (the Danish anthem) is 48 seconds.
		* A label is created in line 17 to display a flag image. 
		* An array of flag images for seven nations is created in lines 26-27. 
		* An array of audio clips is created in lines 28-29. 
		* Each audio clip is created for an audio file through the URL of the current class. 
		* The audio files are stored in the same directory with the applet class file.
		* The combo box for country names is created in lines 20-21. 
		* When a new country name in the combo box is selected, the current presentation is 
		  stopped and a new selected nation is presented (lines 52-55).
		* The presentNation(index) method (lines 71-77) presents a nation with the specified
		  index. 
		* It sets a new image in the label (line 72), synchronizes with the combo box by setting
		  the selected index (line 73), plays the new audio, and sets a new delay time (line 76).
		* The applet’s start and stop methods are overridden to resume and suspend the animation
		  (lines 79-87).
*/

/* vim: set nu:ts=2:sw=2: */
