package coba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base class untuk semua pengguna
class User {
    protected String username;
    protected String password;
    protected List<Transaction> transactionHistory;
    protected List<Asset> assets;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.transactionHistory = new ArrayList<>();
        this.assets = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public void addAsset(Asset asset) {
        assets.add(asset);
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String inputUsername = scanner.nextLine();
        System.out.println("Enter your password:");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed. Invalid username or password.");
            System.exit(0);
        }
    }
    
    public String getTransactionHistoryAsString() {
        StringBuilder historyString = new StringBuilder();
            for (Transaction transaction : transactionHistory) {
                historyString.append(transaction.toString()).append("\n");
            }
        return historyString.toString();
    }
}