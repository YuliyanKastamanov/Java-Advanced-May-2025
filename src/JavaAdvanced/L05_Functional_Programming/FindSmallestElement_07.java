package JavaAdvanced.L05_Functional_Programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FindSmallestElement_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //numbers = {1, 2, 3, 0, 4, 5, 6}

        //1. най-малкия елемент в списъка
        //2. отпечатваме позицията, на която го срещаме за последно в списъка

        //начин 1:
        //indexOf -> връща първата позиция, на която срещаме дадения елемент
        //lastIndexOf -> връща последната позиция, на която срещаме дадения елемент
        //System.out.println(numbers.lastIndexOf(Collections.min(numbers)));

        //начин 2:
        Consumer<List<Integer>> printLastIndexOfMinElement =
                    list -> System.out.println(list.lastIndexOf(Collections.min(list)));
        printLastIndexOfMinElement.accept(numbers);
    }
}
