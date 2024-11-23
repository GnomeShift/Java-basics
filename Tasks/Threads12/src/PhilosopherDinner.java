import java.util.concurrent.locks.*;

public class PhilosopherDinner {
    private ReentrantLock[] lock = new ReentrantLock[5];
    private Condition[] canEat = new Condition[5];

    public PhilosopherDinner() {
        for (int i = 0; i < 5; i++) {
            lock[i] = new ReentrantLock();
            canEat[i] = lock[i].newCondition();
        }
    }

    public void eat(int philosopher) {
        System.out.println("Философ " + philosopher + " обедает");
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Философ " + philosopher + " пообедал");
    }

    public void fork(int philosopher) {
        int left = philosopher;
        int right = (philosopher + 1) % 5;

        lock[left].lock();
        try {
            lock[right].lock();
            try {
                if (!lock[right].isHeldByCurrentThread()) {
                    canEat[philosopher].await();
                    System.out.println("Философ " + philosopher + " ждет вилку");
                }
                eat(philosopher);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            finally {
                lock[right].unlock();
            }
        }
        finally {
            lock[left].unlock();
        }
    }

    public static void main(String[] args) {
        PhilosopherDinner dinner = new PhilosopherDinner();
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int I = i;
            threads[i] = new Thread(() -> {
                while (true) {
                    dinner.fork(I);
                    try {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            threads[i].start();
        }
    }
}
