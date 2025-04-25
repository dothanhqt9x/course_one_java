package java8;

public class Order {
    private int id;
    private String product;
    private int quantity;
    private double price;
    private OrderStatus status;

    public Order(){

    }

    public Order(int id, String product, int quantity, double price, OrderStatus status) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotal() {
        return quantity * price;
    }

    public static boolean isHighValue(Order order) {
        return order.getTotal() > 600;
    }

    public void printOrder(Order order) {
        System.out.println("Order{id=" + order.getId() + ", product='" + order.getProduct() +
                "', quantity=" + order.getQuantity() + ", price=" + order.getPrice() +
                ", status=" + order.getStatus() + ", total=" + order.getTotal() + "}");
    }
}

