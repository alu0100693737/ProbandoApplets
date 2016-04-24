package T5AppletsYMultimediaJava;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TresEnRaya extends JApplet {
  // Indicate which player has a turn, initially it is the X player
  private char whoseTurn = 'X';

  // Create and initialize cells
  private Cell[][] cells =  new Cell[3][3];

  // Create and initialize a status label
  private JLabel jlblStatus = new JLabel("Les toca jugar a las X");

  /** Initialize UI */
  public TresEnRaya() {
    // Panel p to hold cells
    JPanel p = new JPanel(new GridLayout(3, 3, 0, 0));
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        p.add(cells[i][j] = new Cell());

    // Set line borders on the cells panel and the status label
    p.setBorder(new LineBorder(Color.red, 1));
    jlblStatus.setBorder(new LineBorder(Color.yellow, 1));

    // Place the panel and the label to the applet
    add(p, BorderLayout.CENTER);
    add(jlblStatus, BorderLayout.SOUTH);
  }

  /** Determine if the cells are all occupied */
  public boolean isFull() {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        if (cells[i][j].getToken() == ' ')
          return false;

    return true;
  }

  /** Determine if the player with the specified token wins */
  public boolean isWon(char token) {
    for (int i = 0; i < 3; i++)
      if ((cells[i][0].getToken() == token)
          && (cells[i][1].getToken() == token)
          && (cells[i][2].getToken() == token)) {
        return true;
      }

    for (int j = 0; j < 3; j++)
      if ((cells[0][j].getToken() ==  token)
          && (cells[1][j].getToken() == token)
          && (cells[2][j].getToken() == token)) {
        return true;
      }

    if ((cells[0][0].getToken() == token)
        && (cells[1][1].getToken() == token)
        && (cells[2][2].getToken() == token)) {
      return true;
    }

    if ((cells[0][2].getToken() == token)
        && (cells[1][1].getToken() == token)
        && (cells[2][0].getToken() == token)) {
      return true;
    }

    return false;
  }

  // An inner class for a cell
  public class Cell extends JPanel {
    // Token used for this cell
    private char token = ' ';

    public Cell() {
      setBorder(new LineBorder(Color.black, 1)); // Set cell's border
      addMouseListener(new MyMouseListener());   // Register listener
    }

    /** Return token */
    public char getToken() {
      return token;
    }

    /** Set a new token */
    public void setToken(char c) {
      token = c;
      repaint();
    }

    /** Paint the cell */
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      if (token == 'X') {
        g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
        g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
      }
      else if (token == 'O') {
        g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
      }
    }

    private class MyMouseListener extends MouseAdapter {
      /** Handle mouse click on a cell */
      public void mouseClicked(MouseEvent e) {
        // If cell is empty and game is not over
        if (token == ' ' && whoseTurn != ' ') {
          setToken(whoseTurn); // Set token in the cell

          // Check game status
          if (isWon(whoseTurn)) {
            jlblStatus.setText("¡Las " + whoseTurn + " ganaron! Fin del juego");
            whoseTurn = ' '; // Game is over
          }
          else if (isFull()) {
            jlblStatus.setText("¡Empate! Fin del juego");
            whoseTurn = ' '; // Game is over
          }
          else {
            // Change the turn
            whoseTurn = (whoseTurn == 'X') ? 'O': 'X';
            // Display whose turn
            jlblStatus.setText("Les toca jugar a las " + whoseTurn);
          }
        }
      }
    }
  }

  /** This main method enables the applet to run as an application */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("TresEnRaya");

    // Create an instance of the applet
    TresEnRaya applet = new TresEnRaya();

    // Add the applet instance to the frame
    frame.add(applet, BorderLayout.CENTER);

    // Display the frame
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}


/**
    * The TresEnRaya class initializes the user interface with nine cells placed in a panel of
		  GridLayout (lines 19–22). 
		* A label named jlblStatus is used to show the status of the game (line 14). 
		* The variable whoseTurn (line 8) is used to track the next type of token to be placed in a cell. 
		* The methods isFull (lines 34-41) and isWon (lines 44–72) are for checking the status of the game.
		* Since Cell is an inner class in TresEnRaya, the variable (whoseTurn) and methods (isFull
		  and isWon) defined in TresEnRaya can be referenced from the Cell class. 
		* The inner class makes programs simple and concise. If Cell were not declared as an inner class 
		  of TresEnRaya, you would have to pass an object of TresEnRaya to Cell in order for the variables 
		  and methods in TresEnRaya to be used in Cell. 
		* The listener for MouseEvent is registered for the cell (line 81). 
		* If an empty cell is clicked and the game is not over, a token is set in the cell (line 113). 
		* If the game is over, whoseTurn is set to ' ' (lines 118, 122). 
		* Otherwise, whoseTurn is alternated to a new turn (line 126).
*/

/* vim: set nu:ts=2:sw=2: */
