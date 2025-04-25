package BaiTap.Buoi9.Baitap.Bai2;

import BaiTap.Buoi9.Baitap.Bai1.Order;
import BaiTap.Buoi9.Baitap.dto.OrderDto;

@FunctionalInterface
public interface MyFunction {
    OrderDto getChangeOrderToOrderDto(Order order);
}
