import java.util.Scanner;

class Example<T extends Number, S> {
    public T number;

    Example(T number) {
        this.number = number;
    }

    boolean isEqual(Example<?, S> e) {
        if (number.doubleValue() == e.number.doubleValue()) {
            return true;
        }
        return false;
    }
}

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public void ham(){

    }

    public static void main(String[] args) {

        Example<Integer, String> a = new Example<>(10);
        Example<Double, String> b = new Example<>(10.0);

        System.out.println("a == b ? "+ a.isEqual(b));


    }
}