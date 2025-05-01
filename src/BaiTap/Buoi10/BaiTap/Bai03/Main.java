package BaiTap.Buoi10.BaiTap.Bai03;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread3 myThread = new MyThread3();

        Thread thread1 = new Thread(() -> {
            try {
                myThread.displayEvenOrOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                myThread.displayEvenOrOddString();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();

    }
}
