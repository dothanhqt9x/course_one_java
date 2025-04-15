package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class test1 {
    List<Integer> list1 = new ArrayList<Integer>();
    List<String> list2 = new LinkedList<>();
    List<Integer> list3 = new Stack<>();

    public void printList() {
        list1.add(1);
        list1.add(2);
        list1.add(null);
        list1.add(4);

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }

    public void printList2() {
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");

        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
    }

    public void printList3() {
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);

        for (Integer num : list3) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        test1 t1 = new test1();
        t1.printList();
        t1.printList2();
        t1.printList3();
    }

}
