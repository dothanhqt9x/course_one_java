package java8.homework;

@FunctionalInterface
public interface MyConsumer<T> {
    void accept(T t);
}
