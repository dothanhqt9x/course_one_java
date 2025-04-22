package collections;

import java.util.List;

public class Utility<T> {

    public static <T> int returnLength(List<T> list) {
        return list.size();
    }

    public static int returnAvg(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum / list.size();
    }


//    public static int returnAvgUsingObj(List<Object> list) {
//        ArrayList any = new ArrayList<T>();
//    }

}
