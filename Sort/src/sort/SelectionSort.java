package sort;

/**
 * Sort words with selection sort
 * O(n^2)
 *
 * Running this sort on a .001 GB file took 30 seconds
 *
 * @author QilinDu
 * @version 03-04-2018
 */
public class SelectionSort {

    /**
     * @brief Perform selection sort on words
     * @param wordsToSort Array to be sorted
     */
    public void sort (String[] wordsToSort) {
        System.out.println("Selection Sorting Words...");
        long start = System.currentTimeMillis();

        for (int i = 0 ; i < wordsToSort.length - 1 ; i++) { 

            String holder = wordsToSort [i]; 
            int position = i;
            for (int j = i ; j < wordsToSort.length ; j++) { 

                if (wordsToSort[j].compareToIgnoreCase(holder) < 0) { 
                    holder = wordsToSort[j]; 
                    position = j; 
                }

            }

            String temp = wordsToSort[i]; 
            wordsToSort[i] = wordsToSort[position]; 
            wordsToSort[position] = temp; 

        }

        long end = System.currentTimeMillis();
        double totalTime = (end - start)/1000.00;
        System.out.println("Total Seconds: " + totalTime);

    }
}