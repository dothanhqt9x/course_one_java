package java8.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void printOrder(Order order) {
        System.out.println(order);
    }

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Laptop", 2, 400.0, OrderStatus.NEW));
        orders.add(new Order(2, "Phone", 1, 800.0, OrderStatus.PROCESSING));
        orders.add(new Order(3, "Tablet", 3, 200.0, OrderStatus.DELIVERED));
        orders.add(new Order(4, "Monitor", 1, 300.0, OrderStatus.NEW));

        // MyConsumer: in ra tất cả đơn hàng
        MyConsumer<Order> consumer = System.out::println;
        System.out.println("Tất cả đơn hàng:");
        orders.forEach(consumer::accept); // object::instanceMethod

//        MyConsumer<Order> consumer = Main::printOrder; // Class::staticMethod
//        System.out.println("Tất cả đơn hàng:");
//        orders.forEach(consumer::accept);

        // MyPredicate: lọc đơn hàng có tổng > 600
        MyPredicate<Order> predicate = order -> order.getTotal() > 600;
        List<Order> filteredOrders = orders.stream()
                .filter(predicate::test) // object::instanceMethod
                .collect(Collectors.toList());

        System.out.println("Đơn hàng có tổng > 600:");
        filteredOrders.forEach(consumer::accept);

        // MyFunction: trích xuất tên sản phẩm
        MyFunction<Order, String> function = Order::getProduct; // Class::instanceMethod
        List<String> productNames = orders.stream()
                .map(function::apply)
                .collect(Collectors.toList());

        System.out.println("Tên sản phẩm:");
        productNames.forEach(System.out::println);

        // MySupplier: tạo 1 đơn hàng mẫu
        MySupplier<Order> supplier = Order::new; // ClassName::new (constructor reference)

        MySupplier<Order> sampleSupplier = () -> new Order(999, "Sample Product", 1, 999.0, OrderStatus.NEW);
        Order sampleOrder = sampleSupplier.get();

        System.out.println("Đơn hàng mẫu:");
        System.out.println(sampleOrder);
    }
}

