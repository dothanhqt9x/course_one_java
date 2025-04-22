package thuchanhb9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bai2b9 {
    public static void main(String[] args) {
        String filepath = "./src/thuchanhb9/bai2.txt";

        Map<String, Integer> emailsFrequency = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] list = line.split(" ");
                for (String mail : list) {
                    emailsFrequency.put(mail, emailsFrequency.getOrDefault(mail, 0)+1);
                }
            }

        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        System.out.println(emailsFrequency.entrySet());

    }

}
