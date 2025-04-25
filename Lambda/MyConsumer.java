package Lambda;
@FunctionalInterface
public interface MyConsumer<T> {
  void accept(T t);
}
