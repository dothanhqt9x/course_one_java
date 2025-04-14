package BaiTap.Buoi4.Bai2;

public class Circle extends Shape {
    private double radius;

    public Circle() {
    }


    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.pow(3.14, 2) * this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.14 * this.radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
