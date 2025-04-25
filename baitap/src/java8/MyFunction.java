package java8;

@FunctionalInterface
public interface MyFunction<T, R> {
    R apply(T t);
}
