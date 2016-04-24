package T5AppletsYMultimediaJava;
import javax.swing.*;
import java.net.URL;
import java.applet.*;

public class DisplayImagePlayAudio extends JApplet {
  private AudioClip audioClip;

  public DisplayImagePlayAudio() {
    URL urlForImage = getClass().getResource("image/denmark.gif");
    add(new JLabel(new ImageIcon(urlForImage)));

    URL urlForAudio = getClass().getResource("audio/denmark.mid");
    audioClip = Applet.newAudioClip(urlForAudio);
    audioClip.loop();
  }

  public void start() {
    if (audioClip != null) 
		  audioClip.loop();
  }

  public void stop() {
    if (audioClip != null) 
		  audioClip.stop();
  }

  /** Main method */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("DisplayImagePlayAudio");

    // Create an instance of the applet
    DisplayImagePlayAudio applet = new DisplayImagePlayAudio();
    applet.init();

    // Add the applet instance to the frame
    frame.add(applet, java.awt.BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Display the frame
    frame.setSize(200, 500);
    frame.setVisible(true);
  }
}

/**
    * The program displays the Danish flag and plays the Danish national anthem repeatedly. 
		* The image file image/denmark.gif and audio file audio/denmark.mid
		  are stored under the class directory. 
		* Line 12 obtains the audio file URL. 
		* Line 13 creates an audio clip for the file. 
		* Line 14 repeatedly plays the audio.
		* The stop method (lines 21-23) stops the audio when the applet is not displayed, and the
		  start method (lines 17-19) restarts the audio when the applet is redisplayed. 
		*	Try to run this applet from a browser and observe the effect without the stop and start methods.
*/

/* vim: set nu:ts=2:sw=2: */
