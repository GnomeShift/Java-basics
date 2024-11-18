import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 20; i++) {
            int number = i;
            exec.submit(() -> {
                System.out.println("Задача " + number + " в потоке "+ Thread.currentThread().getName());
            });
        }

        exec.shutdown();
    }
}
