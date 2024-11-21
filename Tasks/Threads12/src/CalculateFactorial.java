import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CalculateFactorial {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        else {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futureFact = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int I = i;
            Callable<Integer> task = () -> factorial(I);
            Future<Integer> future = executor.submit(task);
            futureFact.add(future);
        }

        for (Future<Integer> future : futureFact) {
            try {
                System.out.println("Факториал: " + future.get());
            }
            catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        }
        catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
