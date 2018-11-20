package view;
import view.Display;

/**
 * Exception class representing all abnormal situations in calculation
 * 

 * @author QilinDu
 * @version 1.0
 */

public class IOException {
	 /**
     * Using display method to show potential exceptions
     * @return exception messages 
     * @throws TheException if the input n of index is non-positive
     */
	Display exception=new Display();
	@SuppressWarnings("serial")
	public class IOkException extends Exception {
		
	}

		@SuppressWarnings("serial")
		public class TheException extends Exception{
			public void excpetion() {
			exception.display("Please enter non-negative number!");
			}
			
		public class NullPointerException extends Exception{
			
		}
		}
}
