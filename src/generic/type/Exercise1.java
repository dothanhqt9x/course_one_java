package generic.type;

import java.util.ArrayList;
import java.util.List;

public class Exercise1 {

    public void Exercise1() {
        System.out.println("Exercise 1");
        List<Object> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(14.127387970792105);
        arrayList.add(true);
        arrayList.add("Hello");

        for (Object obj : arrayList) {
            System.out.println(obj);
        }
    }
}
