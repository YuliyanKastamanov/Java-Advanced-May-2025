package L03_Sets_And_Dictionaries_Advanced;

import java.util.*;

public class P07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")){

            //input = "{personName}: {PT, PT, PT,… PT}".split(": ") -> "{playerName}", "{cards}"
            String playerName = input.split(":\\s+")[0];// "Peter"
            String cards = input.split(":\\s+")[1];// "2C, 4H, 9H, AS, QS"
            String[] cardsArray = cards.split(",\\s+"); //["2C","4H","9H","AS","QS"]

            Set<String> cardsSet = new HashSet<>();
            //1. Добавяме текущите карти към Сет
            cardsSet.addAll(Arrays.asList(cardsArray));

            //2. добавяме в мап-а
            // ако не сме записали играча в мап-а
            if(!players.containsKey(playerName)){
                players.put(playerName, cardsSet);
            }else {
                //ако сме запазили играч с това име -> трябва да допълним сет-а с карти, ако има нови
                //Вземаме текущия сет от карти на играча
                Set<String> currentCards = players.get(playerName);
                //към текущите карти добавяме новите изтеглени -> заради това, че използваме сет ще се добавят само уникалните такива
                currentCards.addAll(cardsSet);
                players.put(playerName, currentCards);
            }
            input = scanner.nextLine();
        }

        //запис: име на играч: брой точки от картите, които държи
        //"{personName}: {value}"
        players.entrySet()
                .forEach(entry -> {
                    String name = entry.getKey();
                    Set<String> cards = entry.getValue();
                    int points = calculateCardsPoints(cards);
                    System.out.printf("%s: %d%n", name, points);

                });


    }

    private static int calculateCardsPoints(Set<String> cards) {

        //всеки символ има дадена стойност
        Map<Character, Integer> symbolValues = getSymbolValues();
        int sumPoints = 0;

        for (String card : cards){

            //2C -> [сила][тип]
            //10 -> сила 10
            int currentCardPoints = 0;
            if(card.startsWith("10")){
                //10C
                //силата = 10
                //тип = 1
                char cardType = card.charAt(2);
                currentCardPoints = 10 * symbolValues.get(cardType);
            }else {
                //5H
                char power = card.charAt(0);//'5'
                char type = card.charAt(1);//H

                currentCardPoints = symbolValues.get(power) * symbolValues.get(type);// 5 * 3

            }

            sumPoints += currentCardPoints;

        }

        //връщаме общата сума
        return sumPoints;

    }

    private static Map<Character, Integer> getSymbolValues() {

        Map<Character, Integer> characterValues = new HashMap<>();

        characterValues.put('2', 2);
        characterValues.put('3', 3);
        characterValues.put('4', 4);
        characterValues.put('5', 5);
        characterValues.put('6', 6);
        characterValues.put('7', 7);
        characterValues.put('8', 8);
        characterValues.put('9', 9);
        characterValues.put('J', 11);
        characterValues.put('Q', 12);
        characterValues.put('K', 13);
        characterValues.put('A', 14);
        characterValues.put('S', 4);
        characterValues.put('H', 3);
        characterValues.put('D', 2);
        characterValues.put('C', 1);
        return characterValues;

    }
}
