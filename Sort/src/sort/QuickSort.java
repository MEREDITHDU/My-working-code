package sort;


/**
 * Sort words with Quick Sort
 * With help from https://www.youtube.com/watch?v=SLauY6PpjW4
 *
 * Average: жи(n log(n)) Worst: O(n^2)
 *
 * Running this sort on a .001 GB file took 0.15 seconds
 *
 * @author brandon
 * @version 3/2/17
 */
public class QuickSort {

    /**
     * @brief Call quick sort
     * @param wordsToSort Array needing sorted
     */
    public void sort(String[] wordsToSort){
        System.out.println("Quick Sorting Words...");
        long start = System.currentTimeMillis(); //when we started

        quickSort(wordsToSort, 0, wordsToSort.length - 1);

        long end = System.currentTimeMillis(); //when we ended
        double totalTime = (end - start)/1000.00; //total time in seconds
        System.out.println("Total Seconds: " + totalTime);

    }

    /**
     * @brief Recursively call itself to sort the words
     * @param wordsToSort Array needing sorted
     * @param left left index
     * @param right right index
     */
    private void quickSort(String[] wordsToSort, int left, int right){

        if (left >= right) return; //at the end of the array

        String pivot = wordsToSort[((left + right) / 2)];
        int index = partition(wordsToSort, left, right, pivot);
        quickSort(wordsToSort, left, index - 1);
        quickSort(wordsToSort, index, right);
    }

    /**
     * @brief partition the array and sort based on a pivot point
     * @param wordsToSort Array needing sorted
     * @param left left index
     * @param right right index
     * @param pivot the point sorting around
     * @return returns a new left index
     */
    private int partition(String[] wordsToSort, int left, int right, String pivot){

        while(left <= right){
            while(wordsToSort[left].compareToIgnoreCase(pivot) < 0) { //its in the right spot
                left++;
            }
            while(wordsToSort[right].compareToIgnoreCase(pivot) > 0) { //its in the right spot
                right--;
            }

            if (left <= right) { //a swap is needed
                String temp = wordsToSort[left];
                wordsToSort[left] = wordsToSort[right];
                wordsToSort[right] = temp;

                left++;
                right--;
            }
        }
        return left;
    }
}