package BaiTap.Buoi9.Baitap.Bai1;

import BaiTap.Buoi9.Baitap.Bai2.MyConsumer;
import BaiTap.Buoi9.Baitap.Bai2.MyFunction;
import BaiTap.Buoi9.Baitap.Bai2.MyPredicate;
import BaiTap.Buoi9.Baitap.Bai2.MySupplier;
import BaiTap.Buoi9.Baitap.dto.OrderDto;

import java.util.List;

public class Order implements MyConsumer, MyFunction, MyPredicate, MySupplier {
    private int id;
    private String product;
    private int quantity;
    private double price;
    private OrderStatus status;

    public Order() {
        this.id = 100;
        this.product = "giày dép xịn xò";
        this.quantity = 4;
        this.price = 1000;
        this.status = OrderStatus.NEW;
    }

    public Order(int id, String product, int quantity, double price, OrderStatus status) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status=" + status +
                '}';
    }


    @Override
    public OrderDto getChangeOrderToOrderDto(Order order) {
        return new OrderDto(order.getProduct());
    }

    @Override
    public boolean getPriceMoreThan600() {
        return this.getPrice() > 600;
    }

    @Override
    public Order generateOrder() {
        return this;
    }

    @Override
    public void displayOrders(Order order) {
        System.out.println(order.toString());
    }
}
