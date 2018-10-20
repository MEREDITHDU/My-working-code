package labclient;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import pl.polsl.lab2.CalculatorBeanRemote;
import pl.polsl.lab2.SummationBean1Remote;

public class Main {
    
//system.out.println shortcut Sout+tab;
    //@EJB
    private static CalculatorBeanRemote calculatorBean;

    private static SummationBean1Remote sum1;
    private static SummationBean2Remote sum2;
    private static SummationBean3Remote sum3;
    
    
    public static void main(String[] args) throws NamingException {
      //  System.out.println("1:"+calculatorBean.add(1, 5));
        InitialContext ctx =new InitialContext();
        sum1= (SummationBean1Remote) ctx.lookup("java:global/Lab-ear/Lab-ear-ejb/SummationBean1!/pl.polsl.lab2/SummationBean1Remote");
        sum2= (SummationBean2Remote) ctx.lookup("java:global/Lab-ear/Lab-ear-ejb/SummationBean1!/pl.polsl.lab2/SummationBean2Remote");
        sum3= (SummationBean3Remote) ctx.lookup("java:global/Lab-ear/Lab-ear-ejb/SummationBean1!/pl.polsl.lab2/SummationBean3Remote");
        
        System.out.println("1a:"+sum1.add(1, 1));
        System.out.println("1b:"+sum1.add(1, 1));
        System.out.println("2a:"+sum2.add(2, 2));
        System.out.println("2b:"+sum2.add(2, 2));
        System.out.println("3a:"+sum3.add(3, 3));
        System.out.println("3b:"+sum3.add(3, 3));
       // System.out.println("2:"+calculatorBean.add(5,7));
       for (int i=0;i<10;i++){
           new Thread(new Runnable(){
               public void run(){
                   try {
                       sum1= (SummationBean1Remote) ctx.lookup("java:global/Lab-ear/Lab-ear-ejb/SummationBean1!/pl.polsl.lab2/SummationBean1Remote");
                       System.out.println("1a:"+Thread.currentThread().getName()+sum1.add(1, 1));
                       System.out.println("1b:"+Thread.currentThread().getName()+sum1.add(1, 1));
                       sum1= (SummationBean1Remote) ctx.lookup("java:global/Lab-ear/Lab-ear-ejb/SummationBean1!/pl.polsl.lab2/SummationBean1Remote");
                       System.out.println("1c:"+Thread.currentThread().getName()+sum1.add(1, 1));
                       System.out.println("1d:"+Thread.currentThread().getName()+sum1.add(1, 1));
                       
                   } catch (NamingException ex) {
                       Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   System.out.println("1a:"+sum1.add(1, 1));
                   System.out.println("1b:"+sum1.add(1, 1));
                   try {
                       sum1= (SummationBean1Remote) ctx.lookup("java:global/Lab-ear/Lab-ear-ejb/SummationBean1!/pl.polsl.lab2/SummationBean1Remote");
                   } catch (NamingException ex) {
                       Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   System.out.println("1a:"+sum1.add(1, 1));
                   System.out.println("1b:"+sum1.add(1, 1));
        
               }
           }).start();
       }
       
       
        sum1= (SummationBean1Remote) ctx.lookup("java:global/Lab-ear/Lab-ear-ejb/SummationBean1!/pl.polsl.lab2/SummationBean1Remote");
        sum2= (SummationBean2Remote) ctx.lookup("java:global/Lab-ear/Lab-ear-ejb/SummationBean1!/pl.polsl.lab2/SummationBean2Remote");
        sum3= (SummationBean3Remote) ctx.lookup("java:global/Lab-ear/Lab-ear-ejb/SummationBean1!/pl.polsl.lab2/ SummationBean3Remote");
        
       System.out.println("1c:"+sum1.add(1, 1));
       System.out.println("1d:"+sum1.add(1, 1));
       System.out.println("2c:"+sum2.add(1, 1));
       System.out.println("2d:"+sum2.add(1, 1));
       System.out.println("3c:"+sum3.add(1, 1));
       System.out.println("3d:"+sum3.add(1, 1));
    }
    
}
