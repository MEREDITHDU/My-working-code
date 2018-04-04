package sort;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Find the words between two given words
 *
 * O(n)
 *
 * A 5GB text file took 8 minutes to search through
 *
 * @author QilinDu
 * @version 20-05-2018
 */
public class WordsBetween {

    /**
     * @brief Look through a file and find words between two given words
     * @param key1 starting word
     * @param key2 ending word
     */
    public void search(String key1, String key2){
        long start = System.currentTimeMillis();

        double gigabyte = 1073741824;
        long currentBits = 0;
        long processabelChunk = 0;
        int percent = 0;

        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> wordsBetween = new ArrayList<>();
        try {
            System.out.println("loading words...");
            FileInputStream fileInputStream = new FileInputStream("words.txt");
            long fileSize = fileInputStream.getChannel().size();
            @SuppressWarnings("resource")
			Scanner scanner = new Scanner(fileInputStream);

            while(scanner.hasNextLine()){
                String word = scanner.nextLine();
                words.add(word);

                currentBits += word.getBytes().length;

                if(currentBits >= fileSize/20){ //percent processed
                    currentBits = 0;
                    percent += 5;
                    System.out.print(percent + "...");
                }

                processabelChunk += word.getBytes().length;
                if (processabelChunk >= 107374182.4 || !scanner.hasNextLine()) { //i can process .1 gig at a time

                    System.out.println("Processing a chunk...");
                    processabelChunk = 0; //reset for next round

                    for (String s : words){
                                 //comes after                     comes before
                        if ( (s.compareToIgnoreCase(key1) > 0 && s.compareToIgnoreCase(key2) < 0) || (s.compareToIgnoreCase(key2) > 0 && s.compareToIgnoreCase(key1) < 0) ) wordsBetween.add(s);

                    }

                    words.clear(); //clear for next chunk
                }

            }

            Double gigsProcessed = fileSize/gigabyte;
            long end = System.currentTimeMillis();
            double seconds = (end - start)/1000.00;
            System.out.println("100%");
            System.out.println("Done! Processed " + gigsProcessed + " gigabytes in " + seconds + " seconds.");

        }catch (Exception e){
            //ignore
        }

    }
}