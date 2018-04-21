package javalab;


/**
 * EnumerationDemo class.
 * 
 * @author Gall Anonim
 * @version 1.0
 *
 */
public class EnumerationDemo {

    enum Operation {

        PLUS, MINUS, TIMES, DIVIDE;

        double eval(double x, double y) {
            switch (this) {
                case PLUS:
                    return x + y;
                case MINUS:
                    return x - y;
                case TIMES:
                    return x * y;
                case DIVIDE:
                    return x / y;
                default:
                    System.err.println("Unknown operation: " + this);
                    return 0;
            }
        }
    }

    public static void main(String args[]) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (Operation op : Operation.values()) {
            System.out.printf("%.2f %s %.2f = %.2f%n", x, op, y, op.eval(x, y));
        }

    }
}
