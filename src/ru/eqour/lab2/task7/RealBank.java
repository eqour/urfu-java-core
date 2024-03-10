package ru.eqour.lab2.task7;

public class RealBank implements Bank {

    @Override
    public Account createAccount() {
        return new Account();
    }

    @Override
    public void transferMoney(Account source, Account destination, double amount) {
        if (source.getBalance() < amount) {
            throw new RuntimeException("На счёте отправителя недостаточно средств");
        }
        source.withdraw(amount);
        destination.deposit(amount);
    }

    @Override
    public double getBalance(Account account) {
        return account.getBalance();
    }
}
