class BankAccount {
    private int accountNumber;
    private int balance;

    BankAccount(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(int sum) {
        if (sum > 0) {
            balance += sum;
        }
    }

    public void withdraw(int sum) {
        if (sum > 0 && sum <= balance) {
            balance -= sum;
        }
    }
}

class Main1 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1, 1000);
        System.out.println("Счет под номером: " + account.getAccountNumber() + " с балансом: " + account.getBalance());
    }
}