import java.util.Arrays;
import java.util.concurrent.*;

public class ThreadSort {

    public static void sort(int[] array) {
        int length = array.length;
        int partSize = length / 5;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        int[][] parts = new int[5][];

        for (int i = 0; i < 5; i++) {
            int start = i * partSize;
            int end = (i == 5 - 1) ? length : start + partSize;
            int I = i;
            parts[i] = Arrays.copyOfRange(array, start, end);
            executor.submit(() -> Arrays.sort(parts[I]));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1000, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        int[] partedArray = new int[length];
        int k = 0;

        for (int[] part : parts) {
            System.arraycopy(part, 0, partedArray, k, part.length);
            k += part.length;
        }

        Arrays.sort(partedArray);
        System.arraycopy(partedArray, 0, array, 0, length);
    }


    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7, 9, 8, 10, 4, 1, 2, 3};
        sort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}