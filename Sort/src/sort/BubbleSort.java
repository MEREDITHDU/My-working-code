package sort;


/**
 * Sort words via bubble sort
 * O(n^2)
 *
 * Running this sort on a .001 GB file took 4.1 minutes
 * A .01 and .1 GB file was tried and took over 20 minutes and still didn't complete
 *
 * @author QilinDu
 * @version 02-04-2018
 */
public class BubbleSort {

    /**
     * @brief Perform a bubble sort on a given array
     * @param wordsToSort the array of unsorted words
     */
    public void sort(String[] wordsToSort) {
        System.out.println("Bubble Soring Words...");
        long start = System.currentTimeMillis(); 

        boolean done = false;  
        String temp;

        while (!done) {
            done = true;
            for ( int j = 0;  j < wordsToSort.length - 1;  j++ ) {
                if ( wordsToSort [ j ].compareToIgnoreCase( wordsToSort [ j+1 ] ) > 0 ) { 
                    temp = wordsToSort [ j ];
                    wordsToSort [ j ] = wordsToSort [ j+1];     
                    wordsToSort [ j+1] = temp;
                    done = false;
                }
            }
        }

        long end = System.currentTimeMillis(); 
        double totalTime = (end - start)/1000.00; 
        System.out.println("Total Seconds: " + totalTime);

    }
}