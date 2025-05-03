package multithread;

public class MyThread2 {
    public static void main(String[] args) throws InterruptedException {
        Thread evenThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println("Thread 1 - Even: " + i);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {
                    System.out.println("Thread 2 - Odd: " + i);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        evenThread.start();
        evenThread.join();
        oddThread.start();
    }
}
