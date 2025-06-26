package JavaAdvanced.L05_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //numbers = {1, 2, 3, 4, 5}

        String command = scanner.nextLine();
        //add -> увеличаваме всеки един елемент от списъка с 1: приема списък -> връща вписък с модифицирани елементи
        Function<List<Integer>, List<Integer>> addCommand = list -> list.stream().map(number -> number += 1).collect(Collectors.toList());

        //multiply -> умножаваме всеки един елемент от списъка с 2: приема списък -> връща вписък с модифицирани елементи
        Function<List<Integer>, List<Integer>> multiplyCommand = list -> list.stream().map(number -> number *= 2).collect(Collectors.toList());

        //subtract -> намаляваме всеки един елемент от списъка с 1: приема списък -> връща вписък с модифицирани елементи
        Function<List<Integer>, List<Integer>> subtractCommand = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());

        //print -> отпечатваме всеки един елемент от списъка: приема списък -> отпечатва всеки елемент в списъка
        Consumer<List<Integer>> printCommand = list -> list.forEach(number -> System.out.print(number + " "));

        while (!command.equals("end")) {
            switch (command) {
                case "add" -> {
                    //увеличаваме всеки един елемент от списъка с 1
                    numbers = addCommand.apply(numbers);
                }
                case "multiply" -> {
                    //умножаваме всеки един елемент от списъка с 2
                    numbers = multiplyCommand.apply(numbers);
                }
                case "subtract" ->  {
                    //намаляваме всеки един елемент от списъка с 1
                    numbers = subtractCommand.apply(numbers);
                }
                case "print" -> {
                    //отпечатваме всеки един елемент от списъка
                    printCommand.accept(numbers);
                    System.out.println(); //свалям курсора на нов ред
                }
            }
            command = scanner.nextLine();
        }
    }
}
