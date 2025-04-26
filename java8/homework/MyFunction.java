package java8.homework;

@FunctionalInterface
public interface MyFunction<T, R> {
    R apply(T t);
}
