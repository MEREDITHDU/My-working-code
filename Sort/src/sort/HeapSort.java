package sort;

import java.util.PriorityQueue;

/**
 * Use java heap sort to sort the words
 *
 * O(n log(n))
 *
 * Running this sort on a .001 GB file took 0.098 seconds
 *
 * @author brandon
 * @version 3/2/17
 */
public class HeapSort {

    /**
     * @brief Use built in java heap sort to sort an array
     * @param wordsToSort Array needing to be sorted
     */
    public void sort(String[] wordsToSort){

        System.out.println("Heap Sorting Words...");
        long start = System.currentTimeMillis(); //when we started

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(); //make priority queue

        for (String s : wordsToSort){ //add words to the queue
            priorityQueue.add(s);
        }

        int i = 0; //used to traverse the array
        while (priorityQueue.size() != 0){ //get the elements out of the queue
            wordsToSort[i] = priorityQueue.remove();
            i++;
        }

        long end = System.currentTimeMillis();
        double totalTime = (end - start)/1000.00;
        System.out.println("Total Seconds: " + totalTime);

    }
}