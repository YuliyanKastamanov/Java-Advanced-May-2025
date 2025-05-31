package L05_Functional_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateParty_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Party!")) {
            String [] commandParts = command.split(" ");
            String action = commandParts[0]; //действие -> "Remove" или "Double"
            String typeAction = commandParts[1]; //"StartsWith", "EndsWith", "Length"

            if (action.equals("Remove")) {
                if (typeAction.equals("StartsWith")) {
                    //command = "Remove StartsWith P".split(" ")
                    //commandParts = ["Remove", "StartsWith", "P"]
                    String textStartsWith = commandParts[2];
                    guests.removeIf(guest -> guest.startsWith(textStartsWith));
                } else if (typeAction.equals("EndsWith")) {
                    //command = "Remove EndsWith P"
                    String textEndsWith = commandParts[2];
                    guests.removeIf(guest -> guest.endsWith(textEndsWith));
                } else if (typeAction.equals("Length")) {
                    //command = "Remove Length 5"
                    int targetLength = Integer.parseInt(commandParts[2]);
                    guests.removeIf(guest -> guest.length() == targetLength);
                }
            } else if (action.equals("Double")) {
                if (typeAction.equals("StartsWith")) {
                    //command = "Double StartsWith P"
                    String textStartsWith = commandParts[2];
                    List<String> additionalGuest = new ArrayList<>(); //гостите, които се дуплицират
                    for (String guest : guests) {
                        if (guest.startsWith(textStartsWith)) {
                            additionalGuest.add(guest);
                        }
                    }
                    guests.addAll(additionalGuest);
                } else if (typeAction.equals("EndsWith")) {
                    //command = "Double EndsWith P"
                    String textEndsText = commandParts[2];
                    List<String> additionalGuest = new ArrayList<>(); //гостите, които се дуплицират
                    for (String guest : guests) {
                        if (guest.endsWith(textEndsText)) {
                            additionalGuest.add(guest);
                        }
                    }
                    guests.addAll(additionalGuest);
                } else if (typeAction.equals("Length")) {
                    //command = "Double Length 5"
                    int targetLength = Integer.parseInt(commandParts[2]);
                    List<String> additionalGuest = new ArrayList<>(); //гостите, които се дуплицират
                    for (String guest : guests) {
                        if (guest.length() == targetLength) {
                            additionalGuest.add(guest);
                        }
                    }
                    guests.addAll(additionalGuest);
                }
            }
            command = scanner.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(guests.stream().sorted() //сортираме в нарасващ ред
                                                .toList() //списък
                                                .toString() //преобразуваме в текст: "[Georgi, Ivan, Peter]"
                                                .replace("[", "") //"Georgi, Ivan, Peter]"
                                                .replace("]", "") //"Georgi, Ivan, Peter"
                                        //"Georgi, Ivan, Peter"
                                        + " are going to the party!"
            );
        }
    }
}
