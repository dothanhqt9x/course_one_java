package exceptionHandling;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Bai1 {

    public static double divide(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;

        while (true) {
            try {
                System.out.print("Nhập số thực thứ nhất: ");
                num1 = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập một số thực!");
                scanner.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Nhập số thực thứ hai: ");
                num2 = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập một số thực!");
                scanner.nextLine();
            }
        }

        try {
            double result = divide(num1, num2);
            System.out.println("Kết quả phép chia: " + num1 + " / " + num2 + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            scanner.close();
            return;
        }

        scanner.close();
    }
}