package BaiTap.Buoi8.Hoc;

public class Main {
    public static  int QuantityItemArray(int[] arr) {
        return arr.length;
    };

    public static <T> double AvgItemArray(int[] arr) {
        int sum = 0;
        for (int item : arr) {
            sum = (sum + item);
        }

        return (double) sum/ QuantityItemArray(arr);
    };

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        double avg = Main.AvgItemArray(array);
        System.out.println(avg);
    }
}
