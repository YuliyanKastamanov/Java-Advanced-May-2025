package JavaAdvanced.L06_Defining_Classes.P01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPeople = Integer.parseInt(scanner.nextLine());
        List<Person> peopleList = new ArrayList<>();

        for (int count = 1; count <= countPeople; count++) {
            String data = scanner.nextLine();
            //data = "{name} {age}".split(" ") -> ["{name}", "{age}"]
            String name = data.split("\\s+")[0];
            int age = Integer.parseInt(data.split("\\s+")[1]);
            Person person = new Person(name, age);
            peopleList.add(person);
        }

        //списък с всички хора
        //1. филтрирам списъка с хора и да оставя само тези в списъка, които са над 30
        peopleList = peopleList.stream().filter(person -> person.getAge() > 30).collect(Collectors.toList());
        //2. сортираме списъка с хора в нарастващ ред спрямо името
        peopleList.sort(Comparator.comparing(person -> person.getName()));
        //3. отпечатваме всеки един човек в списъка
        for (Person person : peopleList ) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
