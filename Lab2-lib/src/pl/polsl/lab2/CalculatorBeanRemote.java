package pl.polsl.lab2;

import javax.ejb.Remote;

@Remote
public interface CalculatorBeanRemote {

    int add(int a, int b);
    
}
