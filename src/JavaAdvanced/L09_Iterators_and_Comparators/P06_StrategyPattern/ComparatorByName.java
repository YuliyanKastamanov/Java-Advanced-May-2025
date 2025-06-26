package L09_Iterators_and_Comparators.P06_StrategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {

        //Начин 1: нужен ние е класа Integer за да използваме compareTo()
        //тъй като методът length() -> int -> примитивен тип данни
        //трябва да използваме Integer.compare(аргумент1, аргумент2)


        int nameLengthComparingResult = Integer.compare(person1.getName().length(), person2.getName().length());

        if(nameLengthComparingResult == 0){
            char firstNameFirstSymbol = person1.getName().toUpperCase().charAt(0);
            char secondNameFirstSymbol = person2.getName().toUpperCase().charAt(0);
            int comparingByFirstLetterResult = Character.compare(firstNameFirstSymbol, secondNameFirstSymbol);
            return comparingByFirstLetterResult;
        }
        return nameLengthComparingResult;
    }
}
