package java8.homework;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
