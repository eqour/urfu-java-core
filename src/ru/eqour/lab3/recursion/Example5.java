package ru.eqour.lab3.recursion;

public class Example5 {

    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    public static int fib(int n) {
        return fib(n, 0);
    }

    private static int fib(int n, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println("fib(" + n + ")");
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 2, depth + 1) + fib(n - 1, depth + 1);
        }
    }
}
