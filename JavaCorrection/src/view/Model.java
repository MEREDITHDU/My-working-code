package view;
/*
- static elements (except main()) are prohibited,
*/
import view.Display;
import view.Calculator;
import java.util.ArrayList;
import view.View;

import java.lang.Throwable;

/**
 * This is the model class
 * 
 * @author QilinDu
 * @version 1.0
 */
public class Model {
	/**
	 * main method, showing the result of application
	 * @param args that is in the main function
	 * @throws Throwable TheException
	 */

	public static void main(String[] args) throws Throwable {
		Display view = new Display();
		// TODO Auto-generated method stub\
		// generic  
		ArrayList<Integer> input = new ArrayList<Integer>();

		View view2 = new View();
		do {
			view.display("Enter a number");
			int theNum = view2.getInt();
			if(theNum == -1) {
				break;
			}
			input.add(theNum);
			try {
			int answer1 = Calculator.fibonacciI(theNum - 2);
			int answer2 = Calculator.fibonacciR(theNum);
			
			view.display("Fibonacci=" + answer1);
			view.display("Fibonacci=" + answer2);
			}catch(NullPointerException e) {
				view.display("Please enter a non-negative number!");
			}
		} while (true);
	
		// for-each loop
		for (int i : input) {
			view.display("history is:" + i);
		}
	}

}
