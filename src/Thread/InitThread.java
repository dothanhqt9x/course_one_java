package Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class InitThread {

    public static void main(String[] args) {
        Thread thr =  new Thread();
     AtomicInteger atom = new AtomicInteger();

        thr.run();
    }

}
