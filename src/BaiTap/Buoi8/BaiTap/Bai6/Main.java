package BaiTap.Buoi8.BaiTap.Bai6;

public class Main {
    public static void main(String[] args) {
        Calculator<Float> calculator = new Calculator<>(new Float[]{1.2f, 2f, 3f});
        calculator.lengthArray();
        calculator.avgArray();

    }
}
