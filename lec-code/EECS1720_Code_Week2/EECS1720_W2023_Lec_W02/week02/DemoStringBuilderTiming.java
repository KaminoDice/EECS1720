package week02;

public class DemoStringBuilderTiming {

	public static void main(String[] args) {
		

		final String WORD = "Test";
		final int REPEATS = 10000;
		
		long start = System.currentTimeMillis();
		
		// slow way
		String s = "";
		for (int i=0; i<REPEATS; i++) {
			s += WORD;
		}
		long elapsed = System.currentTimeMillis() - start ;
		System.out.println("Time using String class: " + elapsed + " ms");
		
		
		// fast way
		start = System.currentTimeMillis();
		StringBuilder s2 = new StringBuilder();
		for (int i=0; i<REPEATS; i++) {
			s2.append(WORD);
		}
		elapsed = System.currentTimeMillis() - start;
		System.out.println("Time using StringBuilder class: " + elapsed + " ms");
		
		
		
		String result1 = s;
		String result2 = s2.toString();  		// extract from StringBuilder object
		

	}

}
