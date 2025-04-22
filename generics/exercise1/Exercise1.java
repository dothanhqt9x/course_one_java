package generics.exercise1;

import java.util.ArrayList;

public class Exercise1 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(3);
        list.add(3.14);
        list.add(true);
        list.add("Hello World");

        System.out.println("Các giá trị trong ArrayList:");
        System.out.println("Số nguyên: " + list.get(0));
        System.out.println("Số thực: " + list.get(1));
        System.out.println("Boolean: " + list.get(2));
        System.out.println("Xâu ký tự: " + list.get(3));
    }
}