package week03;

public class OutOfMemError {

	
	public OutOfMemError() {
		
		// construct instance, no fields to set
		
	}
	

	public void generateOOM() throws Exception {
		
		int iteratorValue = 20;
		System.out.println("\n=================> OOM test started..\n");
		
		for (int outerIterator = 1; outerIterator < 20; outerIterator++) {
			
			System.out.println("Iteration " + outerIterator + " Free Mem: " + Runtime.getRuntime().freeMemory());
			int loop1 = 2;
			int[] memoryFillIntVar = new int[iteratorValue];
			
			iteratorValue = iteratorValue * 5;
			if (iteratorValue<0) iteratorValue=Integer.MAX_VALUE;
			System.out.println("\nRequired Memory for next loop: " + iteratorValue);
			Thread.sleep(10);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		OutOfMemError memoryTest = new OutOfMemError();
		memoryTest.generateOOM();
		
	}
	
	
	
}
