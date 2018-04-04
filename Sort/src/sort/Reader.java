package sort;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Read in the words
 *
 * @author QilinDu
 * @version 02-04-2018
 */
public class Reader {

    int longestWord = 0;

    /**
     * Read words from a file
     * @return an array of words
     */
    public String[] readWords(){
        long start = System.currentTimeMillis();

        double gigabyte = 1073741824;
        long currentBits = 0;
        int percent = 0;

        ArrayList<String> words = new ArrayList<>();
        try {
            System.out.println("loading words...");
            FileInputStream fileInputStream = new FileInputStream("words.txt");
            long fileSize = fileInputStream.getChannel().size();
            Scanner scanner = new Scanner(fileInputStream);
//-------------------------------------------------------------------------------------
            while(scanner.hasNextLine()){
                String word = scanner.nextLine();
                words.add(word);

                if (word.length() > longestWord) longestWord = word.length();

                currentBits += word.getBytes().length;
                if(currentBits >= fileSize/20){
                    currentBits = 0;
                    percent += 5;
                    System.out.print(percent + "...");
                }
            }
// ----------------------------------------------------------------------------------------
            scanner.close();
            
            Double gigsProcessed = fileSize/gigabyte;
            long end = System.currentTimeMillis();
            double seconds = (end - start)/1000.00;
            System.out.println("100%");
            System.out.println("Done! Processed " + gigsProcessed + " gigabytes in " + seconds + " seconds.");

        }catch (Exception e){
            //ignore
        }
        return words.toArray(new String[words.size()]);
    }

    public int getLongestWord(){
        return longestWord;
    }
}