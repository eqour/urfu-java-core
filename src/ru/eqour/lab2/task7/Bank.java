package ru.eqour.lab2.task7;

public interface Bank {
    Account createAccount();
    void transferMoney(Account source, Account destination, double amount);
    double getBalance(Account account);
}
