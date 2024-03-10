package ru.eqour.lab2.task7;

public class GoodBank implements Bank {

    @Override
    public Account createAccount() {
        return new Account(1000);
    }

    @Override
    public void transferMoney(Account source, Account destination, double amount) {
        source.withdraw(amount);
        destination.deposit(amount);
    }

    @Override
    public double getBalance(Account account) {
        return account.getBalance();
    }
}
