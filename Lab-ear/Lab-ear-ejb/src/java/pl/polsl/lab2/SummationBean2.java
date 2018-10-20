
package pl.polsl.lab2;

import javax.ejb.Stateful;
import javax.ejb.LocalBean;

@Stateful
@LocalBean
public class SummationBean2 {
        private int total=0;
    public int add(int arg1, int arg2) {
        total+=arg1+arg2;
        return total;
    }

}
