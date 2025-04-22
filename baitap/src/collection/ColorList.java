package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ColorList {
    public static void main(String[] args) {

        String[] colors = {"Red", "Blue", "Green"};
        String[] colors2 = {"Yellow", "Purple", "Orange"};

        List<String> list = new ArrayList<>(Arrays.asList(colors));
        List<String> list2 = new ArrayList<>(Arrays.asList(colors2));

        list.addAll(list2);
        System.out.println("List sau khi thêm list2:");
        System.out.println("list: " + list);
        list2.clear();

        System.out.println("List sau khi làm rỗng list2:");
        System.out.println("list: " + list);
        System.out.println("list2: " + list2);

        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).toUpperCase());
        }
        System.out.println("\nList sau khi chuyển thành in hoa:");
        System.out.println(list);

        if (list.size() >= 6) {
            list.subList(3, 6).clear(); // Xóa từ index 3 đến 5
        }

        System.out.println("\nList sau khi xóa các phần tử từ thứ 4 đến thứ 6:");
        System.out.println(list);

        Collections.reverse(list);
        System.out.println("\nList sau khi đảo ngược:");
        System.out.println(list);
    }
}
