package Generic;

import java.util.ArrayList;

public class Exercise1 {
    public static void main(String[] args) {
        ArrayList<Integer> integerGeneric = new ArrayList<>();
        ArrayList<Double> doubleGeneric = new ArrayList<>();
        ArrayList<Boolean> booleanGeneric = new ArrayList<>();
        ArrayList<String> stringGeneric = new ArrayList<>();

        integerGeneric.add(1);
        doubleGeneric.add(1.1);
        booleanGeneric.add(true);
        stringGeneric.add("AAAAA");

        System.out.println("Số nguyên: " + integerGeneric.get(0));
        System.out.println("Số thực: " + doubleGeneric.get(0));
        System.out.println("Boolean: " + booleanGeneric.get(0));
        System.out.println("Xâu ký tự: " + stringGeneric.get(0));
    }
}
