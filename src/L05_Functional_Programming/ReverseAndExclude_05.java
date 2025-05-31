package L05_Functional_Programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //numbers = {1, 2, 3, 4, 5, 6}

        int controlNumber = Integer.parseInt(scanner.nextLine());

        //1. reverse list
        Collections.reverse(numbers);
        //{1, 2, 3, 4, 5, 6}.reverse -> {6, 5, 4, 3, 2, 1}

        //2. премахваме всички елементи от списъка, които се делят на controlNumber
        Predicate<Integer> checkDivision = number -> number % controlNumber == 0;
        //checkDivision = true -> числото се дели на controlNumber
        //checkDivision = false -> числото НЕ се дели на controlNumber
        numbers.removeIf(checkDivision);
        //removeIf: прилага checkDivision за всеки един елемент -> премахва елемент, само ако резултата от checkDivision e true

        //3. отпечатваме крайния списък
        numbers.forEach(number -> System.out.print(number + " "));


    }
}
