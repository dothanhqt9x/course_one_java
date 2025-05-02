package Thread.Bai3;

class CheckNumber {
    private int number;

    public CheckNumber() {
    }

    public int getNumber() {
        return number;
    }

    public synchronized void setNumber(int number) {
        if(number < 0) {
            System.out.println("Số không thuộc phạm vị 0-9");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Lỗi : " + e);
            }
        }
        this.number = number;
    }

    public synchronized void check(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " : chẵn");
        } else {
            System.out.println(number + " : lẻ");
        }
        notify();
    }
}

public class MyThread3 {
    public static void main(String[] args) throws InterruptedException {
        CheckNumber checkNumber = new CheckNumber();

        Thread thread1 = new Thread(() -> {
            for (int i = -2; i < 10; i++) {
                checkNumber.setNumber(i);
            }
        });

        thread1.start();
        Thread thread2 = new Thread(() -> {
            for (int i = -2; i < 10; i++) {
                checkNumber.check(i);
            }
        });
        thread2.start();
    }
}
