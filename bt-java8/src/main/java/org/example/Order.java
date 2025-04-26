package org.example;

@FunctionalInterface
interface MyConsumer<T> {
    void accept(T t);
}

@FunctionalInterface
interface MyPredicate<T> {
    boolean test(T t);
}

@FunctionalInterface
interface MyFunction<T, R> {
    R apply(T t);
}

@FunctionalInterface
interface MySupplier<T> {
    T get();
}

public class Order {
    public enum OrderStatus {
        NEW,
        PROCESSING,
        DELIVERED
    }

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

    public double getTotal() {
        return quantity * price;
    }

    public String getProduct() {
        return product;
    }

    public static void printOrder(Order order) {
        System.out.println(order);
    }

    @Override
    public String toString() {
        return "Order{id=" + id +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status=" + status + '}';
    }
}
