package sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Main Class.
 *
 * @author QilinDu
 * @version 03-04-2018
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException{

        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int choice;
        String[] words = new String[0];
        String[] temp;
        boolean done = false;
        Reader reader = new Reader(); //referenced here so that it can be used by all

        while (!done){
            System.out.println("How would you like to proceed?\n" +
                    "1. Find the word file\n" +
                    "2. Load the words from the file\n" +
                    "3. Bubble Sort\n" +
                    "4. Selection Sort\n" +
                    "5. Insertion Sort\n" +
                    "6. Merge Sort\n" +
                    "7. Quick Sort\n" +
                    "8. Heap Sort\n" +
                    "9: Raddix Sort\n" +
                    "10. Binary Search\n" +
                    "11: Find a Word Between\n" +
                    "12. Hash Search\n" +
                    "13. Exit");
            System.out.print("Make a selection:> ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                choice = 77;
            }
            switch (choice) {
                case 1: //Generate file
                    System.out.println();
                    FileInputStream in = new FileInputStream("D:\\BaiduYunDownload\\Download\\20k.txt");
                    System.out.println();
                    try {
                    in.close();
                    }catch(Exception e) {
                    	choice=77;
                    }
                    break;
                case 2: //Read in the file
                    System.out.println();
                    words = reader.readWords();
                    System.out.println();
                    break;
                case 3: //Bubble Sort the file
                    System.out.println();
                    temp = Arrays.copyOf(words, words.length);
                    BubbleSort bubbleSort = new BubbleSort();
                    bubbleSort.sort(temp);
                    System.out.println();
                    break;
                case 4: //Selection Sort
                    System.out.println();
                    temp = Arrays.copyOf(words, words.length);
                    SelectionSort selectionSort = new SelectionSort();
                    selectionSort.sort(temp);
                    System.out.println();
                    break;
                case 5: //Insertion Sort
                    System.out.println();
                    temp = Arrays.copyOf(words, words.length);
                    InsertionSort insertionSort = new InsertionSort();
                    insertionSort.sort(temp);
                    System.out.println();
                    break;
                case 6: //Merge Sort
                    System.out.println();
                    temp = Arrays.copyOf(words, words.length);
                    MergeSort mergeSort = new MergeSort();
                    mergeSort.sort(temp);
                    System.out.println();
                    break;
                case 7: //Quick Sort
                    System.out.println();
                    temp = Arrays.copyOf(words, words.length);
                    QuickSort quickSort = new QuickSort();
                    quickSort.sort(temp);
                    System.out.println();
                    break;
                case 8: //Heap Sort
                    System.out.println();
                    temp = Arrays.copyOf(words, words.length);
                    HeapSort heapSort = new HeapSort();
                    heapSort.sort(temp);
                    System.out.println();
                    break;
                case 9: //Raddix Sort
                    System.out.println();
                    temp = Arrays.copyOf(words, words.length);
                    RadixSort.sort(temp, reader.getLongestWord());
                    System.out.println();
                    break;
                case 10: //Binary Search
                    System.out.println();
                    System.out.println("Enter a word to find: ");
                    try {
                        BinarySearch binarySearch = new BinarySearch();
                        binarySearch.search(scanner.nextLine());
                    }
                    catch (Exception e){
                        System.out.println("That wasn't a word!");
                    }
                    System.out.println();
                    break;
                case 11: //Find a Word Between
                    System.out.println();
                    try {
                        System.out.println("Word 1: ");
                        String key1 = scanner.nextLine();
                        System.out.println("Words 2: ");
                        String key2 = scanner.nextLine();
                        WordsBetween wordsBetween = new WordsBetween();
                        wordsBetween.search(key1, key2);
                    }
                    catch (Exception e){
                        System.out.println("Something wen't wrong");
                    }
                    break;
                case 12: //Hash Search
                    System.out.println();
                    System.out.println("Enter a word to find: ");
                    try {
                        HashSearch hashSearch = new HashSearch();
                        hashSearch.search(scanner.nextLine());
                    }
                    catch (Exception e){
                        System.out.println("That wasn't a word!");
                    }
                    System.out.println();
                    break;
                case 13:
                    done = true;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }


}