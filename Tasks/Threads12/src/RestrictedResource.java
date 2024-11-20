import java.util.concurrent.Semaphore;

public class RestrictedResource implements Runnable {
    private int counter;
    private Semaphore semaphore;

    public RestrictedResource(Semaphore semaphore) {
        this.counter = 0;
        this.semaphore = semaphore;
    }

    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        try {
            if (semaphore.tryAcquire()) {
                System.out.println("Поток: " + Thread.currentThread().getName() + " получил доступ!");
                increment();
                System.out.println("Поток: " + Thread.currentThread().getName() + " освободил доступ!");
            }
            else {
                System.out.println("Поток: " + Thread.currentThread().getName() + " не получил доступ!");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        RestrictedResource resource = new RestrictedResource(semaphore);
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(resource);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Закончил, счетчик: " + resource.getCounter());
    }
}
