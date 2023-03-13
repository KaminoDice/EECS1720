package firsttest;

import processing.core.PApplet;

public class ParticleExample extends PApplet {

	public Particle bullet;
	public Particle firework;

	public void settings() {

		size(800,600); 

		bullet = new Particle(0,height/2,10,-10, color(random(255),random(255),random(255)), random(10)+10);

		firework = new Particle(width/4,height, 0,(float) (-10.0+random(10)-10.0),
				color(random(255),random(255),random(255)),
				random(10)+10);
	}

	public void draw() {
		background(255,255,255);
		bullet.display(this);
		bullet.move();
		firework.display(this);
		firework.move();

	}

	public static void main(String _args[]) {
		PApplet.main(new String[] { firsttest.ParticleExample.class.getName() }); 

	}

}
