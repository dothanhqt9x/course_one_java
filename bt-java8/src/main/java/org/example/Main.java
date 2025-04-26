package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Sản phẩm 1", 2, 500, Order.OrderStatus.NEW));
        orders.add(new Order(2, "Sản phẩm 2", 1, 800, Order.OrderStatus.PROCESSING));
        orders.add(new Order(3, "Sản phẩm 3", 3, 150, Order.OrderStatus.DELIVERED));
        orders.add(new Order(4, "Monitor", 5, 120, Order.OrderStatus.NEW));

        // 1. In ra tất cả đơn hàng
        MyConsumer<Order> orderPrinter = System.out::println;
        System.out.println("Danh sách các đơn hàng:");
        orders.forEach(orderPrinter::accept);

        // 2. Lọc ra đơn hàng có tổng giá trị > 600
        MyPredicate<Order> highValueOrder = order -> order.getTotal() > 600;
        System.out.println("\n Các đơn hàng có tổng giá trị > 600:");
        orders.stream()
                .filter(highValueOrder::test)
                .forEach(System.out::println);

        // 3. Trích xuất tên sản phẩm từ đơn hàng
        MyFunction<Order, String> extractProductName = Order::getProduct;
        List<String> productNames = orders.stream()
                .map(extractProductName::apply)
                .collect(Collectors.toList());
        System.out.println("\nTên các sản phẩm:");
        productNames.forEach(System.out::println);

        // 4. Tạo đơn hàng mẫu không cần đầu vào
        MySupplier<Order> sampleOrderSupplier = () -> new Order(5, "Keyboard", 10, 30, OrderStatus.NEW);
        Order sampleOrder = sampleOrderSupplier.get();
        System.out.println("\nĐơn hàng mẫu:");
        System.out.println(sampleOrder);
    }
}