package Thread;

//Tạo file MyThread1.java thực thi interface Runnable và thực hiện các công việc sau:
//        Trong phương thức run() chứa một vòng lặp in ra 10 số tự nhiên đầu tiên
//        và mỗi lần in cách nhau 500 milliseconds.
//
//        Tạo 2 object từ class MyThread là Thread1 và Thread2 với thứ tự ưu tiên tương ứng mà
//        MAX_PRIORITY và MIN_PRIORITY.
//Gọi phương thức start() cho cả 2 thread.


public class MyThread1 implements Runnable {
    private String name;

    public MyThread1(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1("thread1");
        MyThread1 thread2 = new MyThread1("thread2");

        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Có lỗi xảy ra!!!");
            }
        }
    }
}
