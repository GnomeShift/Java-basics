import java.util.concurrent.ArrayBlockingQueue;

public class ConveyorLine implements Runnable {
    private ArrayBlockingQueue<Integer> queue;

    public ConveyorLine(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            try {
                queue.put(i);
                System.out.println("Добавлен элемент: " + i);
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Получен элемент: " + queue.take());
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        ConveyorLine line = new ConveyorLine(queue);
        Thread[] threads = new Thread[10];


        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(line);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
