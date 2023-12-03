package coba;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi pengguna
        BankTeller bankTeller = new BankTeller("teller1", "tellerpass");
        Nasabah nasabah1 = new Nasabah("nasabah1", "nasabahpass", 100000.0);
        nasabah1.addAsset(new SavingAccount("Savings Account", 5000.0));
        nasabah1.addAsset(new Loan("Home Loan", 50000.0));
        nasabah1.addAsset(new CreditCard("Gold Credit Card", 10000.0));

        System.out.println("1. Login as Teller");
        System.out.println("2. Login as Nasabah");
        System.out.println("3. Exit");

        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();  // Menangani newline

        switch (option) {
            case 1:
                bankTeller.login();
                bankTeller.viewAllTransactions(Arrays.asList(nasabah1));
                break;
            case 2:
                System.out.println("Login as Nasabah");
                System.out.print("Enter your username: ");
                String nasabahUsername = scanner.nextLine();
                System.out.print("Enter your password: ");
                String nasabahPassword = scanner.nextLine();

                if (nasabahUsername.equals(nasabah1.getUsername()) && nasabahPassword.equals(nasabah1.getPassword())) {
                    nasabah1.login();
                    handleNasabahOperations(nasabah1, scanner);
                } else {
                    System.out.println("Login failed. Invalid username or password.");
                }
                break;

            case 3:
                System.out.println("Exiting the program.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Exiting the program.");
                System.exit(0);
        }
    }

    private static void handleNasabahOperations(Nasabah nasabah, Scanner scanner) {
        int nasabahOption;
        do {
            System.out.println("Nasabah Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Payment");
            System.out.println("5. Deposit");
            System.out.println("6. View Transactions History");
            System.out.println("7. View Assets");
            System.out.println("8. Exit Nasabah Menu");

            System.out.print("Choose an option: ");
            nasabahOption = scanner.nextInt();
            scanner.nextLine();  // Menangani newline

            switch (nasabahOption) {
                case 1:
                    System.out.println("Balance: " + nasabah.checkBalance());
                    System.out.println("Success: Check Balance");
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    nasabah.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter recipient username: ");
                    String recipientUsername = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    nasabah.transfer(new Nasabah(recipientUsername, "", 0.0), transferAmount);
                    break;
                case 4:
                    System.out.print("Enter amount for payment: ");
                    double paymentAmount = scanner.nextDouble();
                    nasabah.payment(paymentAmount);
                    break;
                case 5:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    nasabah.deposit(depositAmount);
                    break;
                case 6:
                    nasabah.viewTransactionHistory();
                    break;
                case 7:
                    System.out.println("View Assets:");
                    for (Asset asset : nasabah.getAssets()) {
                    System.out.println(asset);
                }
                break;
                case 8:
                    System.out.println("Exiting Nasabah Menu.");
                    System.out.println("Success: Exiting Nasabah Menu.");
                break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }   
                } while (nasabahOption != 8);
    }
}
