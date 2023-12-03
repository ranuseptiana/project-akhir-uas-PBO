package coba;

import java.util.List;

class Nasabah extends User implements BankingOperations {
    private double saldo;
    private List<Asset> assets;
    
    public Nasabah(String username, String password, double saldo) {
        super(username, password);
        this.saldo = saldo;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > saldo) {
            System.out.println("Insufficient funds. Withdrawal canceled.");
        } else {
            addTransaction(new Transaction("Withdraw", amount));
            saldo -= amount;
            System.out.println("Withdraw successful!");
            System.out.println("Current Balance: " + checkBalance());
        }
    }

    @Override
    public void transfer(Nasabah receiver, double amount) {
        if (amount > saldo) {
            System.out.println("Insufficient funds. Transfer canceled.");
        } else {
            addTransaction(new Transaction("Transfer to " + receiver.getUsername(), amount));
            receiver.addTransaction(new Transaction("Transfer from " + getUsername(), amount));
            saldo -= amount;
            receiver.deposit(amount);  // Receiver deposits the transferred amount
            System.out.println("Transfer successful!");
            System.out.println("Current Balance: " + checkBalance());
        }
    }

    @Override
    public void payment(double amount) {
        addTransaction(new Transaction("Payment", amount));
        System.out.println("Payment successful!");
        System.out.println("Current Balance: " + checkBalance());
    }

    @Override
    public double checkBalance() {
        return saldo;
    }

    public void deposit(double amount) {
        addTransaction(new Transaction("Deposit", amount));
        saldo += amount;
        System.out.println("Deposit successful!");
        System.out.println("Current Balance: " + checkBalance());
    }
    
    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}