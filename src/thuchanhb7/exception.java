package thuchanhb7;

import java.util.ArrayList;
import java.util.Scanner;

public class exception {
    public static void bai1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so a: ");
        float a = scanner.nextFloat();
        System.out.println("nhap so b: ");
        int b = scanner.nextInt();
        try {
            float data = a/b ;
            System.out.println(data);
        }catch (Exception e){
            System.out.println("Loi e" +  e);
        }
    }

    public static void bai2(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> danhSach = new ArrayList<>();
        int n;
        while (true) {
            try {
                System.out.print("Nhập số lượng phần tử n: ");
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương hợp lệ.");
            }
        }

        try {
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
                int x = Integer.parseInt(scanner.nextLine());
                if (x == 100) {
                    throw new Exception("Phát hiện phần tử có giá trị 100.");
                }
                danhSach.add(x);
            }

            // Nếu không có ngoại lệ, in toàn bộ mảng
            System.out.println("Các phần tử vừa nhập:");
            for (int num : danhSach) {
                System.out.print(num + " ");
            }

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
            System.out.println("Các phần tử đã nhập trước đó:");
            for (int num : danhSach) {
                System.out.print(num + " ");
            }
        }

        scanner.close();
    }


    public static void main(String[] args) {
        bai1();
        bai2();
    }
}
