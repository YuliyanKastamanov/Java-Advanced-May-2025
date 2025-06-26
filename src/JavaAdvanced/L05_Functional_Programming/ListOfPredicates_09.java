package JavaAdvanced.L05_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endNumber = Integer.parseInt(scanner.nextLine());
        //всички числа от [1; endNumber]

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //numbers = {1, 1, 1, 2}

        //приемам: число, списък за проверка
        //връщам: true/false
        //true -> ако число се дели на всички числа в списъка
        //false -> ако числото не се дели на всички числа в списъка
        BiPredicate<Integer, List<Integer>> isDivisible = (number, list) -> {
            for (int numInList : list) {
                if (number % numInList != 0) {
                    return false;
                    //намерили сме поне едно число в списъка, което не се дели на number
                }
            }
            //обходя всички числа в списъка и всички делят number
            return true;
        };



        //отпечатваме всички числа в диапазона [1; endNumber], които се делят на всяко число в списъка
        for (int number = 1; number <= endNumber; number++) {
            //проверка дали се дели на всяко число в списъка
            if (isDivisible.test(number, numbers)) {
                System.out.print(number + " ");
            }
        }
    }
}
