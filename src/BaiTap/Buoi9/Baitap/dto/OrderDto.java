package BaiTap.Buoi9.Baitap.dto;

public class OrderDto {
    private String product;

    public OrderDto() {
    }

    public OrderDto( String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                ", product='" + product + '\'' +
                '}';
    }
}
