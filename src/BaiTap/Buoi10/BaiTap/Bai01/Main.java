package BaiTap.Buoi10.BaiTap.Bai01;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 myThread1 = new MyThread1();
        MyThread1 myThread2 = new MyThread1();

        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread1.join();
        thread2.start();


    }
}
