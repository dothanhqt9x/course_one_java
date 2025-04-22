package exceptionHandling;

public class Triangle {
    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) throws InvalidTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new InvalidTriangleException("Cạnh tam giác không được nhỏ hơn hoặc bằng 0");
        }

        if (side1 > Integer.MAX_VALUE || side2 > Integer.MAX_VALUE || side3 > Integer.MAX_VALUE) {
            throw new InvalidTriangleException("Cạnh tam giác quá lớn, vượt quá giới hạn số nguyên");
        }

        if (side1 + side2 <= side3 || side2 + side3 <= side1 || side1 + side3 <= side2) {
            throw new InvalidTriangleException("Ba cạnh không tạo thành tam giác hợp lệ");
        }

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }
}
