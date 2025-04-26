package java8;

enum OrderStatus {
    NEW,
    PROCESSING,
    DELIVERED,
}

public class Order {
    private int id, quantity;
    private String product;
    private double price;
    OrderStatus status;

    public Order(int id, String product, int quantity, double price) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.status = OrderStatus.NEW;
    }

    public Order(Order order) {
        this.id = order.id;
        this.product = order.product;
        this.quantity = order.quantity;
        this.price = order.price;
        this.status = order.status;
    }

    public double getTotal() {
        return quantity * price;
    }

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status=" + status +
                ", total=" + (quantity * price) +
                '}';
    }
}

