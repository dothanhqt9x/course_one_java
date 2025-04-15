package exception;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập cạnh thứ nhất: ");
            int side1 = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập cạnh thứ hai: ");
            int side2 = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập cạnh thứ ba: ");
            int side3 = Integer.parseInt(scanner.nextLine());

            Triangle triangle = new Triangle(side1, side2, side3);
            System.out.println("Tam giác hợp lệ được tạo thành công!");
        } catch (InvalidTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Giá trị nhập vào không phải là số nguyên.");
        } finally {
            scanner.close();
        }
    }
}

class InvalidTriangleException extends RuntimeException {
    public InvalidTriangleException(String message) {
        super(message);
    }
}

class Triangle {
    private int side1, side2, side3;

    public Triangle(int side1, int side2, int side3) throws InvalidTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new InvalidTriangleException("Cạnh tam giác phải lớn hơn 0.");
        }
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new InvalidTriangleException("Tổng hai cạnh bất kỳ phải lớn hơn cạnh còn lại.");
        }
        if (side1 > Integer.MAX_VALUE || side2 > Integer.MAX_VALUE || side3 > Integer.MAX_VALUE) {
            throw new InvalidTriangleException("Giá trị cạnh tam giác quá lớn.");
        }

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
}