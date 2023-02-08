package lab3;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PartialTester {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(2);

	private static Random rng = new Random();


	/*
	 * 	QUESTION 1 (4 tests)
	 */

	@Test
	public void testQ1_01_defaultCtor() {
		// default ctor
		Ghost1 act = new Ghost1();

		assertEquals(0,act.x);
		assertEquals(0,act.y);
		assertEquals(100,act.size);
		assertEquals(100/8,act.eyeRad);
		assertEquals(100/16,act.pupilRad);
		assertEquals(Color.CYAN,act.normalCol);
		assertEquals(false,act.frightened);
		assertEquals(false,act.eaten);
		assertEquals(0,act.direction);

	}
	@Test
	public void testQ1_02_customCtor1() {
		Ghost1 act = new Ghost1(206,135,548);

		assertEquals(206,act.x);
		assertEquals(135,act.y);
		assertEquals(548,act.size);

		// defaults
		assertEquals(548/8,act.eyeRad);
		assertEquals(548/16,act.pupilRad);
		assertEquals(Color.CYAN,act.normalCol);
		assertEquals(false,act.frightened);
		assertEquals(false,act.eaten);
		assertEquals(0,act.direction);

		Ghost1 act2 = new Ghost1(183,435,240);

		assertEquals(183,act2.x);
		assertEquals(435,act2.y);
		assertEquals(240,act2.size);

		// defaults
		assertEquals(240/8,act2.eyeRad);
		assertEquals(240/16,act2.pupilRad);
		assertEquals(Color.CYAN,act2.normalCol);
		assertEquals(false,act2.frightened);
		assertEquals(false,act2.eaten);
		assertEquals(0,act2.direction);
	}
	@Test
	public void testQ1_03_customCtor2() {
		Ghost1 act = new Ghost1(183,435,240,Color.GREEN,134);

		assertEquals(183,act.x);
		assertEquals(435,act.y);
		assertEquals(240,act.size);

		// defaults
		assertEquals(240/8,act.eyeRad);
		assertEquals(240/16,act.pupilRad);
		assertEquals(Color.GREEN,act.normalCol);
		assertEquals(false,act.frightened);
		assertEquals(false,act.eaten);
		assertEquals(134,act.direction);
		
	}
	@Test
    public void testQ1_04_toString() {
        Ghost1 act1 = new Ghost1();
        Ghost1 act2 = new Ghost1(183,435,240);
        Ghost1 act3 = new Ghost1(183,435,240,Color.GREEN,134);

        assertEquals("Ghost @ (0, 0):\n\t[ size = 100 * 100 ]\n\t[ colour = java.awt.Color[r=0,g=255,b=255] ]\n\t[ state = normal ]",act1.toString());
        assertEquals("Ghost @ (183, 435):\n\t[ size = 240 * 240 ]\n\t[ colour = java.awt.Color[r=0,g=255,b=255] ]\n\t[ state = normal ]",act2.toString());
        assertEquals("Ghost @ (183, 435):\n\t[ size = 240 * 240 ]\n\t[ colour = java.awt.Color[r=0,g=255,b=0] ]\n\t[ state = normal ]",act3.toString());

        act3.frightened=true;
        assertEquals("Ghost @ (183, 435):\n\t[ size = 240 * 240 ]\n\t[ colour = java.awt.Color[r=0,g=255,b=0] ]\n\t[ state = frightened ]",act3.toString());

        act3.eaten=true;
        assertEquals("Ghost @ (183, 435):\n\t[ size = 240 * 240 ]\n\t[ colour = java.awt.Color[r=0,g=255,b=0] ]\n\t[ state = eaten ]",act3.toString());


    }


	/*
	 * 	QUESTION 2 (3 tests, valid inputs)
	 */

	@Test
	public void testQ2_01_getX() {
		Ghost2 act1 = new Ghost2();
		Ghost2 act2 = new Ghost2(183,435,240);
		Ghost2 act3 = new Ghost2(433,222,240,Color.GREEN,134);

		assertEquals(0,act1.getX());
		assertEquals(183,act2.getX());
		assertEquals(433,act3.getX());
		
	}
	
	@Test
	public void testQ2_02_getY() {
		Ghost2 act1 = new Ghost2();
		Ghost2 act2 = new Ghost2(183,435,240);
		Ghost2 act3 = new Ghost2(433,222,240,Color.GREEN,134);

		assertEquals(0,act1.getY());
		assertEquals(435,act2.getY());
		assertEquals(222,act3.getY());
		
	}
	
	@Test
	public void testQ2_03_getSize() {
		Ghost2 act1 = new Ghost2();
		Ghost2 act2 = new Ghost2(183,435,240);
		Ghost2 act3 = new Ghost2(433,222,140,Color.GREEN,134);

		assertEquals(100,act1.getSize());
		assertEquals(240,act2.getSize());
		assertEquals(140,act3.getSize());
		
	}
	
	@Test
	public void testQ2_04_getBodyCol() {
		Ghost2 act1 = new Ghost2();
		Ghost2 act2 = new Ghost2(183,435,240);
		Ghost2 act3 = new Ghost2(433,222,240,Color.GREEN,134);

		assertEquals(Color.cyan,act1.getBodyCol());
		assertEquals(Color.cyan,act2.getBodyCol());
		assertEquals(Color.green,act3.getBodyCol());
		
	}
	
	@Test
	public void testQ2_05_getDirection() {
		Ghost2 act1 = new Ghost2();
		Ghost2 act2 = new Ghost2(183,435,240);
		Ghost2 act3 = new Ghost2(433,222,240,Color.GREEN,134);

		assertEquals(0,act1.getDirection());
		assertEquals(0,act2.getDirection());
		assertEquals(134,act3.getDirection());
		
	}
	
	@Test
	public void testQ2_06_isFrightened_setFrightened() {
		Ghost2 act1 = new Ghost2();
		Ghost2 act2 = new Ghost2(183,435,240);
		Ghost2 act3 = new Ghost2(433,222,240,Color.GREEN,134);

		assertEquals(false,act1.isFrightened());
		assertEquals(false,act2.isFrightened());
		assertEquals(false,act3.isFrightened());
		
		act1.setFrightened(true);
		assertEquals(true,act1.isFrightened());
		
	}
	
	@Test
	public void testQ2_07_isEaten_setEaten() {
		Ghost2 act1 = new Ghost2();
		Ghost2 act2 = new Ghost2(183,435,240);
		Ghost2 act3 = new Ghost2(433,222,240,Color.GREEN,134);

		assertEquals(false,act1.isEaten());
		assertEquals(false,act2.isEaten());
		assertEquals(false,act3.isEaten());
		
		act1.setEaten(true);
		assertEquals(true,act1.isEaten());
		
	}
	

	@Test
	public void testQ2_08_setXsetY() {
		Ghost2 act1 = new Ghost2();
		
		assertEquals(0,act1.getX());
		
		act1.setX(300);
		act1.setY(600);

		assertEquals(300,act1.getX());
		assertEquals(600,act1.getY());
		
		
	}
	@Test
	public void testQ2_09_setBodyCol() {
		Ghost2 act1 = new Ghost2();
		
		assertEquals(Color.cyan,act1.getBodyCol());
		
		act1.setBodyCol(Color.magenta);
		
		assertEquals(Color.magenta,act1.getBodyCol());
		
		
		
	}
	@Test
	public void testQ2_10_setDirection() {
		Ghost2 act1 = new Ghost2();
		
		assertEquals(0,act1.getDirection());
		
		act1.setDirection(270);

		assertEquals(270,act1.getDirection());
		
		
		
	}
	
	

}
