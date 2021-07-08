import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class product {
    int id;
    String name;
    float price;
    public product(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class testMyinterface {

    public static void main(String[]args){
        MyTest mt = (int a) -> System.out.println("Hello World"+" "+ a);
        mt.mytest(2);
        Mytest2 mt2= ()-> System.out.println(Mytest2.class);
        mt2.mytest2();

        //List<String> productlist = Arrays.asList("first","second");

        List<product> list = new ArrayList<product>();
        list.add(new product(1,"HP Laptop",25000f));
        list.add(new product(3,"Keyboard",300f));
        list.add(new product(2,"Dell Mouse",150f));

        list.stream()
                .filter(p->p.price>3000f)
                .map(pm->pm.price)
                .forEach(System.out::println);

        List<Float> pricelist= list.stream()
                                        .filter(p->p.price>3000f)
                                        .map(pm->pm.price)
                                        .collect(Collectors.toList());
        System.out.println(pricelist);
    }

    @FunctionalInterface
    public interface MyTest{
        void mytest(int a);
    }

    public interface Mytest2{
        void mytest2();
    }
}
