package coba;

interface BankingOperations {
    void withdraw(double amount);

    void transfer(Nasabah receiver, double amount);

    void payment(double amount);

    double checkBalance();
}