package javalab;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * GenericsDemo features.
 *
 * @author Gall Anonim
 * @version 1.0
 *
 */
public class GenericsDemo {

    public static void main(String[] args) {

        // standard collection
        Vector vector = new Vector();
        vector.add(66);
        vector.add(13);
        // The compiler doesn't check the type of argument 
        vector.add("cat");
        int sum = 0;
        for (Object element : vector) {
            sum += (Integer) element;
        }
        System.out.println("Sum = " + sum);

        // Type-safe collection  
        Vector<Integer> safeVector = new Vector<Integer>();
        safeVector.add(66);
        safeVector.add(13);
        // The compiler checks the type of argument. Uncomment next line! 
        // safeVector.add("kot");
        for (int element : safeVector) {
            sum += element;
        }
        System.out.println("Sum = " + sum);

        // own generic type
        Box<String> numberBox1 = new Box<String>();
        NumberBox<Integer> numberBox2 = new NumberBox<Integer>();
        numberBox2.add(13);
        numberBox2.add(7);
        System.out.println("sum = " + numberBox2.sum());

//		 NumberBox<String> numberBox3 = new NumberBox<String>();
    }
}

class Box<T> {

    List<T> contents;
}

class NumberBox<N extends Number> {

    List<N> contents;

    NumberBox() {
        contents = new LinkedList<N>();
    }

    public void add(N obj) {
        contents.add(obj);
    }

    public N get(int index) {
        return contents.get(index);
    }

    public double sum() {
        double total = 0;
        Iterator<N> i = contents.iterator();
        while (i.hasNext()) {
            total += ((Integer) i.next()).doubleValue();
        }
        return total;
    }
}
