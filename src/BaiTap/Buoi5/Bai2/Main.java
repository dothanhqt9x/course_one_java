package BaiTap.Buoi5.Bai2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập n phần tử: ");
            int n = scanner.nextInt();
            int arr[] = new int[n];
            nhapPhanTu(scanner, arr);
        } catch (InputMismatchException e) {
            System.out.println("Lỗi nè " + e.getMessage());
        }

    }

    public static void nhapPhanTu(Scanner scanner, int arr[]) {
        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.print("Nhập phần tử  thứ " + (i + 1) + " : ");
                arr[i] = scanner.nextInt();
                if (arr[i] == 100) {
                    throw new Exception("In ra hết phần tử nè: ");
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0 && arr[i] != 100) {
                    System.out.println(" + Phần tử thứ " + (i + 1) + " : " + arr[i]);
                }
            }
        }
    }
}
