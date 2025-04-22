
package thuchanhb7;

public class InvalidTriangleException extends Exception {
    public InvalidTriangleException(String message) {
        super(message);
    }
}


class Triangle {
    private int a, b, c;

    public Triangle(int a, int b, int c) throws InvalidTriangleException {
        // Kiểm tra điều kiện không hợp lệ
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new InvalidTriangleException("Cạnh tam giác phải lớn hơn 0.");
        }

        if (a > Integer.MAX_VALUE / 2 || b > Integer.MAX_VALUE / 2 || c > Integer.MAX_VALUE / 2) {
            throw new InvalidTriangleException("Cạnh tam giác quá lớn.");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new InvalidTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại.");
        }

        // Nếu hợp lệ thì gán giá trị
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void display() {
        System.out.println("Tam giác có 3 cạnh: " + a + ", " + b + ", " + c);
    }
}
