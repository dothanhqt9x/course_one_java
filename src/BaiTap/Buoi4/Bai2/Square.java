package BaiTap.Buoi4.Bai2;

public class Square extends Rectangle {

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setLength(side);
        setWidth(side);
    }

    @Override
    public void setWidth(double side) {
        setWidth(side);
    }

    @Override
    public void setLength(double side) {
        setLength(side);
    }

    @Override
    public String toString() {
        return super.toString();

    }

    public static void main(String[] args) {
        Square square1 = new Square();
        Square square2 = new Square("red", true, 10);
        System.out.println("Diện tích: " + square2.getArea());
        System.out.println("Chu vi: " + square2.getPerimeter());
        System.out.println(square2);
    }
}
