package week10;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.event.MouseInputAdapter;

//import MouseSelection.SelectionArea.MyListener;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class SimpleMouseSelect extends JFrame {


	private JLabel rectBounds;
	private SelectionCanvas canvas;
	
	private Picture origImage;


	public SimpleMouseSelect(String title, String imgFile) {

		super(title);
		Container pane = this.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		ImageIcon img = new ImageIcon(imgFile);
		this.origImage = new Picture(imgFile);		// using a different class to store/open

		this.canvas = new SelectionCanvas(img);
		this.add(this.canvas);

		this.rectBounds = new JLabel("Drag within the image");
		this.rectBounds.setLabelFor(this.canvas);
		this.add(this.rectBounds);

		this.canvas.setAlignmentX(LEFT_ALIGNMENT);
		this.rectBounds.setAlignmentX(LEFT_ALIGNMENT);

		// setup JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
		this.setTitle("Simple Mouse Select");
		this.pack();           
		this.setVisible(true);



	}

	private class SelectionCanvas extends JLabel {

		private Rectangle currentRect = null;											
		private Rectangle rectToDraw = null;
	
		public SelectionCanvas(ImageIcon image) { 

			super(image);    //This component displays an image.

			setOpaque(true);
			setMinimumSize(new Dimension(10,10)); //don't hog space

			MyListener myListener = new MyListener();
			addMouseListener(myListener);
			addMouseMotionListener(myListener);

		}

		public void paint(Graphics g) {

			super.paint(g);   //paints the background and image

			//If currentRect exists, paint a box on top.
			if (currentRect != null) {

				//Draw a rectangle on top of the image.

				g.setXORMode(Color.white); 	//Color of line varies
											//depending on image colors

				g.drawRect(rectToDraw.x, rectToDraw.y, 
						rectToDraw.width - 1, rectToDraw.height - 1);


				// update rectBounds (with rectToDraw):
				int width = rectToDraw.width;
				int height = rectToDraw.height;

				//Make the coordinates look OK if a dimension is 0.
				if (width == 0) {
					width = 1;
				}
				if (height == 0) {
					height = 1;
				}

				rectBounds.setText("Rectangle goes from ("
						+ rectToDraw.x + ", " + rectToDraw.y + ") to ("
						+ (rectToDraw.x + width - 1) + ", "
						+ (rectToDraw.y + height - 1) + ").");
			}
		}



		private class MyListener extends MouseInputAdapter {

			public void mousePressed(MouseEvent e) {

				// capture initial position of mouse
				int x = e.getX();
				int y = e.getY();

				// create a new Rectangle after capturing initial position of mouse
				currentRect = new Rectangle(x, y, 0, 0);
				
				// update drawable rectangle (clean it up before drawing)
				updateDrawableRect(getWidth(), getHeight()); // passes width and height of JFrame
				
				repaint();		// calls JFrame's repaint which calls paintComponent()
			}

			
			public void mouseDragged(MouseEvent e) {
				updateSize(e);
			}

			
			public void mouseReleased(MouseEvent e) {
				updateSize(e);
				
				// launch task to use selection here
				
				// you can find these methods (java versions of image blend/crop/merge/
				// sepia/edge filter in the files: 
				// ImageManip.java, Question02.java, Question03.java 
				// (we did these in processing in eecs1710 last semester
				
				Picture cropped = ImageManip.crop(new Picture(origImage), rectToDraw.x, rectToDraw.y, 
						rectToDraw.width, rectToDraw.height);
				
				
				Picture sepia = Question03.sepiaImage(new Picture(cropped));
				Picture edge = Question03.edgeImage(new Picture(cropped), 10);
				
				cropped.show(); 
				
				sepia.show();
				edge.show();
			}

			// Cleans up rectangle to be drawn (if negative width/height or rect off screen)
			private void updateDrawableRect(int compWidth, int compHeight) {

				// get position and size of currentRect (to create rectToDraw)
				int x = currentRect.x;
				int y = currentRect.y;
				int width = currentRect.width;
				int height = currentRect.height;

				//Make the width and height positive, if necessary. (resets x,y to top left)
				if (width < 0) {
					width = 0 - width;
					x = x - width + 1; 
					if (x < 0) {
						width += x; 
						x = 0;
					}
				}
				if (height < 0) {
					height = 0 - height;
					y = y - height + 1; 
					if (y < 0) {
						height += y; 
						y = 0;
					}
				}

				//The rectangle shouldn't extend past the drawing area. 
				if ((x + width) > compWidth) {
					width = compWidth - x;
				}

				if ((y + height) > compHeight) {
					height = compHeight - y;
				}

				//Update rectToDraw after saving old value.
				if (rectToDraw != null) {
					rectToDraw.setBounds(x, y, width, height);
				} 
				else {
					rectToDraw = new Rectangle(x, y, width, height);
				}

			}
			
			
			/* 
			 * Update the size of the current rectangle
			 * and call repaint.  Because currentRect
			 * always has the same origin, translate it
			 * if the width or height is negative.
			 * 
			 * For efficiency (though
			 * that isn't an issue for this program),
			 * specify the painting region using arguments
			 * to the repaint() call.
			 * 
			 */
			void updateSize(MouseEvent e) {

				
				int x = e.getX();
				int y = e.getY();

				// modify currentRect's width and height only
				currentRect.setSize(x - currentRect.x, y - currentRect.y);

				// clean up rectToDraw
				updateDrawableRect(getWidth(), getHeight());
				
				repaint();

			}
		}


	}


	public static void main(String[] args) {


		SimpleMouseSelect frame = 
				new SimpleMouseSelect("Simple Mouse Select", "week10/yogaBike.jpg");

	}


}
