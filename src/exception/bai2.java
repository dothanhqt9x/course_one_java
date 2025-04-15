package exception;

import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];

        try {
            inputArray(array, scanner);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void inputArray(int[] array, Scanner scanner) throws Exception {
        for (int i = 0; i < array.length; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            int value = Integer.parseInt(scanner.nextLine());
            if (value == 100) {
                throw new Exception("Chương trình kết thúc do nhập giá trị 100.");
            }
            array[i] = value;
        }
    }
}