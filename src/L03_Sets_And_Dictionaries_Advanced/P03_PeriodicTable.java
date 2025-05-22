package L03_Sets_And_Dictionaries_Advanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countChemicalCompounds = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalElements = new TreeSet<>();

        for (int i = 1; i <= countChemicalCompounds ; i++) {

            //String[] currentChemicalCompound = scanner.nextLine().split("\\s+");
            //Arrays.stream(currentChemicalCompound).forEach(element -> chemicalElements.add(element));

            Arrays.stream(scanner.nextLine().split("\\s+")).forEach(element -> chemicalElements.add(element));
            //chemicalElements.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }

        chemicalElements.forEach(e -> System.out.printf("%s ", e));


    }
}
