package javalab;

import javalab.Description;
import java.lang.reflect.*;
import java.util.Vector;

/**
 * Annotation feature. 
 * 
 * @author Gall Anonim
 * @version 1.0
 *
 */
public class AnnotationsDemo {

    public static void main(String[] args) {
        Sub s = new Sub();
        
        // deprecated method
        s.met2();

        // read your own annotation
        try {
            Class c = Class.forName("pl.polsl.java.lab2.Sub");
            AnnotatedElement element = c.getMethod("met3");
            if (element.isAnnotationPresent(Description.class)) {
                Description desc = element.getAnnotation(Description.class);
                String who = desc.author();
                System.out.println("Author of method is " + who);
                String item = desc.item();
                System.out.println("Item: " + item);
                Description.Importance importance = desc.importance();
                System.out.println("Importance: " + importance);
            } else {
                System.out.println("No annotation!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

// Use of standard annotation
class Base {
    void met() {
    }
}

class Sub extends Base {

    Vector vector;

    Sub() {
        vector = new Vector();
    }

    @Override
    public void met() {
    }

    @Deprecated
    void met2() {
    }

    @SuppressWarnings("unchecked")
    public void collect(Object obj) {
        vector.add(obj);
    }

    @Description(importance = Description.Importance.LOW, item = "Something ...", author = "NOWAK")
    public void met3() {
    }
}
