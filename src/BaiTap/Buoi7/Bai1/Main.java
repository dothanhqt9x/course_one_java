package BaiTap.Buoi7.Bai1;

import BaiTap.Buoi3.Bai4.Ex4.A;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileInputStream fileInputStream = new FileInputStream(file);


        List<Character> list = new ArrayList();

        int c = fileInputStream.read();
        while (c != -1) {
            list.add((char) c); // giữ cả '\n'
            c = fileInputStream.read();
        }

        String string = "";
        Map<String, Integer> hashMap = new HashMap<>();
        for (Character item : list) {
            System.out.println(string);
            if (item == ' ') {
                Integer quantity = hashMap.get(string);
                if (quantity == null) {
                    quantity = 1;

                    hashMap.put(string, quantity);
                    string = "";
                } else {
                    hashMap.put(string, quantity + 1);
                    string = "";
                }

            } else {
                string = string + item;
            }
        }
//        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
//            System.out.print(entry.getKey() + " : ");
//            System.out.println(entry.getValue());
//        }

    }
}
