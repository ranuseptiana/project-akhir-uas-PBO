package coba;

import java.util.List;

class BankTeller extends User {
    public BankTeller(String username, String password) {
        super(username, password);
    }

    public void viewAllTransactions(List<User> users) {
        for (User user : users) {
            System.out.println("User: " + user.getUsername());
            System.out.println("Transaction History:\n" + user.getTransactionHistoryAsString());
            System.out.println("Assets: " + user.getAssets());
            System.out.println("-----------------------");
        }
    }
}