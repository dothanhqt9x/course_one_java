package Thread;

public class PriorityDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("run 2 thread");

        CounterThread highPriorityThread = new CounterThread("HighPriority");
        CounterThread lowPriorityThread = new CounterThread("LowPriority");

        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        highPriorityThread.start();
        lowPriorityThread.start();

        Thread.sleep(200);
        System.out.println("stop");

        highPriorityThread.stopRunning();
        lowPriorityThread.stopRunning();

        // Đợi cho 2 thread kết thúc hẳn
        highPriorityThread.join();
        lowPriorityThread.join();

        System.out.println("HighPriority count: " + highPriorityThread.getCount());
        System.out.println("LowPriority count: " + lowPriorityThread.getCount());
    }

    static class CounterThread extends Thread {
        private long count = 0;
        private volatile boolean running = true;

        public CounterThread(String name) {
            super(name);
        }

        public void stopRunning() {
            running = false;
        }

        public long getCount() {
            return count;
        }

        @Override
        public void run() {
            while (running) {
                count++;
            }
        }
    }
}


