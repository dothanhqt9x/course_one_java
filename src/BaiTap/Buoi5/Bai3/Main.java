package BaiTap.Buoi5.Bai3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập cạnh 1: ");
            int canh1 = scanner.nextInt();
            System.out.print("Nhập cạnh 2: ");
            int canh2 = scanner.nextInt();
            System.out.print("Nhập cạnh 3: ");
            int canh3 = scanner.nextInt();

            if (canh1 <= 0 || canh2 <= 0 || canh3 <= 0) {
                throw new InvalidTriangleException("Cạnh không được nhỏ hơn 0");
            } else if (canh1 >= Integer.MAX_VALUE || canh2 >= Integer.MAX_VALUE || canh3 >= Integer.MAX_VALUE) {
                throw new InvalidTriangleException("Cạnh không được lớn hơn " + Integer.MAX_VALUE);
            }


            Triangle triangle = new Triangle(canh1, canh2,canh3);
            System.out.println(triangle);

        } catch (InvalidTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
