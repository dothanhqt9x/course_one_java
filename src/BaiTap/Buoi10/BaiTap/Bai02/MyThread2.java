package BaiTap.Buoi10.BaiTap.Bai02;

import java.util.Objects;

public class MyThread2 implements Runnable {
    private String name;

    public MyThread2() {
    }

    public MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0 && Objects.equals(this.name, "Thread1")) {
                System.out.println(i);
            } else if (i % 2 != 0 && Objects.equals(this.name, "Thread2")) {
                System.out.println(i);
            }
        }
    }
}
