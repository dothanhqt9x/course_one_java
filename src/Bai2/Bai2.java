package Bai2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bai2 {
    public static void main(String[] args) {
        Map<String, Integer> eCount = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\duclu\\" +
                    "IdeaProjects\\Javaa\\src\\Bai2\\input.txt"));
            for (String line: lines) {
                String email = line.trim();
                if (!email.isEmpty()) {
                    eCount.put(email, eCount.getOrDefault(email, 0) + 1);
                }
            }

            for (Map.Entry<String, Integer> entry : eCount.entrySet()) {
                System.out.printf("%-10s\t%d%n", entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file " + e.getMessage());
        }
    }
}
