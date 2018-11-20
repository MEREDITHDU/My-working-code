package view;

import view.Display;
/**
 * Class Calculator, the function body of calculating fibonacci sequence
 *
 * @author QilinDu
 * @version 1.0
 *
 */

public class Calculator {
	
	Calculator calculator=new Calculator();
	Display view=new Display();
	 static Exception TheException=null;
	
	 /**
     * Using iterative algorithm to calculate fibonacci sequence
     * @return result of fibonacci sequence 
     * @param input number n which denotes the index
     * @throws TheException if the input n of index is non-positive
     */
	
	 public static int fibonacciI(int n) throws Exception {
		//----------------------------iterative algorithm---------------------------
			if(n<0)
				throw TheException;
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
	     * @return result of fibonacci sequence 
	     * @param input number n which denotes the index
	     * @throws TheException if the input n of index is non-positive
	     */
	 
	 //---------------------------recursive------------------------------------
		public static int fibonacciR(int n) throws Throwable {
			if(n<0)
				throw TheException;
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
