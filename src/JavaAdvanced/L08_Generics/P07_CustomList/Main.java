package JavaAdvanced.L08_Generics.P07_CustomList;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String line = "";

        while (!(line = scanner.nextLine()).equals("END")){
            String[] tokens = line.split(" ");

            switch (tokens[0]){
                //•	Add {element} - Adds the given element to the end of the list.
                //•	Remove {index} - Removes the element at the given index.
                //•	Contains {element} - Prints if the list contains the given element (true or false).
                //•	Swap {index1} {index2} - Swaps the elements at the given indexes.
                //•	Greater {element} - Counts the elements that are greater than the given element and prints their count
                //•	Max - Prints the maximum element in the list.
                //•	Min - Prints the minimum element in the list.
                //•	Print - Prints all elements in the list, each on a separate line.

                case "Add" -> customList.add(tokens[1]);
                case "Remove" -> customList.remove(Integer.parseInt(tokens[1]));
                case "Contains" -> System.out.println(customList.contains(tokens[1]));
                case "Swap" -> customList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                case "Greater" -> System.out.println(customList.countGreaterThen(tokens[1]));
                case "Max" -> System.out.println(customList.getMax());
                case "Min" -> System.out.println(customList.getMin());
                case "Print" -> {
                    for (int i = 0; i < customList.size; i++) {
                        System.out.println(customList.get(i));
                    }
                }

            }
        }

    }
}
