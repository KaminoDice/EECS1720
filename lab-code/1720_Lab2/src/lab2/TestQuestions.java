package lab2;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestQuestions {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(2);

	private static Random rng = new Random();


	/*
	 * 	QUESTION 1 (5 tests, valid inputs)
	 */

	@Test
	public void testQ1_01() {
		assertEquals("0",Question01.elapsedMins1("12:00"));
	}
	@Test
	public void testQ1_02() {
		assertEquals("35",Question01.elapsedMins1("12:35"));
	}
	@Test
	public void testQ1_03() {
		assertEquals("230",Question01.elapsedMins1("3:50"));
	}
	@Test
	public void testQ1_04() {
		assertEquals("502",Question01.elapsedMins1("8:22"));
	}
	@Test
	public void testQ1_05() {
		assertEquals("719",Question01.elapsedMins1("11:59"));
	}


	/*
	 * 	QUESTION 2 (3 tests, valid inputs)
	 */

	@Test
	public void testQ2_01() {
		// passes Q1 tests
		assertEquals("0",Question02.elapsedMins2("12:00"));
		assertEquals("35",Question02.elapsedMins2("12:35"));
		assertEquals("230",Question02.elapsedMins2("3:50"));
		assertEquals("502",Question02.elapsedMins2("8:22"));
		assertEquals("719",Question02.elapsedMins2("11:59"));
	}
	@Test
	public void testQ2_02() {
		assertEquals("Missing Colon!",Question02.elapsedMins2("56"));
	}
	@Test
	public void testQ2_03() {
		assertEquals("Missing Colon!",Question02.elapsedMins2(""));

	}
	//	@Test
	//	public void testQ2_04() {
	//		assertEquals("",Question02.elapsedMins2("asd:asd"));
	//		
	//	}
	//	@Test
	//	public void testQ2_05() {
	//		assertEquals("",Question02.elapsedMins2("14:20"));
	//		
	//	}


	/*
	 * 	QUESTION 3 (3 tests, valid inputs)
	 */
 
	@Test
	public void testQ3_01() {
		// passes Q1 tests
		assertEquals("0",Question03.elapsedMins3("12:00"));
		assertEquals("35",Question03.elapsedMins3("12:35"));
		assertEquals("230",Question03.elapsedMins3("3:50"));
		assertEquals("502",Question03.elapsedMins3("8:22"));
		assertEquals("719",Question03.elapsedMins3("11:59"));

		// passes Q2 tests
		assertEquals("Missing Colon!",Question03.elapsedMins3("56"));
		assertEquals("Missing Colon!",Question03.elapsedMins3(""));

	}
	@Test
	public void testQ3_02() {
		assertEquals("Non-numeric data!",Question03.elapsedMins3("asd:10"));	
		assertEquals("Non-numeric data!",Question03.elapsedMins3("10:asd"));	
		assertEquals("Non-numeric data!",Question03.elapsedMins3("asd:asd"));	
	}


	/*
	 * 	QUESTION 4 (3 tests, valid inputs)
	 */
	@Test
	public void testQ4_01() {
		// passes Q1 tests
		assertEquals("0",Question04.elapsedMins4("12:00"));
		assertEquals("35",Question04.elapsedMins4("12:35"));
		assertEquals("230",Question04.elapsedMins4("3:50"));
		assertEquals("502",Question04.elapsedMins4("8:22"));
		assertEquals("719",Question04.elapsedMins4("11:59"));

		// passes Q2 tests
		assertEquals("Missing Colon!",Question04.elapsedMins4("56"));
		assertEquals("Missing Colon!",Question04.elapsedMins4(""));

		// passes Q3 tests
		assertEquals("Non-numeric data!",Question04.elapsedMins4("asd:asd"));	

	}
	@Test
	public void testQ4_02() {
		assertEquals("Values out of range!",Question04.elapsedMins4("78:12"));
		assertEquals("Values out of range!",Question04.elapsedMins4("12:98"));
		assertEquals("Values out of range!",Question04.elapsedMins4("14:20"));	
		assertEquals("Values out of range!",Question04.elapsedMins4("10:70"));
		assertEquals("Values out of range!",Question04.elapsedMins4("23:60"));
		
	}
	
	/*
	 * 	QUESTION 5 (3 tests, valid inputs)
	 */
	@Test
	public void testQ5_01() {
		//valid input tests
		assertEquals("0",Question05.elapsedMins5("12:00:am"));
		assertEquals("10",Question05.elapsedMins5("12:10:am"));
		assertEquals("730",Question05.elapsedMins5("12:10:pm"));
		assertEquals("710",Question05.elapsedMins5("11:50:am"));
		assertEquals("1430",Question05.elapsedMins5("11:50:pm"));
		assertEquals("719",Question05.elapsedMins5("11:59:am"));
		assertEquals("1439",Question05.elapsedMins5("11:59:pm"));

		// passes Q2 tests
		assertEquals("Missing Colon!",Question05.elapsedMins5("56"));
		assertEquals("Missing Colon!",Question05.elapsedMins5(""));
		assertEquals("Missing Colon!",Question05.elapsedMins5("10:30"));
		
		// passes Q3 tests
		assertEquals("Non-numeric data!",Question05.elapsedMins5("10:asd:am"));
		assertEquals("Non-numeric data!",Question05.elapsedMins5("asd:10:AM"));
		assertEquals("Non-numeric data!",Question05.elapsedMins5("asd:asd:am"));	
		assertEquals("Non-numeric data!",Question05.elapsedMins5("10:asd:pm"));
		assertEquals("Non-numeric data!",Question05.elapsedMins5("asd:10:PM"));
		assertEquals("Non-numeric data!",Question05.elapsedMins5("asd:asd:pm"));
		

	}
	
	@Test
	public void testQ5_02() {
		assertEquals("Values out of range!",Question05.elapsedMins5("0:10:pm"));	
		assertEquals("Values out of range!",Question05.elapsedMins5("16:35:am"));	
		assertEquals("Values out of range!",Question05.elapsedMins5("13:35:AM"));	
		assertEquals("Values out of range!",Question05.elapsedMins5("23:56:pm"));	
		
	}
	
	@Test
	public void testQ5_03() {
		assertEquals("Invalid AM/PM indicator!",Question05.elapsedMins5("2:30:PP"));	
		assertEquals("Invalid AM/PM indicator!",Question05.elapsedMins5("8:15:AA"));
		assertEquals("Invalid AM/PM indicator!",Question05.elapsedMins5("11:59:mm"));
		
	}

	
	


}
