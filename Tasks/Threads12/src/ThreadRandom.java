import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadRandom implements Runnable {
    List<Integer> numbers = new CopyOnWriteArrayList<>();

    public List<Integer> getList() {
        return numbers;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
            System.out.println("Поток: " + Thread.currentThread().getName() + ", список: " + numbers);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadRandom threadRandom = new ThreadRandom();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(threadRandom);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Закончил, счет: " + threadRandom.getList());
    }
}
