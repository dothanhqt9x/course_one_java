package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BT {
    public static void printOrder(Order order){
        System.out.println(order);
    }
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1, "Laptop", 2, 400, OrderStatus.NEW),
                new Order(2, "Phone", 1, 640, OrderStatus.PROCESSING),
                new Order(3, "Tablet", 2, 200, OrderStatus.DELIVERED)
        );

        System.out.println("In ra tất cả đơn hàng: ");
        MyConsumer<Order> consumer = BT::printOrder; //Class::staticMethod
        orders.forEach(consumer::accept); //object::instanceMethod

        System.out.println("Đơn hàng có tổng giá trị lớn hơn 600: ");
        MyPredicate<Order> highVal = order -> order.getTotal() > 600;
        orders.stream().filter(highVal::test).forEach(System.out::println);

        System.out.println("Trích xuất tên sản phẩm từ đơn hàng: ");
        MyFunction<Order, String> nameEx = Order::getProduct; //Class::instanceMethod
        List<String> productsName = orders.stream()
                .map(nameEx::apply)
//                .collect(Collectors.toList());
                .toList();
        productsName.forEach(System.out::println);

        System.out.println("Tạo một đơn hàng mẫu không cần đầu vào: ");
        MySupplier<Order> orderMySupplier = Order::new; //Class::new
        System.out.println(orderMySupplier.get());

        MySupplier<Order> sampleOrder = () -> new Order(99, "Desktop", 5, 200, OrderStatus.NEW);
        System.out.println(sampleOrder.get());
    }
}
