package L01_Stack_And_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());;


        ArrayDeque<String> wordStates = new ArrayDeque<>();

        StringBuilder text = new StringBuilder();

        for (int i = 1; i <= number ; i++) {
            String command = scanner.nextLine();
            String commandNumber = command.split("\\s+")[0];


            switch (commandNumber){
                case "1":
                    String textToAdd = command.split("\\s+")[1];
                    wordStates.push(text.toString());
                    text.append(textToAdd);
                    break;

                case "2":
                    wordStates.push(text.toString());
                    int count = Integer.parseInt(command.split("\\s+")[1]);
                    int startIndex = text.length() - count;
                    text.delete(startIndex, text.length());
                    break;

                case "3":
                    int index = Integer.parseInt(command.split("\\s+")[1]) - 1;
                    System.out.println(text.charAt(index));
                    break;
                case "4":
                    text = new StringBuilder(wordStates.pop());
                    break;
            }

        }
    }
}
