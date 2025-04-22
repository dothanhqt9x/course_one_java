package example.read.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadFile {

    private final ArrayList<String> chars = new ArrayList<>();

    public List<String> getChars() {
        return chars;
    }

    public void readFileBuffer(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                chars.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
