package BaiTap.Buoi3.Bai4.Ex3;

import BaiTap.Buoi3.Bai4.Ex4.B;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "banana";
        int length = s.length();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                continue;
            }
            map.put(s.charAt(i), 1);
        }


        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
