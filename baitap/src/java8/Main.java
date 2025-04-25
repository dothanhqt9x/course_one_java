package java8;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1, "Laptop", 2, 1500, OrderStatus.NEW),
                new Order(2, "Mouse", 5, 20, OrderStatus.PROCESSING),
                new Order(3, "Keyboard", 3, 50, OrderStatus.DELIVERED),
                new Order(4, "AirPod", 1, 300, OrderStatus.NEW),
                new Order(5, "Headphone", 4, 200, OrderStatus.PROCESSING)
        );

        // 1. In ra tất cả đơn hàng
        System.out.println("All Orders:");
        Order printer = new Order();
        MyConsumer<Order> printOrder = printer::printOrder;
        orders.forEach(printOrder::accept);

        // 2. Lọc các đơn hàng có tổng giá trị lớn hơn 600
        System.out.println("\nOrders with total value > 600:");
        MyPredicate<Order> highValueOrder = Order::isHighValue;
        orders.stream()
                .filter(highValueOrder::test)
                .forEach(printOrder::accept);

        // 3. Trích xuất tên sản phẩm từ đơn hàng
        System.out.println("\nProduct Names:");
        MyFunction<Order, String> getProductName = Order::getProduct;
        orders.stream()
                .map(getProductName::apply)
                .forEach(System.out::println);

        // 4. Tạo một đơn hàng mẫu không cần đầu vào
        System.out.println("\nSample Order:");
        MySupplier<Order> sampleOrderSupplier = Order::new;
        Order sampleOrder = sampleOrderSupplier.get();
        printOrder.accept(sampleOrder);
    }
}
