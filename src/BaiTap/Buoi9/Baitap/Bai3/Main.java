package BaiTap.Buoi9.Baitap.Bai3;

import BaiTap.Buoi9.Baitap.Bai1.Order;
import BaiTap.Buoi9.Baitap.Bai1.OrderStatus;
import BaiTap.Buoi9.Baitap.Bai2.MyConsumer;
import BaiTap.Buoi9.Baitap.Bai2.MySupplier;
import BaiTap.Buoi9.Baitap.dto.OrderDto;

import java.util.*;
import java.util.function.Supplier;

public class Main {
    public static void displayListOrder(List<Order> orders) {
        orders.forEach(new Order()::displayOrders);
    }

    public static List<Order> generateOrders() {
        return new ArrayList<>(List.of(
                new Order(1, "Áo Thun", 2, 199, OrderStatus.NEW),
                new Order(2, "Quần Jeans", 1, 499, OrderStatus.NEW),
                new Order(3, "Giày Thể Thao", 1, 899, OrderStatus.DELIVERED),
                new Order(4, "Balo", 3, 299, OrderStatus.NEW),
                new Order(5, "Tai Nghe", 2, 350, OrderStatus.PROCESSING),
                new Order(6, "Áo Khoác", 1, 599, OrderStatus.DELIVERED),
                new Order(7, "Mũ Lưỡi Trai", 4, 150, OrderStatus.DELIVERED),
                new Order(8, "Đồng Hồ", 1, 1200, OrderStatus.PROCESSING),
                new Order(9, "Kính Mát", 2, 750, OrderStatus.DELIVERED),
                new Order(10, "Túi Đeo Chéo", 1, 320, OrderStatus.PROCESSING)
        ));
    }

    public static Order findOrderById(List<Order> orders, int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst().orElse(null);
    }

    public static void createOrder(List<Order> orders, Scanner scanner) {
        System.out.println("Nhập product: ");
        String product = scanner.nextLine();
        System.out.println("Nhập quantity: ");
        int quantity = scanner.nextInt();
        System.out.println("Nhập price: ");
        double price = scanner.nextDouble();

        int orderId = orders.get(orders.size()).getId();

        Order orderNew = new Order(orderId + 1, product, quantity, price, OrderStatus.NEW);
        orders.add(orderNew);
        System.out.println("Thêm mới thành công!");
    }

    public static void deleteOrderById(List<Order> orders, Scanner scanner) {
        System.out.print("Nhập id đơn hàng cần xóa: ");
        int id = scanner.nextInt();
        Order order = findOrderById(orders, id);
        if (order != null) {
            orders.remove(order);
            System.out.println("Xóa thành công!");
            return;
        }
        System.out.println("Đơn hàng không tồn tại! , Xóa không thành công!");
    }

    public static void getProductNameById(List<Order> orders, Scanner scanner) {
        System.out.print("Nhập ID: ");
        int id = scanner.nextInt();
        OrderDto orderDto = orders.stream().filter(order -> {
            return order.getId() == id;
        }).map(new Order()::getChangeOrderToOrderDto).findFirst().orElse(null);
        System.out.println("Product name của ID = " + id + " là " + orderDto.getProduct());
    }

    public static List<Order> getOrderMoreThan600(List<Order> orders) {
        return orders.stream().filter(Order::getPriceMoreThan600).toList();
    }

    public static Order generateAutoOrder() {
        MySupplier mySupplier = Order::new;
        return mySupplier.generateOrder();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Order> orders = generateOrders();

        int menu;
        do {
            System.out.println("-----MENU------");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xem danh sách");
            System.out.println("3. Danh sách order có giá > 600");
            System.out.println("4. Xem tên sản phẩm theo ID");
            System.out.println("5. Tạo ra order tự động");
            System.out.println("6. Xóa");
            System.out.println("7. Thoát");
            System.out.print("Xin mời bạn chọn chức năng: ");
            menu = scanner.nextInt();
            scanner.nextLine();
            if (menu == 1) {
                createOrder(orders, scanner);

            } else if (menu == 2) {
                displayListOrder(orders);

            } else if (menu == 3) {
                List<Order> orderList = getOrderMoreThan600(orders);
                displayListOrder(orderList);

            } else if (menu == 4) {
                getProductNameById(orders, scanner);

            }else if (menu == 5) {
                Order order = generateAutoOrder();
                orders.add(order);

            } else if (menu == 6) {
                deleteOrderById(orders, scanner);

            }

        } while (menu != 7);

    }
}
