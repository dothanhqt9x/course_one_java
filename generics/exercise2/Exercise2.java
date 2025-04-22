package generics.exercise2;

import java.util.ArrayList;

public class Exercise2 {
    public static void main(String[] args) {
        ArrayList<Integer> myArr = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            myArr.add(i);
        }

        System.out.println("Các số trong ArrayList là:");

        for (Integer num : myArr) {
            System.out.print(num + " ");
        }
    }
}
