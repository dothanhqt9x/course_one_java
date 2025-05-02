package multiThread;

public class MyThread2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable printEven = ()->{
            for(int i=2; i<=10; i+=2){
                System.out.println(i);
            }
        };

        Runnable printOdd = ()->{
            for(int i=1; i<10; i+=2){
                System.out.println(i);
            }
        };

        Thread t1 = new Thread(printEven);
        Thread t2 = new Thread(printOdd);

        System.out.println("Run thread 1:");
        t1.start();
        t1.join();
        System.out.println("Run thread 2:");
        t2.start();
    }
}
