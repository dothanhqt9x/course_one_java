package generic;

import java.util.ArrayList;
import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(1);
        list.add(1.5);
        list.add(true);
        list.add("test");

        System.out.println(list);
    }
}
