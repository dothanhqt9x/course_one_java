package thuchanhb6.bai2;

public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    @Override
    double getArea() {
        return super.getArea();
    }

    public void setSide(double side){
        super.setHeight(side);
        super.setWidth(side);
    }

    @Override
    public void setWidth(double side){
        setSide(side);
    }

    public void setHeight(double side) {
        setSide(side);
    }

    public double getSide(){
        return this.height;
    }

    @Override
    double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public String toString() {
        return "This is a Square and it has the side is " + this.height;
    }
}
