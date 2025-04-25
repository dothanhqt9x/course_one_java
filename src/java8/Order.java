package java8;

//1. Tạo class Order với các thuộc tính
//- int id
//- String product
//- int quantity
//- double price
//-OrderStatus status (enum có giá trị NEW, PROCESSING, DELIVERED)
//- Phương thức double getTotal() trả về quantity * price

public class Order {
    private int id;
    private String product;
    private int quantity;
    private double price;
    private OrderStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order() {
    }

    public Order(int id, String product, int quantity, double price,OrderStatus status) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public double getTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format(
                "Order{id=%d, product='%s', quantity=%d, price=%.2f, total=%.2f, status=%s}",
                id, product, quantity, price, (quantity * price), status
        );
    }
}
