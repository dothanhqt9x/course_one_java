package generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i =1; i<=10; i++){
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
