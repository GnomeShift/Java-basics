public class CounterSync implements Runnable {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000; i++) {
            counter++;
            System.out.println("Поток: " + Thread.currentThread().getName() + ", счетчик: " + counter);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CounterSync counter = new CounterSync();
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(counter);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Закончил, счет: " + counter.getCounter());
    }
}
