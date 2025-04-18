package example_read_file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountChar {

    private CountChar() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> countCharWithCollection(List<String> chars) {
        List<String> listWord = new ArrayList<>();

        for (String line : chars) {
            String[] words = line.split(" ");
            for (String word : words) {
                var lowerWord = word.toLowerCase();
                if (!listWord.contains(lowerWord)) {
                    listWord.add(lowerWord);
                    listWord.add("1");
                } else {
                    int index = listWord.indexOf(lowerWord);
                    int currentVal = Integer.parseInt(listWord.get(index + 1));
                    listWord.set(index + 1, String.valueOf(currentVal + 1));
                }
            }
        }
        var result = new ArrayList<String>();
        for (int i = 0; i < listWord.size(); i += 2) {
            result.add(listWord.get(i) + ": " + listWord.get(i + 1));

        }

        return result;
    }

    public static List<String> countCharWithMap(List<String> chars) {
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String line : chars) {
            String[] words = line.split(" ");
            for (String word : words) {
                wordCounts.put(word.toLowerCase(), wordCounts.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            result.add(entry.getKey() + ": " + entry.getValue());
        }
        return result;
    }

}