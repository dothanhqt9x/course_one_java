package java8;

//- MyPredicate<T>: kiểm tra điều kiện boolean

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
