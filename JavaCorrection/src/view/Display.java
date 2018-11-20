package view;

public class Display {
	public void display(String string) {
		try{
		System.out.println(string);
		}catch(StackOverflowError e) {
			System.err.println("Error!");
		}
	}
}
