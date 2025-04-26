package java8;

public final class Utility<T extends Object> {
    public static <T> void staticMethod(T t) {
        System.out.println("Utility static method called: " + t);
    }
}