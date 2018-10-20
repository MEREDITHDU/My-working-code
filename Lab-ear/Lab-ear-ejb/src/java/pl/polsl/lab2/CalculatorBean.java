package pl.polsl.lab2;

import javax.ejb.Stateless;
import pl.polsl.lab2.CalculatorBeanRemote;

@Stateless(mappedName="calculator")
public class CalculatorBean implements CalculatorBeanRemote {

    @Override
    public int add(int arg1,int arg2) {
        return arg1+arg2;
    }


    
}
