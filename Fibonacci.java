package anfibo;

import java.io.*; //for I/O
import java.util.Collection;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.lang.Throwable;

/**
 * This program tests the Fibon class using iterative method.
 * @version 1.0 02-04-2018
 * @author Qilin Du
 */

public class Fibonaaci {
		static int theNum;
		
		 /**
	     * Method to calculate the list of position n Fibonacci numbers
	     * @param n non-negative number
	     * @return fibonacci number
	     */
	    public static int fibonacci(int n) {
	    	// The first Fibonacci number is 0 and the second Fibonacci number is 1
	      if(n<=0)
	    	  return 0;
	      else if(n==1)
	    	  return 1;
	      
	      int pre=1;
	      int now=1;
//--------------------------------iterative algorithm------------------------------------
	      for(int i=0;i<n;i++) {
	      int temp=now;
	      now+=pre;
	      pre=temp;
	      }
//-------------------------------------------------------------------------
	      return now;
	      
	    }
//-------------------------------------------------------------------------	
	    /**
	     * Test it.
	     * @param args
	     */
	    
	    String gripe="string length=0";
	    //Definition of verifiable Exception class
	    //-------------------------------------------------------------------------
			class NumberFormatException extends IOException{
				/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
				public NumberFormatException() {}
				public NumberFormatException(String gripe) {
					super(gripe);
				}
			}
//---------------------------------------------------------------------------------
			
	public static void main(String[] args) throws IOException,NumberFormatException {
		// TODO Auto-generated method stub
		
		System.out.println("Enter a number");
		try {
		theNum=getInt();
		}catch(Exception e) {
			System.out.println("Please enter a number!");
		}
		int theAnswer=fibonacci(theNum-2);
		System.out.println("Fibonacci="+theAnswer);
		
		//Generic collections
				try {
				Collection<String> args1 = null;
				@SuppressWarnings({ "unused", "null" })
				Iterator iter=(Iterator) args1.iterator();
				}catch(NullPointerException e) {
					System.out.println("NullPointerException");
				}
				
				
		//Command line argument in Java, for-each loop
		for( String a:args)
			System.out.println(a);
		
		Throwable t=new Throwable();
		StackTraceElement[] frames=t.getStackTrace();
		//usage of for-each loop
			for(StackTraceElement f:frames)
			System.out.println(f);
				
		//Concrete Collections:Maps
		Map<Thread,StackTraceElement[]> map=Thread.getAllStackTraces();
		//usage of for-each loop
		for(Thread th:map.keySet()) {
			StackTraceElement[] f=map.get(th);
			System.out.println(f);
			}
		}
	
	
//-------------------------------------------------------------------------
	public static String getString() throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s=br.readLine();
		return s;
	}
//-------------------------------------------------------------------------
/**
     * try catch and handle exceptions
     * @throws IOException
     */
//	throw and handle exceptions
	public static int getInt() throws IOException,NumberFormatException {
		try {
		String s=getString();
		return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println("please Enter a number!");	
		}
		return theNum;
	}
//-------------------------------------------------------------------------
	

}
