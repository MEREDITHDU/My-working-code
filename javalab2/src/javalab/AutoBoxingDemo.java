package javalab;


/**
 * Demonstration of autoboxing. 
 * 
 * @author Gall Anonim
 * @version 1.0
 *
 */
public class AutoBoxingDemo {

    public static void main(String[] args) {

        Integer obj = 17; // box, the assignment
        obj++; // unpacking, increment, packaging
        obj += 3; // unpacking, adding, packaging

        // summing the simple types and objects
        Integer a = new Integer(12);
        int b = 7;
        Integer c1 = a + b;
        int c2 = a + b;
        System.out.println("" + c1 + ", " + c2);

        fun(4); // package-match method call arguments
    }

    public static void fun(Integer arg) {
        System.out.println(arg);
    }
}
