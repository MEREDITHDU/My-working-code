package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {
	public View() throws IOException {
		
	}
	
	//-------------------------------------------------------------------------
	 /**
     * Getter for the 'String' field 
     *
     * @return String from keyboard
     */
		public String getString() throws IOException {
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			String s=br.readLine();
			return s;
		}
	//-------------------------------------------------------------------------
		/**
	     * Getter for the 'integer' field 
	     *
	     * @return integer from keyboard
	     */

		  public int getInt() throws IOException
	      {
	      String s = getString();
	      return Integer.parseInt(s);
	      }
	//-------------------------------------------------------------------------
		
}



