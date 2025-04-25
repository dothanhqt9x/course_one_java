package java8;

//- MyFunction<T, R>: chuyển đổi dữ liệu

@FunctionalInterface
public interface MyFunction<T, R> {
    R apply(T t);
}
