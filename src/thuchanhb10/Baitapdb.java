package thuchanhb10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baitapdb {

    public static int size(ArrayList arr) {
        return arr.size();
    }

    public static double avg(ArrayList<Number> arr) {
        double sum = 0.0;
        if (!arr.isEmpty()) {
            for (Number i : arr) {
                sum += i.doubleValue();
            }
            return sum / arr.size();
        }
        return sum;
    }


public static void main(String[] args) {
    ArrayList<Number> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 8, 9, 10));

    System.out.println(Baitapdb.avg(numbers));
}

}
