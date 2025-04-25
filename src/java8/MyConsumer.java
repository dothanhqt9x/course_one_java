package java8;

//- MyConsumer<T>: nhận vào một giá trị và xử lý


@FunctionalInterface
public interface MyConsumer<T>{
    void apply(T t);
}
