package JavaAdvanced.L05_Functional_Programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
        //numbers = {1, 4, 3, 2, 1, 7, 13}
        //Отпечатваме най-малкия елемент в списъка

        //начин 1: без функционално програмиране
        //System.out.println(Collections.min(numbers));

        //начин 2:
        //лист -> отпечатваме най-малкото число
        /*Consumer<List<Integer>> printMinNumberInList = list -> System.out.println(Collections.min(list));
        printMinNumberInList.accept(numbers);*/

        //начин 3:
        //приема списък с цели числа -> връща най-малкото цяло число в списъка
        Function<List<Integer>, Integer> getMinNumberInList = list -> Collections.min(list);
        int minElement = getMinNumberInList.apply(numbers);
        System.out.println(minElement);
    }
}
