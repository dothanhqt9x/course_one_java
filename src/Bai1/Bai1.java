package Bai1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bai1 {
    public static void main(String[] args) {
        Map<String, Integer> wCount = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\duclu\\IdeaProjects\\Javaa\\src\\Bai1\\inputBai1.txt"));
//            System.out.println(lines);
            for (String line : lines) {
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();

                String []words = line.split("\\s+");

                for (String word:words) {
                    if (!word.isEmpty()){
                        wCount.put(word, wCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            System.out.println("Từ \t\t Số lần xuất hiện");
            for (Map.Entry<String, Integer> entry : wCount.entrySet()) {
                System.out.printf("%-10s\t%d%n", entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Không đọc được file " + e.getMessage());
        }
    }
}
