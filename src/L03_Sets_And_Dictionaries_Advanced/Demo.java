package L03_Sets_And_Dictionaries_Advanced;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //Имаме 3 вида Set -> HashSet, TreeSet, LinkedHashSet

        Set<Integer> numbers = new HashSet<>();// елементите се подреждат без да са в определен ред
        Set<Integer> numbersTreeSet = new TreeSet<>();// елементите се подреждат лексикографски/нарастващ ред
        Set<Integer> numbersLinkedHashSet = new LinkedHashSet<>();// елементите се подреждат спрямо реда на добавяне

        //Разлики между Set -> List
        //1. Set -> запазваме уникални елементи -> ако подадем вече съществуващ елемент -> пропускаме тази операция
        //2. Set -> не можем да достъпваме елементите по индекс

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println();





    }
}
