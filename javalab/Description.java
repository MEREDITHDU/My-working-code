package javalab;


import java.lang.annotation.*;

/**
 * Description interface. The annotation consists of the internal enumeration
 * and three attributes.
 *
 * @author Gall Anonim
 * @version 1.0
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {

    public enum Importance {

        HIGH, AVERAGE, LOW
    };

    Importance importance() default Importance.AVERAGE;

    String item();

    String author();
}
