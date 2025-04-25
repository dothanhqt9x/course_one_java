package Lambda;

@FunctionalInterface
public interface MyFunction<T, R> {
    R apply(T t);
}
