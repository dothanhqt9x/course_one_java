package BaiTap.Buoi5.Bai1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static double hamChia(int a, int b) {
        return (double) a / b;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập số đầu tiên: ");
            int number1 = scanner.nextInt();
            System.out.print("Nhập số thứ 2: ");
            int number2 = scanner.nextInt();
            hamChia(number1, number2);
        } catch (InputMismatchException | ArithmeticException e) {
            System.out.println("Lỗi nè " + e.getMessage());
        }

        System.out.println("Chạy tiếp nè ....");
    }


}
