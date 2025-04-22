package exceptionHandling;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Bai2 {

    public static void inputArray(int[] arr) throws Exception, InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            int value = scanner.nextInt();
            if (value == 100) {
                throw new Exception("Đã nhập giá trị 100");
            }
            arr[i] = value;
        }
    }

    public static void printArray(int[] arr, int count) {
        System.out.print("Các phần tử đã nhập: ");
        if (count == 0) {
            System.out.println("Không có phần tử nào.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        while (true) {
            try {
                System.out.print("Nhập số lượng phần tử của mảng (n): ");
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Lỗi: n phải lớn hơn 0!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên!");
                scanner.nextLine();
            }
        }


        int[] arr = new int[n];
        int count = 0;

        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
                int value = scanner.nextInt();
                if (value == 100) {
                    throw new Exception("Đã nhập giá trị 100");
                }
                arr[i] = value;
                count++;
            }
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập một số nguyên!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        printArray(arr, count);

        scanner.close();
    }
}