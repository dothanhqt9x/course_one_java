package thuchanhb10;

import java.util.ArrayList;
import java.util.List;

public class Exercise1 {

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        ArrayList<Double> doubleList = new ArrayList<>(List.of(1.0, 2.0));
        ArrayList<Boolean> boolList = new ArrayList<>(List.of(true, false, true));
        ArrayList<String> stringList = new ArrayList<>(List.of("st1", "st2"));

        System.out.println(intList);
        System.out.println(doubleList);
        System.out.println(boolList);
        System.out.println(stringList);
    }
}
