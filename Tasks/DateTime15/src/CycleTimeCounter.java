public class CycleTimeCounter {

    public static long countExecTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        Runnable loop = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Цикл выполнился: " + i + " раз");
            }
        };

        long execTime = countExecTime(loop);
        System.out.println("Время выполнения: " + execTime + " нс");
    }
}
