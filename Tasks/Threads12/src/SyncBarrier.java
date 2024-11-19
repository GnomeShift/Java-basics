import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SyncBarrier implements Runnable {
    CyclicBarrier barrier;

    public SyncBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Поток: " + Thread.currentThread().getName() + " начал работу!");

            try {
                System.out.println("Поток: " + Thread.currentThread().getName() + " ждет!");
                barrier.await();
                System.out.println("Поток: " + Thread.currentThread().getName() + " продолжил работу после барьера!");
            }
            catch (InterruptedException | BrokenBarrierException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(10, () -> System.out.println("Закончил!"));
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new SyncBarrier(barrier));
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
    }
}
