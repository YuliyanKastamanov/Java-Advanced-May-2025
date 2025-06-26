package JavaAdvanced.L05_Functional_Programming;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        //начин 1: без функционално програмиране
        /*for (String name : names) {
            System.out.println(name);
        }*/

        //начин 2:
        /*Consumer<String> printName = name -> System.out.println(name);
        for (String name : names) {
            printName.accept(name);
        }*/

        //начин 3:
        Consumer<String[]> printArray = array -> {
            for (String text : array) {
                System.out.println(text);
            }
        };
        printArray.accept(names);
    }
}
