package thuchanhb6.bai2;

public class Rectangle extends Shape{
    protected double width;
    protected double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    double getArea() {
        return this.height * this.width;
    }

    @Override
    double getPerimeter() {
        return (this.height + this.width) * 2;
    }

    @Override
    public String toString(){
        return "This is a Rectangle and it has height and width " + this.height + this.width;
    }
}
