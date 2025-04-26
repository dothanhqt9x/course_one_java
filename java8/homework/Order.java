package java8.homework;

public class Order {
    private int id;
    private String product;
    private int quantity;
    private double price;
    private OrderStatus status;

    public Order(int id, String product, int quantity, double price, OrderStatus status) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public Order() {
    }

    public double getTotal() {
        return quantity * price;
    }

    public String getProduct() {
        return product;
    }

    public int getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{id=" + id +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status=" + status +
                ", total=" + getTotal() +
                '}';
    }
}

