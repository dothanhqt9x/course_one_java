package exception;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số thực thứ nhất: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Nhập số thực thứ hai: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            double result = divide(num1, num2);
            System.out.println("Kết quả phép chia: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Giá trị nhập vào không phải là số thực.");
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Phép chia không hợp lệ (mẫu số bằng 0).");
        }
        return a / b;
    }
}