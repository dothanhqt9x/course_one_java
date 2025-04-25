package Java8;

enum OrderStatus {
    NEW, PROCESSING, DELIVERED
}

// 1. Tạo class Order với các thuộc tính
public class Order {
    int id;
    String product;
    int quantity;
    double price;
    OrderStatus orderStatus;

    public Order() {
        this.id = 0;
        this.product = "Sample";
        this.quantity = 1;
        this.price = 100.0;
        this.orderStatus = OrderStatus.NEW;
    }


    public double getTotal() {
        return price * quantity;
    }

    public Order(int id, String product, int quantity, double price, OrderStatus orderStatus) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.orderStatus = orderStatus;
    }

    public String getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orderStatus=" + orderStatus +
                '}';
    }
}

// 2. Tự định nghĩa lại 4 functional interface, tương đương:
@FunctionalInterface
interface MyConsumer<T> {
    void accept(T t);
}
@FunctionalInterface
interface MyPredicate<T> {
    boolean test(T t);
}
@FunctionalInterface
interface MyFunction <T, R> {
    R apply(T t);
}
@FunctionalInterface
interface MySupplier <T>{
    T get();
}


