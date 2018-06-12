package javalab;

import java.util.*;
// import of static class members!
import static java.util.Collections.*;

/**
 * This demo resents set of useful methods operating on collections.
 *
 * @author Gall Anonim
 * @version 1.0
 *
 */
public class CollectionsFeatureDemo {

    static Integer[] tab = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static Vector<Integer> v = new Vector<Integer>();

    public static void main(String args[]) {
        addAll(v, tab);
        System.out.println("init:      " + v);
        shuffle(v);
        System.out.println("shuffled:  " + v);
        sort(v);
        System.out.println("sorted:    " + v);
        rotate(v, 3);
        System.out.println("rotated:   " + v);
        sort(v);
        System.out.println("sorted:    " + v);
        reverse(v);
        System.out.println("reversed:  " + v);
        swap(v, 1, 2);
        System.out.println("swapped:   " + v);
        replaceAll(v, 0, 7);
        System.out.println("replaced:  " + v);
        System.out.println("Maximum:   " + max(v));
        System.out.println("Minimum:   " + min(v));
        System.out.println("element '7' exists " + frequency(v, 7) + " times");
    }
}
