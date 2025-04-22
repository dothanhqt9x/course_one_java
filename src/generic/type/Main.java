package generic.type;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        var examples = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        for (var element : examples) {
            try {
                System.out.println("////////////////////////////" + "Exercise" + element + "////////////////////////////");
                // Dynamically create class name
                String className = "generic.type.Exercise" + element;
                Class<?> clazz = Class.forName(className);

                // Create an instance of the class
                Object instance = clazz.getDeclaredConstructor().newInstance();

                // Call the constructor method (if it exists)
                clazz.getMethod("Exercise" + element).invoke(instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
