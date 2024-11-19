import java.util.*;
import java.util.concurrent.*;

public class BankSim {
    private Map<Integer, Account> accounts = new HashMap<>();

    private class Account {
        private int balance;

        public Account(int balance) {
            this.balance = balance;
        }

        public synchronized int getBalance() {
            return balance;
        }

        public synchronized void deposit(int amount) {
            balance += amount;
        }

        public synchronized void withdraw(int amount) {
            balance -= amount;
        }
    }

    public BankSim() {
        Random random = new Random();
        for (int i = 1; i <= 2; i++) {
            accounts.put(i, new Account(random.nextInt(10000)));
        }
    }

    public synchronized void transfer(int source, int dest, int amount) {
        Account first = accounts.get(source);
        Account second = accounts.get(dest);

        if (first == null || second == null) {
            System.out.println("А нет такого счета!!");
            return;
        }

        if (first.getBalance() < amount) {
            System.out.println("У тебя нет таких денег!!");
            return;
        }

        first.withdraw(amount);
        second.deposit(amount);

        System.out.println("Перевод " + amount + " с " + source + " на " + dest + ", баланс " + source + ": " + first.getBalance() + ", баланс " + dest + ": " + second.getBalance());
    }

    public static void main(String[] args) throws InterruptedException {
        BankSim bank = new BankSim();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                int first = random.nextInt(2) + 1;
                int second = random.nextInt(2) + 1;
                int amount = random.nextInt(500) + 1;
                bank.transfer(first, second, amount);
            });
        }

        executor.shutdown();

        System.out.println("Закончил, счета:");
        for (Map.Entry<Integer, Account> entry : bank.accounts.entrySet()) {
            System.out.println("Счет " + entry.getKey() + ": " + entry.getValue().getBalance());
        }
    }
}