package L11_Exam_Preparation_16_06;

import java.lang.reflect.Array;
import java.util.*;

public class FoodFinder_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        //дума -> сет от символи, които сме срещнали
        Map<String, Set<Character>> wordLetters = new LinkedHashMap<>();
        wordLetters.put("pear", new LinkedHashSet<>());
        wordLetters.put("flour", new LinkedHashSet<>());
        wordLetters.put("pork", new LinkedHashSet<>());
        wordLetters.put("olive", new LinkedHashSet<>());

        ArrayDeque<Character> vowels = new ArrayDeque<>(); //oпашка от гласни букви
        Arrays.stream(scanner.nextLine()  //"e a u o"
                .split("\\s+"))     //["e", "a", "u", "o"]
                .forEach(element -> vowels.offer(element.charAt(0)));

        ArrayDeque<Character> consonants = new ArrayDeque<>(); //стек от съгласни букви
        Arrays.stream(scanner.nextLine()               //"p r l x f"
                             .split("\\s+"))     //["p", "r", "l", "x", "f"]
                             .forEach(element -> consonants.push(element.charAt(0)));

        //повтаряме: взимаме първата буква от гласните и последната от съгласните
        //стоп: нямаме повече съгласни букви
        //продължаваме: имаме все още съгласни букви

        while (!consonants.isEmpty()) {
            char vowel = vowels.poll();
            char consonant = consonants.pop();

            for (String word : words) {
                //проверка дали в думата я има гласната буква
                int indexVowel = word.indexOf(vowel);
                //indexOf -> връща цяло число, което е позицията на буквата в текста
                //-1 -> буквата я няма в думата
                //!= -1 -> буквата я има в думата
                if (indexVowel >= 0) {
                    //гласната буква я има в думата
                    wordLetters.get(word).add(vowel);
                }

                //проверка дали в думата я има съгласната буква
                int indexConsonant = word.indexOf(consonant);
                if (indexConsonant >= 0) {
                    //съгласната буква я има в думата
                    wordLetters.get(word).add(consonant);
                }
            }
            //връщаме гласната буква в края на опашката
            vowels.offer(vowel);
        }

        //дума -> кои букви от нея сме срещнали
        List<String> foundWords = new ArrayList<>();
        for (Map.Entry<String, Set<Character>> entry: wordLetters.entrySet()) {
            //entry
            //entry.getKey -> дума
            //entry.getValue -> съвкупност от срещнати букви
            String word = entry.getKey();
            if (word.length() == entry.getValue().size()) {
                //на конкретната дума сме срещнали всички букви
                foundWords.add(word);
            }
        }

        System.out.println("Words found: " + foundWords.size());
        foundWords.forEach(System.out::println);


    }
}
