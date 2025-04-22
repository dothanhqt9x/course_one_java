package generics;

public class ArrayUtils {

    public static <T> int countElements(T[] array) {
        if (array == null) {
            return 0;
        }
        return array.length;
    }

    public static <T extends Number> double average(T[] array) {
        if (array == null || array.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (T num : array) {
            sum += num.doubleValue();
        }

        return sum / array.length;
    }
}

