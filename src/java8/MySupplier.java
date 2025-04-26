package java8;

@FunctionalInterface
public interface MySupplier<T> {
    T get();
}
