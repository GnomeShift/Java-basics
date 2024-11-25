import java.util.*;
import java.util.concurrent.*;

public class ThreadMatrix {

    public static int[][] mult(int[][] matrixA, int[][] matrixB) {
        int rowA = matrixA.length;
        int colA = matrixA[0].length;
        int colB = matrixB[0].length;
        int[][] result = new int[rowA][colB];
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<int[]>> futureMatrix = new ArrayList<>();

        if (colA != matrixB.length) {
            throw new IllegalArgumentException("Нельзя такое посчитать!!");
        }

        for (int i = 0; i < rowA; i++) {
            int I = i;
            Callable<int[]> task = () -> {
                int[] rows = new int[colB];

                for (int j = 0; j < colB; j++) {
                    for (int k = 0; k < colA; k++) {
                        rows[j] += matrixA[I][k] * matrixB[k][j];
                    }
                }
                return rows;
            };
            futureMatrix.add(executor.submit(task));
        }

        executor.shutdown();

        try {
            for (int i = 0; i < rowA; i++) {
                result[i] = futureMatrix.get(i).get();
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrixA = {{1, 2}, {3, 4}, {5,6}};
        int[][] matrixB = {{5, 6}, {7, 8}};
        int[][] result = mult(matrixA, matrixB);

        System.out.println("Результат:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
