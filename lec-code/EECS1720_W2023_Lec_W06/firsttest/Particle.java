package firsttest;

import processing.core.PVector;

public class Particle {

	final float GRAVITY = 9.8f;
	final float DT = 0.1f;
	PVector pos;
	PVector vel;
	int col;
	float radius;
	
	public Particle(float x, float y, float dx, float dy, int c, float r) {
		pos = new PVector(x,y);
		vel = new PVector(dx,dy);
		col = c;
		radius = r;
	}

	public void display(ParticleExample p) {
		p.fill(col);
		p.ellipseMode(ParticleExample.RADIUS);
		p.circle(pos.x, pos.y, radius);
		p.stroke(0,0,0);
	}
	
	public void move() {
		pos.x = pos.x + vel.x*DT;
		pos.y = pos.y + vel.y*DT;
		
		vel.y = vel.y + 0.5f*GRAVITY*DT*DT;		// includes acceleration term
	}

	
}