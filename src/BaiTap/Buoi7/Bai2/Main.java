package BaiTap.Buoi7.Bai2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\nguye\\OneDrive\\Desktop\\Learning\\src\\BaiTap\\Buoi7\\Baitap\\email.txt");

        FileReader fileReader = new FileReader(file);

        BufferedReader reader = new BufferedReader(fileReader);

        String line;

        Map<String, Integer> hashMap = new HashMap<>();

        while ((line = reader.readLine()) != null) {
            Integer quantity = hashMap.get(line);
            if (quantity == null) {
                quantity = 1;
                hashMap.put(line, quantity);
                continue;
            }
            hashMap.put(line, quantity + 1);
        }


        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("Email: " + entry.getKey());
            System.out.println("Số lượng: " + entry.getValue());
            System.out.println("\n---------------------------\n");
        }
    }
}
