package exceptionHandling;

public class Bai3 {
    public static void main(String[] args) {

        try {
            Triangle triangle1 = new Triangle(3, 4, 5);
            System.out.println("Tam giác hợp lệ: " + triangle1.getSide1() + ", " +
                    triangle1.getSide2() + ", " + triangle1.getSide3());

            Triangle triangle2 = new Triangle(-1, 2, 3);
        } catch (InvalidTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        try {
            Triangle triangle3 = new Triangle(1, 1, 3);
        } catch (InvalidTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        try {
            Triangle triangle4 = new Triangle(Integer.MAX_VALUE + 1.0, 2, 3);
        } catch (InvalidTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
