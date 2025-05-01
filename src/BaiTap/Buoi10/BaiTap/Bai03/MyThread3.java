package BaiTap.Buoi10.BaiTap.Bai03;

import java.util.Objects;

public class MyThread3{
    private String name;
    private boolean isNumber = true;

    public MyThread3() {
    }

    public MyThread3(String name) {
        this.name = name;
    }

    public synchronized void displayEvenOrOdd() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            while (!isNumber) {
                wait();
            }
            System.out.print(i + ": ");
            isNumber = false;
            notify();

        }
    }

    public synchronized void displayEvenOrOddString() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            while (isNumber) {
                wait();
            }
            if (i % 2 == 0) {
                System.out.println("Chẵn");
            } else {
                System.out.println("Lẻ");
            }
            isNumber = true;
            notify();

        }
    }
}
