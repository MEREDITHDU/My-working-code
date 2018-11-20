package view;

import static org.junit.Assert.fail;

import org.junit.Test;

public class TestCalculator {
	TestCalculator calculator=new TestCalculator();
	Display view=new Display();
	 static Exception TheException=null;
	
	 /**
     * Using iterative algorithm to calculate fibonacci sequence
     *
     * @param input number n which denotes the index
	 * @return 
     * @throws BankException if the input n of index is non-positive
     */
	
	 @Test
	 public int fibonacciI(int n) throws Exception {
		//----------------------------iterative algorithm---------------------------
			if(n<0)
				fail("should be non-negative number!");
			// The first Fibonacci number is 0 and the second Fibonacci number is 1
	      if(n==0)
	    	  return 0;
	      else if(n==1)
	    	  return 1;
	      /**
	      *initialize the position
	      */
	      int pre=1;
	      int now=1;
	
	      for(int i=0;i<n;i++) {
	      int temp=now;
	      now+=pre;
	      pre=temp;
	      }
	//-------------------------------------------------------------------------
	      return now;
	    }
	 
	 /**
	     * Using recursive algorithm to calculate fibonacci sequence
	     *
	     * @param input number n which denotes the index
	     * @throws BankException if the input n of index is non-positive
	     */
	 @Test
	 //---------------------------recursive------------------------------------
		public int fibonacciR(int n) throws Throwable {
			if(n<0)
				fail("should be non-negative number!");
			// The first Fibonacci number is 0 and the second Fibonacci number is 1
			if(n==0)
				return 0;
			else if(n==1)
				return 1;
			else
				return fibonacciR(n-1)+fibonacciR(n-2); 
		}
//		-----------------------------------------------------------------------
	 
}
