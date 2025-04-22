package collection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class EmailCount {
    private static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public static void main(String[] args) {
        String filePath = "E:\\K1-Java\\baitap1\\src\\collection\\inputBai2.txt";
        Map<String, Integer> emailCount = new HashMap<>();

        try  {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty() && isValidEmail(line)) {
                    emailCount.put(line, emailCount.getOrDefault(line, 0) + 1);
                }
            }

            System.out.println("Số lượng email bị lặp:");
            for (Map.Entry<String, Integer> entry : emailCount.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (Exception e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
