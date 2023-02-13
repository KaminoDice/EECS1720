package week4;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import imagePackage.RasterImage;

public class YorkULogo2 {

	// class fields
	private RasterImage img;
	private Graphics2D gfx;
	private Point2D position;
	private Rectangle2D bounds;
	private Rectangle2D backgnd;
	private Rectangle2D whiteRect;
	private Ellipse2D whiteCircle;
	private Rectangle2D redRect;
	private Ellipse2D redCircle;

	// one custom constructor (no default ctor)
	public YorkULogo2(int x, int y, int w, int h) {

		// throw an exception if logo is not positive sized (prevents instantiation)
		if (w<=0 || h<=0) 
			throw new RuntimeException("logo should have positive width and height");
		
		img = new RasterImage(640,480);
		gfx = img.getGraphics2D();
		this.position = new Point2D.Double(x,y);
		this.bounds = new Rectangle2D.Double(x, y, w, h);
		this.backgnd = new Rectangle2D.Double(x, y, w, h);
		this.whiteRect = new Rectangle2D.Double(x + 0.4*w , y, 0.6*w, 0.5*h);
		this.whiteCircle = new Ellipse2D.Double(x + 0.4*w , y + 0.5*h - 0.3*w, 
				0.6*w,0.6*w);
		this.redRect = new Rectangle2D.Double(x + 0.6*w, y, 0.2*w, 0.5*h);
		this.redCircle = new Ellipse2D.Double(x + 0.6*w, y + 0.5*h - 0.1*w , 
				0.2*w,0.2*w);
	}

	public void drawLogo() {
		this.img.show();
		this.img.setTitle("YorkU");
		this.gfx.setColor(Color.RED);
		this.gfx.draw(this.backgnd);
		this.gfx.fill(this.backgnd);

		this.gfx.setColor(Color.WHITE);
		this.gfx.draw(this.whiteRect);
		this.gfx.draw(this.whiteCircle);
		this.gfx.fill(this.whiteRect);
		this.gfx.fill(this.whiteCircle);

		this.gfx.setColor(Color.RED);
		this.gfx.draw(this.redRect);
		this.gfx.draw(this.redCircle);
		this.gfx.fill(this.redRect);
		this.gfx.fill(this.redCircle);
	}
	
	public static void main(String[] args) {
		YorkULogo2 logo = new YorkULogo2(0,0,100,100);
		logo.drawLogo();

		YorkULogo2 logo2 = new YorkULogo2(150,150,400,400);
		logo2.drawLogo();
	}
}