package BaiTap.Buoi8.BaiTap.Bai6;

public class Calculator<T extends Number> {
    private final T[] arr;

    public Calculator(T[] arr) {
        this.arr = arr;
    }

    public int lengthArray() {
        return this.arr.length;
    }

    public double avgArray() {
        double sum = 0;
        for (int i = 0; i < lengthArray(); i++) {
            sum += (double) arr[i];
        }

        return sum / lengthArray();
    }
}
