package thuchanhb9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Bai1b9 {
    public static void main(String[] args) {
        String filepath = "./src/thuchanhb9/bai1.txt";

        ArrayList<String> words = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] list = line.split(" ");
                for (String word : list) {
                    word = word.trim();
                    if (!word.isEmpty()) {
                        words.add(word);
                        uniqueWords.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        // Loại bỏ từ trùng để không in lại nhiều lần


        // Đếm và in tần suất mỗi từ
        for (String word : uniqueWords) {
            int frequency = Collections.frequency(words, word);
            System.out.println(word + ": " + frequency);
        }
    }
}
