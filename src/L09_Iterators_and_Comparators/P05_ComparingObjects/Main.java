package L09_Iterators_and_Comparators.P05_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("END")){
            String[] data = input.split("\\s+");

            //"{name} {age} {town}"
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];

            Person person = new Person(name, age, town);

            people.add(person);

            input = scanner.nextLine();
        }

        int index = Integer.parseInt(scanner.nextLine()) - 1;

        Person specialPerson = people.get(index);

        int countEqualPeople = 0;

        for (Person person : people){
            if(person.compareTo(specialPerson) == 0){
                countEqualPeople++;
            }
        }

        if(countEqualPeople == 1){
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d", countEqualPeople, people.size() - countEqualPeople, people.size());
        }




    }
}
