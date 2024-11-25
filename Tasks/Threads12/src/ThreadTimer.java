import java.util.concurrent.*;

public class ThreadTimer {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<?> future = executor.submit(() -> {
            for (int i = 1; i < 11; i++) {
                System.out.println("Время: " + i);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println(e.getMessage());
                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(2000, TimeUnit.MILLISECONDS);
    }
}
