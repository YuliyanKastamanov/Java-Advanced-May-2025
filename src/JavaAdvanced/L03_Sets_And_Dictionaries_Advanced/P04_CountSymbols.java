package JavaAdvanced.L03_Sets_And_Dictionaries_Advanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> result = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            //проверяваме дали текущият символ присъства в мап-а
            if(!result.containsKey(currentChar)){
                result.put(currentChar, 1);
            }else {
                int currentCount = result.get(currentChar);
                currentCount++;
                result.put(currentChar, currentCount);
            }

        }

        result.entrySet().stream().forEach(e -> System.out.printf("%s: %d time/s%n", e.getKey(), e.getValue()));


    }
}
