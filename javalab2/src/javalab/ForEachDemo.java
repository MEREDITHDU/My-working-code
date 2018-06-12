package javalab;

import java.util.*;

/**
 * ForEachDemo feature.
 *
 * @author Gall Anonim
 * @version 1.0
 *
 */
public class ForEachDemo {

    public static void main(String[] args) {
        // Array iteration
        int[] tab = {2, 3, 5, 1, 7, 3, 3, 7, 5, 7};
        int sum = 0;
        for (int element : tab) {
            sum += element;
        }
        System.out.println(sum);

        // iterating through the collection
        Vector<String> vector = new Vector<String>();
        vector.add("cat");
        vector.add("dog");
        vector.add("mouse");
        for (String element : vector) {
            System.out.print(element + ", ");
        }
        System.out.println();

        // iterating through the collection
        TreeSet<String> tree = new TreeSet<String>();
        tree.add("cat");
        tree.add("dog");
        tree.add("mouse");
        for (String element : vector) {
            System.out.print(element + ", ");
        }
        System.out.println();

        // iterating through the collection
        Person worker = new Person("Jan", "Nowak", 29, 2222.2f);
        for (String atrybut : worker) {
            System.out.print(atrybut + ", ");
        }
        System.out.println();

    }
}

class Person implements Iterable<String>, Iterator<String> {

    String name, surname;
    int age;
    float salary;
    int i, index;

    public Person(String name, String surname, int age, float salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
    }

    public Iterator<String> iterator() {
        index = 0;
        return this;
    }

    public boolean hasNext() {
        if (index >= 4) {
            return false;
        } else {
            return true;
        }
    }

    public String next() {
        switch (index++) {
            case 0:
                return name;
            case 1:
                return surname;
            case 2:
                return "" + age;
            case 3:
                return "" + salary;
            default:
                return null;
        }
    }

    public void remove() {
    }
}
