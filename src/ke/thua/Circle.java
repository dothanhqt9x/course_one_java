package ke.thua;

public class Circle extends Point {
    private int r;

    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    public void Circuit() {
        System.out.println("Chu vi hinh tron: " + 2 * Math.PI * r);
    }

    public void Area() {
        System.out.println("Dien tich hinh tron: " + Math.PI * r * r);
    }

    public static void main(String[] args) {
    }

}
