package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

import static Lambda.OrderStatus.*;

public class OrderManagement {

    public static void log(List<Order> orderList) {
        System.out.println("Lambda Expressions");
        orderList.stream().forEach(o -> System.out.println(o));

        System.out.println("Class::staticMethod");
        MyConsumer<Order> orderMyConsumer = Order::getAll;
        orderList.forEach(orderMyConsumer::accept);
    }

    public static void filterOrder(List<Order> orderList) {
        MyPredicate<Order> orderMyPredicate = order -> order.getTotal() > 60000;
        List<Order> orders = orderList.stream().filter(orderMyPredicate::idBoolean).toList();
        MyConsumer<Order> orderMyConsumer = Order::getAll;
        orders.forEach(orderMyConsumer::accept);


    }

    public static void getNameOrder(List<Order> orderList) {
        MyFunction<Order, String> orderStringMyFunction = Order::getName;
        List<String> orderLists = orderList.stream().map(orderStringMyFunction::apply).toList();
        System.out.println(orderLists);

        Order order = new Order();
        List<String> orderList1 = orderList.stream().map(order::getName).toList();
        System.out.println("orderList1" + orderList1);
    }

    public static void addOrder() {
        MySupplier<Order> orderMySupplier = () -> new Order(4 , "Bánh mì gà", 1, 25000, NEW);
        Order order = orderMySupplier.get();
        System.out.println("Đơn mới" + order);
    }

    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<Order>(List.of(
                new Order(1, "Bánh mì pate", 1, 15000, NEW),
                new Order(2, "Bánh mì trứnng", 15, 10000, PROCESSING),
                new Order(3, "Bánh mì thịt", 10, 20000, DELIVERED)));

        Scanner scanner = new Scanner(System.in);
        int check;
        do {
            System.out.println("1. In ra tất cả đơn hàng ");
            System.out.println("2. Lọc ra các đơn hàng có tổng giá trị lớn hơn 600 ");
            System.out.println("3. Trích xuất tên sản phẩm từ đơn hàng");
            System.out.println("4. Tạo một đơn hàng mẫu không cần đầu vào");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            check = scanner.nextInt();
            switch (check) {
                case 1:
                    System.out.println("In ra tất cả đơn hàng");
                    log(orderList);
                    break;
                case 2:
                    System.out.println(" Lọc ra các đơn hàng có tổng giá trị lớn hơn 600");
                    filterOrder(orderList);
                    break;
                case 3:
                    System.out.println("Trích xuất tên sản phẩm từ đơn hàng");
                    getNameOrder(orderList);
                    break;
                case 4:
                    System.out.println("Tạo một đơn hàng mẫu không cần đầu vào");
                    addOrder();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (check != 0);
    }
}