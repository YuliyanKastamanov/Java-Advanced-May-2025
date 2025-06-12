package L09_Iterators_and_Comparators.P06_StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countPeople = Integer.parseInt(scanner.nextLine());

        Set<Person> orderedByName = new TreeSet<>(new ComparatorByName());
        Set<Person> orderedByAge = new TreeSet<>(new ComparatorByAge());

        for (int i = 1; i <= countPeople ; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            Person person = new Person(data[0],Integer.parseInt(data[1]));

            orderedByName.add(person);
            orderedByAge.add(person);

        }
        orderedByName.forEach(System.out::println);
        orderedByAge.forEach(System.out::println);

    }
}
