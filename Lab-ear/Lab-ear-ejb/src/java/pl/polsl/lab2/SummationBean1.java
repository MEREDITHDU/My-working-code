
package pl.polsl.lab2;

import javax.ejb.Stateless;


@Stateless
public class SummationBean1 implements SummationBean1Remote {
    private int total=0;

    @Override
    public int add(int arg1, int arg2) {
        total+=arg1+arg2;
        return total;
    }
    

}
