package BaiTap.Buoi3.Bai4.Ex4;

public class B extends A{
    private String hello;

    public static void main(String[] args) {
        A a = new B();
    }

    @Override
    protected void getName() {

    }

    @Override
    protected String getName(String name) {
        return "";
    }

    @Override
    public int sum(int a, int b) {
        return 0;
    }
}
