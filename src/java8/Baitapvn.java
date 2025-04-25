package java8;
//
//
//
//Anh em làm bài tập theo yêu cầu sau
//1. Tạo class Order với các thuộc tính
//- int id
//- String product
//- int quantity
//- double price
//-OrderStatus status (enum có giá trị NEW, PROCESSING, DELIVERED)
//- Phương thức double getTotal() trả về quantity * price

//2. Tự định nghĩa lại 4 functional interface, tương đương:
//- MyConsumer<T>: nhận vào một giá trị và xử lý
//- MyPredicate<T>: kiểm tra điều kiện boolean
//- MyFunction<T, R>: chuyển đổi dữ liệu
//- MySupplier<T>: trả về một giá trị

//3. Áp dụng các interface trên với lambda hoặc method reference để:
//- In ra tất cả đơn hàng
//- Lọc ra các đơn hàng có tổng giá trị lớn hơn 600
//- Trích xuất tên sản phẩm từ đơn hàng
//- Tạo một đơn hàng mẫu không cần đầu vào

//4.Áp dụng đủ 4 loại Method Reference trong bài:
//- Class::staticMethod
//- object::instanceMethod
//- Class::instanceMethod
//- ClassName::new (constructor reference)
//

//Hiểu rõ là áp dụng thế nào để hỏi nhé


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Baitapvn {

    public static List<Order> listData() {
        List<String> products = List.of("Laptop", "Chuột", "Bàn phím", "Màn hình", "Tai nghe", "USB", "Loa", "Webcam");

        Random random = new Random();

        List<Order> orders = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            String product = products.get(random.nextInt(products.size()));
            int quantity = random.nextInt(5) + 1; // 1 đến 5
            double price = (random.nextInt(20) + 10) * 10; // 100 đến 200
            OrderStatus status = OrderStatus.values()[random.nextInt(3)];

            orders.add(new Order(i, product, quantity, price, status));
        }
        return orders;
    }

    public static void main(String[] args) {
        List<Order> orders = listData();

//  - In ra tất cả đơn hàng
//      orders.forEach(System.out::println);


//  - Lọc ra các đơn hàng có tổng giá trị lớn hơn 600
        List<Order> ordersOver600 = orders.stream()
                .filter(order -> order.getTotal() > 600)
                .toList();

//      ordersOver600.forEach(System.out::println);


//  - Trích xuất tên sản phẩm từ đơn hàng
        List<String> productNameList = orders.stream()
                .map(Order::getProduct).distinct().toList();

//        productNameList.forEach(System.out::println);

//  - Tạo một đơn hàng mẫu không cần đầu vào

        MySupplier<Order> orderMySupplier = () -> new Order(1, "Laptop", 5, 10.0, OrderStatus.NEW);

        Order newOrder = orderMySupplier.get();

    }

}
