package sort;


/**
 * Sort words with merge sort
 *
 * O(n log(n))
 *
 * Running this sort on a .001 GB file took 0.079 seconds
 *
 * @author QilinDu
 * @version 05-05-2018
 */
public class MergeSort {

    /**
     * @brief Call merge sort
     * @param wordsToSort Array needing to be sorted
     */
    public void sort(String[] wordsToSort){
        System.out.println("Merge Soring Words...");
        long start = System.currentTimeMillis(); //when we started

        mergeSort(wordsToSort, new String[wordsToSort.length], 0, wordsToSort.length - 1);

        long end = System.currentTimeMillis(); //when we ended
        double totalTime = (end - start)/1000.00; //total time in seconds
        System.out.println("Total Seconds: " + totalTime);

    }

    /**
     * @brief Recursively call itself to sort the array
     * @param wordsToSort Array of words needing to be sorted
     * @param tempArray Temporary array to hold sorted elements in
     * @param leftStart Starting index of left half
     * @param rightEnd Ending point of the sorting position
     */
    private void mergeSort(String[] wordsToSort, String[] tempArray, int leftStart, int rightEnd){

        if (leftStart >= rightEnd) return; //hit the end of the array, done

        int middle = (leftStart + rightEnd) / 2; //the middle of the array

        mergeSort(wordsToSort, tempArray, leftStart, middle); //left half of the array
        mergeSort(wordsToSort, tempArray, middle + 1, rightEnd); //right half of the array
        merge(wordsToSort, tempArray,  leftStart, rightEnd); //merge the halves
    }

    /**
     * @brief Merge the two sorted halves
     * @param wordsToSort Array of words to be sorted
     * @param tempArray Temporary array to hold elements in
     * @param leftStart Starting index of left half
     * @param rightEnd Ending point of the sorting position
     */
    private void merge(String[] wordsToSort, String[] tempArray, int leftStart, int rightEnd){
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = (rightEnd - leftStart) + 1;

        int left = leftStart; //index for left half of array
        int right = rightStart; //index for right half of array
        int index = leftStart; //index for temp array

        while (left <= leftEnd && right <= rightEnd) { //while both arrays are inbound

            if (wordsToSort[left].compareToIgnoreCase(wordsToSort[right]) < 0){ //ascending order, left should be first
                tempArray[index] = wordsToSort[left];
                left++;
            }
            else { //ascending order, right should be first
                tempArray[index] = wordsToSort[right];
                right++;
            }
            index++;
        }

        System.arraycopy(wordsToSort, left, tempArray, index, (leftEnd - left) + 1); //copy remainder of left elements
        System.arraycopy(wordsToSort, right, tempArray, index, (rightEnd - right) + 1); //copy remainder of right elements
        System.arraycopy(tempArray, leftStart, wordsToSort, leftStart, size); //put the sorted temp in its place in the actual array


    }
}