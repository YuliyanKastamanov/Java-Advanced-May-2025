package L01_Stack_And_Queues;

import java.util.Scanner;

public class Recursion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long fibonacci = getFibonacci(n);

        //Рекурсията представлява метод, който извиква сам себе си, но трябва да сложим дъно/база(да ограничим програмата), където трябва да прекратим рекурсията



    }

    private static long getFibonacci(int n) {

        return getFibonacci(n - 1);
    }
}
