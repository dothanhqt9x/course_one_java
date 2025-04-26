package java8;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Order> orderList = List.of(
                new Order(1, "Laptop", 2, 700),
                new Order(2, "Smartphone", 5, 500),
                new Order(3, "Tablet", 3, 50),
                new Order(4, "Headphones", 10, 20),
                new Order(5, "Smartwatch", 4, 900)
        );

        //- In ra tất cả đơn hàng
        MyConsumer<Order> logOrder = order -> System.out.println(order.toString());
        orderList.forEach(logOrder::customMethod);//- object::instanceMethod

        //- Lọc ra các đơn hàng có tổng giá trị lớn hơn 600
        MyFunction<List<Order>, List<?>> filterOrder = orders -> {
            return orders.stream()
                    .filter(order -> order.getTotal() >= 600)
                    .map(Order::toString)
                    .toList();
        };
        System.out.println("các đơn hàng có tổng giá trị lớn hơn 600: ");
        System.out.print(filterOrder.myFunction(orderList));

        //- Trích xuất tên sản phẩm từ đơn hàng
        MyFunction<List<Order>, List<?>> extractProductName = orders -> {
            return orders.stream()
                    .map(Order::getProduct)//- Class::instanceMethod
                    .toList();
        };
        System.out.println("Tên sản phẩm từ đơn hàng: ");
        System.out.println(extractProductName.myFunction(orderList));

        //- Class::staticMethod
        MyConsumer<Order> utility = Utility::staticMethod;
        System.out.println("Class::staticMethod: " + utility);

        //- ClassName::contructor ref
        MyFunction<Order, Order> constructorRef = Order::new;
        System.out.println("ClassName::contructor ref: " + constructorRef.myFunction(new Order(6, "iphone", 1, 300)));
    }

}
