package sort;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Use binary search to find a word in a file
 * With help from http://www.cs.toronto.edu/~reid/search/bincode.html
 *
 * O(log(n))
 *
 * A 5GB text file took 17 minutes to search through
 *
 * @author QilinDu
 * @version 15-05-2018
 */
public class BinarySearch {


    /**
     * @brief Load a large text file .1Gb at a time and perform binary search on it
     * @param key the word wanting to be found
     */
    public void search(String key){
        long start = System.currentTimeMillis();

        double gigabyte = 1073741824;
        long currentBits = 0;
        long bitsProcessed = 0;
        long processabelChunk = 0;
        int percent = 0;

        ArrayList<String> words = new ArrayList<>();
        try {
            System.out.println("loading words...");
            FileInputStream fileInputStream = new FileInputStream("words.txt");
            long fileSize = fileInputStream.getChannel().size();
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
                
                scanner.close();
                
                processabelChunk += word.getBytes().length;
                if (processabelChunk >= 107374182.4 || !scanner.hasNextLine()) { //i can process .01 gig at a time

                    processabelChunk = 0; //reset for next round

                    String[] sortedWords = words.toArray(new String[words.size()]);
                    words.clear(); //clear and start on the next chunk

                    QuickSort quickSort = new QuickSort();
                    quickSort.sort(sortedWords);
                    if (binarySearch(sortedWords, key)){
                        System.out.println("Found");
                        break;
                    }
                    else System.out.println("not Found");

                    sortedWords = new String[0]; //clear the array
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

    /**
     * @brief Perform binary search on a given array and key
     * @param words the sorted array of words
     * @param key the word wanting to be found
     * @return True or False if the word was found or not
     */
    private boolean binarySearch(String[] words, String key) {

        int size = words.length;

        int low = 0; //lowest search index
        int high = size - 1; //highest search index

        while(high >= low) { //while we are looking between the two

            int middle = (low + high) / 2; //where we will split the array

            if(words[middle].compareToIgnoreCase(key) == 0) return true;

            if(words[middle].compareToIgnoreCase(key) < 0 ) low = middle + 1; //the key is bigger than the middle, look to the left

            if(words[middle].compareToIgnoreCase(key) > 0) high = middle - 1; //the key is smaller than the middle, look to the right

        }
        return false;
    }
}