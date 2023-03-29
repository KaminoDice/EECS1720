package lectures.week11.timersthreads;

import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and container
 
/** 
 * A Bouncing Ball: Running animation via Swing Timer 
 */
@SuppressWarnings("serial")
public class BouncingBallTimer extends JFrame {
	
   // Define named-constants
   private static final int CANVAS_WIDTH = 640;
   private static final int CANVAS_HEIGHT = 480;
   private static final int UPDATE_PERIOD = 50; // milliseconds
 
   private DrawCanvas canvas;  // the drawing canvas (an inner class extends JPanel)
 
   // Attributes of moving object
   private int x = 100, y = 100;  // top-left (x, y)
   private int size = 250;        // width and height
   private int xSpeed = 3, ySpeed = 5; // displacement per step in x, y
   
   // Timer
   private Timer t;
 
   // Constructor to setup the GUI components and event handlers
   public BouncingBallTimer(String title) {
	   
	  super(title);
      canvas = new DrawCanvas();
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
      
      this.setContentPane(canvas);
      
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.pack();
      this.setVisible(true);
 
      // allocate a timer and connect to UpdateListener, set running
      this.t = new Timer(UPDATE_PERIOD, new UpdateListener());
      this.t.start();	// runs indefinitely
      
      
   }
   
   // Constructor to setup the GUI components and event handlers
   public BouncingBallTimer(String title, int speed) {
	   
	  super(title);
      canvas = new DrawCanvas();
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
      
      this.setContentPane(canvas);
      
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.pack();
      this.setVisible(true);
 
      // allocate a timer and connect to UpdateListener, set running
      this.t = new Timer(speed, new UpdateListener());
      this.t.start();	// runs indefinitely
      
      
   }
   
   private class UpdateListener implements ActionListener {
	   
	   @Override
       public void actionPerformed(ActionEvent evt) {
          update();   // update the (x, y) position
          repaint();  // Refresh the JFrame, callback paintComponent()
          
       }
	   
   }
 
   // Update the (x, y) position of the moving object
   public void update() {
	   
      x += xSpeed;
      y += ySpeed;
      
      // cause a flip (if bounce detected on edge of screen in x or y)
      if (x > CANVAS_WIDTH - size || x < 0) {
         xSpeed = -xSpeed;
      }
      if (y > CANVAS_HEIGHT - size || y < 0) {
         ySpeed = -ySpeed;
      }
   }
 
   // Define inner class DrawCanvas, which is a JPanel used for custom drawing
   private class DrawCanvas extends JPanel {
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);  // paint parent's background
         setBackground(Color.BLACK);
         g.setColor(Color.BLUE);
         g.fillOval(x, y, size, size);  // draw a circle
      }
   }
 
   // The entry main method
   public static void main(String[] args) {

            new BouncingBallTimer("Bouncing Ball Timer"); 
            new BouncingBallTimer("Bouncing Ball Timer 2", 10);
   }

}