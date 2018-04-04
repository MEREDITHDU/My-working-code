package sort;

import java.util.ArrayList;

/**
 * Sort words with Radix Sort
 *
 * O(nk)
 *
 * Running this sort on a .001 GB file took 0.144 seconds
 *
 * @author QilinDu
 * @version 05-05-2018
 */
public class RadixSort {

    /*
     * Radix sort an array of Strings
     * Assume all are all ASCII
     * Assume all have length bounded by maxLen
     */

    /**
     * @brief Sort based on radix sort
     * @param wordsToSort Array needing sorted
     * @param maxLen length of the longest word
     */
    public static void sort( String [ ] wordsToSort, int maxLen )
    {
        System.out.println("Radix Sorting Words...");
        long start = System.currentTimeMillis(); //when we started

        final int BUCKETS = 256; // the highest possible value for an ascii character

        @SuppressWarnings("unchecked")
		ArrayList<String>[ ] wordsByLength = new ArrayList[ maxLen + 1 ]; //an array of String type Array Lists
        @SuppressWarnings("unchecked")
		ArrayList<String> [ ] buckets = new ArrayList[ BUCKETS ]; //an array of String type Array Lists

        for( int i = 0; i < wordsByLength.length; i++ ) //insert an array list for every int up to the max word size
            wordsByLength[ i ] = new ArrayList<>( );

        for( int i = 0; i < BUCKETS; i++ )  //insert an array list for every int up to the max size of an ascii character
            buckets[ i ] = new ArrayList<>( );

        for( String s : wordsToSort ) //for every word insert it into the array list that corresponds to its length
            wordsByLength[ s.length( ) ].add( s );

        int idx = 0;
        for( ArrayList<String> wordList : wordsByLength ) //put the words back into the array by ascending length
            for( String s : wordList )
                wordsToSort[ idx++ ] = s;

        int startingIndex = wordsToSort.length;
        for( int pos = maxLen - 1; pos >= 0; pos-- ) //start at the longest word and work to the front                 //from the last character of the longest word
        {
            startingIndex -= wordsByLength[ pos + 1 ].size( ); //how many words at each index of that length, this is how many we are working on
            //this is inclusive, so in the beginning we just do the longest and work to the end, but each run we work a length before the longest all the
            //way to the end this way this is how they end up all sorted

            for( int i = startingIndex; i < wordsToSort.length; i++ ) //work on the subset of chosen words
                buckets[ wordsToSort[ i ].charAt( pos ) ].add( wordsToSort[ i ] ); //from the first word that we are working on, based on a letter's binary representation insert the word there

            idx = startingIndex;
            for( ArrayList<String> thisBucket : buckets ) //put the words back in the array based on that sorted letter
            {
                for( String s : thisBucket )
                    wordsToSort[ idx++ ] = s;

                thisBucket.clear( );
            }
        }
        long end = System.currentTimeMillis(); //when we ended
        double totalTime = (end - start)/1000.00; //total time in seconds
        System.out.println("Total Seconds: " + totalTime);

    }
}