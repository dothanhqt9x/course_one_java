package BaiTap.Buoi3.Bai4.Ex3;

import BaiTap.Buoi3.Bai4.Ex4.A;
import BaiTap.Buoi3.Bai4.Ex4.IA;

public class C extends A {
    public static void main(String[] args) {
        IA a = new C();
        System.out.println(a.sum(1,2));
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
        return a+b;
    }
}
