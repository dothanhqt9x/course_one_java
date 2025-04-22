package BaiTap.Buoi8.BaiTap.Bai1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1.2f);
        arrayList.add(true);
        arrayList.add("Hello an em");

        for (Object item : arrayList) {
            System.out.println(item);
        }
    }
}
