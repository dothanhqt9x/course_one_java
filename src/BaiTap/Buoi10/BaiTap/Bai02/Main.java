package BaiTap.Buoi10.BaiTap.Bai02;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 myThread1 = new MyThread2("Thread1");
        MyThread2 myThread2 = new MyThread2("Thread2");

        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);

        thread1.start();

        thread1.join();
        thread2.start();
        thread2.join();
    }
}
