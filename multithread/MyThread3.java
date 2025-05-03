package multithread;

public class MyThread3 {
    private static final Object lock = new Object();
    private static int currentNumber = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    currentNumber = i;
                    System.out.println("Thread1: " + currentNumber);

                    lock.notify();

                    if (i < 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    if (currentNumber % 2 == 0) {
                        System.out.println("Thread2: Chẵn");
                    } else {
                        System.out.println("Thread2: Lẻ");
                    }

                    lock.notify();

                    if (i < 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}