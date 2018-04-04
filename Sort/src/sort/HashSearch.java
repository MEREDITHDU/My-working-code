package sort;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Use Hash Set to search to find a word in a file
 *
 * O(1)
 *
 * A 5GB text file took 9 minutes to search through
 *
 * @author QilinDu
 * @version 1.0 10-04-2018
 */
public class HashSearch {

    public void search(String key){
        long start = System.currentTimeMillis();

        double gigabyte = 1073741824;
        long currentBits = 0;
        long bitsProcessed = 0;
        long processabelChunk = 0;
        int percent = 0;

        HashSet<String> words = new HashSet<>();
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
                bitsProcessed += word.getBytes().length;

                if(currentBits >= fileSize/20){ //percent processed
                    currentBits = 0;
                    percent += 5;
                    System.out.print(percent + "...");
                }

                processabelChunk += word.getBytes().length;
                if (processabelChunk >= 107374182.4 || !scanner.hasNextLine()) { //i can process .01 gig at a time

                    System.out.println("Processing a chunk...");
                    processabelChunk = 0; //reset for next round

                    if (words.contains(key)){
                        System.out.println("Found");
                        break;
                    }
                    else System.out.println("not Found");

                    words.clear(); //clear and start on the next chunk

                }

            }

            Double gigsProcessed = bitsProcessed/gigabyte;
            long end = System.currentTimeMillis();
            double seconds = (end - start)/1000.00;
            System.out.println("100%");
            System.out.println("Done! Processed " + gigsProcessed + " gigabytes in " + seconds + " seconds.");

        }catch (Exception e){
            //ignore
        }
    }
}