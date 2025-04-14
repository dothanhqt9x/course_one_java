package BaiTap.Buoi6.Hoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);

        list.removeAll(list);

        System.out.println("-----------------------");


        System.out.println("-----------------------");

        System.out.println(list.getFirst());
        System.out.println(list.get(1));

        System.out.println("-----------------------");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("-----------------------");

        for (int item : list) {
            System.out.println(item);
        }

    }
}
