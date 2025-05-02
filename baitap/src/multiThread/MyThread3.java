package multiThread;

public class MyThread3 {
    private int number;
    private boolean isNumberPrinted = false;

    public synchronized void printNumber ()  {
        for (int i=1; i<11; i++){
            number = i;
            System.out.println(i);
            isNumberPrinted = true;
            notify();

            try {
                Thread.sleep(500);
                wait();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    };

    public synchronized void printEvenOrOdd(){
        for (int i=1; i<11; i++){
            while (!isNumberPrinted) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println(number %2 == 0 ? "Even" : "Odd");
            isNumberPrinted = false;
            notify();

            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    };

    public static void main(String[] args) {
        MyThread3 myThread = new MyThread3();

        Thread t1 = new Thread(myThread::printNumber);
        Thread t2 = new Thread(myThread::printEvenOrOdd);

        t1.start();
        t2.start();
        System.out.println("Done!");
    }
}
