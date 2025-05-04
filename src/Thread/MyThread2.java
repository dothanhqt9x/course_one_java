package Thread;

//Tạo file MyThread2.java, và thực hiện theo yêu cầu:
//Tạo thread 1 và thread 2
//Thread 1 sẽ in ra các số chẵn nằm trong 1 đến 10
//Thread 2 sẽ in ra các số lẻ nằm trong 1 đến 10
//Viết đoạn code sao cho chương trình sẽ chạy xong thread 1 thì chạy tiếp sang thread 2.


public class MyThread2 {

    public static void main(String[] args) throws InterruptedException {
        Thread even = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                System.out.print("Even :");
                System.out.println(i);
            }
            System.out.println("Done even");
        });

        Thread odd = new Thread(() -> {
            for (int i = 0; i <= 10; i += 2) {
                System.out.print("Odd :");
                System.out.println(i);
            }
            System.out.println("Done odd");
        });

        even.start();
        even.join();
        odd.start();
    }

}
