package sort;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * Generate a text file of given size of random words
 */
public class RandomWordGenerator {

	/**
	 * @brief Allow a user to choose a file size and generate words to that
	 */
	public RandomWordGenerator() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a words cap in Gigabytes: ");
		generateWords(Double.parseDouble(scanner.nextLine()));
		scanner.close();
	}

	/**
	 *  @brief Randomly generate words
	 * @param dataCap the max file size
	 */
	private static void generateWords(double dataCap){
		try{
			System.out.println("Generating words.txt, please wait...");
			System.out.print("Percent Generated: 0...");
			dataCap *= 1073741824;
			long dataUsed = 0;
			long currentBytes = 0;
			int percent = 0;
			PrintWriter writer = new PrintWriter("words.txt", "UTF-8");
			Random random = new Random();
			long value = 10000000000L;
			for(long i = 0; i < value; i++)
			{
				char[] word = new char[random.nextInt(30)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
				for(int j = 0; j < word.length; j++)
				{
					word[j] = (char)('a' + random.nextInt(26));
				}
				dataUsed += new String(word).getBytes().length + 2; // gets the bytes of the word, and accounts for the new line.
				currentBytes += new String(word).getBytes().length + 2; // used for the loading bar
				writer.println(new String(word));

				if(currentBytes >= dataCap/20){
					currentBytes = 0;
					percent += 5;
					System.out.print(percent + "...");
				}
				if (dataUsed >= dataCap){
					break;
				}
			}
			writer.close();
			System.out.println("100%");
			System.out.println("Done!");
		} catch (IOException e) {
			// do something
		}
	}
}