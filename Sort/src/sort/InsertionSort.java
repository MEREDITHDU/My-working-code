package sort;


/**
 * Insertion sort for words
 * O(n^2)
 *
 * Running this sort on a .001 GB file took 34 seconds
 *
 * @author QilinDu
 * @version 03-04-2018
 */
public class InsertionSort {

    /**
     * @brief Use insertion sort to sort a given array
     * @param wordsToSort Array to be sorted
     */
    public void sort(String[] wordsToSort){
        System.out.println("Insertion Sorting Words...");

        long start = System.currentTimeMillis(); //when we started

        for (int i = 0; i < wordsToSort.length; i++){

            int j = i;

            while ((j > 0) && (wordsToSort[j].compareToIgnoreCase(wordsToSort[j-1]) < 0)){ 

                String temp = wordsToSort[j-1]; //bigger word
                wordsToSort[j-1] = wordsToSort[j]; //swap
                wordsToSort[j] = temp; //put the bigger in the other's spot
                j--;
            }
        }

        long end = System.currentTimeMillis(); 
        double totalTime = (end - start)/1000.00; 
        System.out.println("Total Seconds: " + totalTime);

    }
}