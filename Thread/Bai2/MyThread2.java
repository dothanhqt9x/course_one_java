package Thread.Bai2;

public class MyThread2 extends Thread {

    public static void main(String[] args) {
        try {
            Thread thread1 = new Thread(() -> {
                for (int i = 1; i <= 10; i++) {
                    if (i % 2 == 0) {
                        System.out.println("Số chẵn : " +  i);
                    }
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 1; i <= 10; i++) {
                    if (i % 2 != 0) {
                        System.out.println("Số lẻ : " +  i);
                    }
                }
            });
            thread1.start();
            thread1.join();
            thread2.start();
        } catch (InterruptedException e) {
            System.out.println("Lỗi" + e);
        }
    }
}
