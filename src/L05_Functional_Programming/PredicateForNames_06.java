package L05_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int controlLength = Integer.parseInt(scanner.nextLine()); //дължина за сравнение
        String[] names = scanner.nextLine().split("\\s+");
        //names = ["Sara", "Sam", "George, "Mark", "John"]

        Predicate<String> checkValidLength = name -> name.length() <= controlLength;
        //checkValidLength = true -> дължината на текста е по-малка или равна на контролната дължина
        //checkValidLength = false -> дължината на текста е по-голяма на контролната дължина

        Arrays.stream(names)
                .filter(checkValidLength)
                //филтрация -> оставяме само имената, които отговарят на условието
                //filter(true) -> оставя в списъка елемента
                //filter(false) -> премахва елемента от списъка
                .forEach(System.out::println);
                //отпечатваме елементите останали в списъка
    }
}
