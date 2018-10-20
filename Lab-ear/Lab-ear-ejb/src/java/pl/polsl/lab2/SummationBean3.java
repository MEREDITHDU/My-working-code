
package pl.polsl.lab2;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;


@Singleton
@LocalBean
public class SummationBean3 {
        private int total=0;

public int add(int arg1, int arg2) {
        total+=arg1+arg2;
        return total;
    }
}
