package BaiTap.Buoi8.BaiTap.Bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
        }

        for (int item : arrayList) {
            System.out.println(item);
        }
    }
}
