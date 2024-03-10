package ru.eqour.lab2.task7;

public class Main {

    public static void main(String[] args) {
        simulation(new GoodBank());
        System.out.println("\n---\n");
        simulation(new RealBank());
    }

    private static void simulation(Bank bank) {
        Account a = bank.createAccount();
        Account b = bank.createAccount();

        System.out.println("Создание счетов");

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        System.out.println("Поплнение счёта а");

        a.deposit(500);

        System.out.println("a: " + a);

        System.out.println("Перевод между счетами");

        try {
            bank.transferMoney(a, b, 500);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        System.out.println("Перевод между счетами");

        try {
            bank.transferMoney(b, a, 10_000);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}
