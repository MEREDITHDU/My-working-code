package fibo;
import java.io.*; //for I/O
import java.util.Collection;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.lang.Throwable;;

/**
 * A program tests the Fibon class using recursive method call.
 * @version 2.0 25-03-2018
 * @author Qilin Du
 */

public class Fibon {
	 static int theNum;
	
	/**
     * Test it.
     * @param args
     */
	
	 String gripe="string length=0";
//	 Definition of verifiable Exception class
//	 -------------------------------------------------------------
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
//		----------------------------------------------------------------
	@SuppressWarnings("null")
	public static void main(String[] args) throws NullPointerException,NumberFormatException,IOException{
		// TODO Auto-generated method stub
		System.out.println("Enter a number");
		try {
			theNum=getInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Please Enter a number!");;
		}
		int theAnswer=fibo(theNum);
		System.out.println("Fibonacci="+theAnswer);
		
		//Generic collections
		try {
		Collection<String> args1 = null;
		@SuppressWarnings("unused")
		Iterator iter=(Iterator) args1.iterator();
		}catch(NullPointerException e) {
			System.out.println("NullPointerException");
		}
		
		//Command line argument in Java,for-each loop
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
//	-----------------------------------------------------------------------
	 /**
     * Method to calculate the list of position n Fibonacci numbers
     * @param n non-negative integer
     * @return Fibonaaci number
     */
	public static int fibo(int n) {
		// The first Fibonacci number is 0
		if(n<=0)
			return 0;
		// The second Fibonacci number is 1
		else if(n==1)
			return 1;
		else
			//Then we can define the Fibonacci in position n as:
			//f(n)=f(n-1)+f(n-2)
			return fibo(n-1)+fibo(n-2); 
	}
//	-----------------------------------------------------------------------
	
	public static String getString() throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s=br.readLine();
		return s;
	}
//	-----------------------------------------------------------------------
	/**
     * try catch and handle exceptions
     * @throws IOException
     */
//	throw and handle exceptions
	public static int getInt() throws IOException,NumberFormatException {
		try {
		String s=getString();
		return Integer.parseInt(s);
		}catch (NumberFormatException e) {
			System.out.println("please enter a number!");	
		}
		return theNum;
		
	}
	
//	-----------------------------------------------------------------------
}
