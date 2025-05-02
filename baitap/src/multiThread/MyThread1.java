package multiThread;

public class MyThread1 implements Runnable{

    @Override
    public void run(){
        for (int i = 0; i <10; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread1());
        Thread t2 = new Thread(new MyThread1());

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.setName("Thread1");
        t2.setName("Thread2");

        t1.start();
        t2.start();
    }
}
