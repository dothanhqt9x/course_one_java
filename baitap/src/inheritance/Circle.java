package inheritance;

class Circle extends Point {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double tinhChuVi(){
        return r * 2 * Math.PI;
    }

    public double tinhDienTich(){
        return r * r * Math.PI;
    }

    public static void main(String[] args) {
        Circle c = new Circle(5);
        System.out.println(c.tinhChuVi());
        System.out.println(c.tinhDienTich());
    }
}