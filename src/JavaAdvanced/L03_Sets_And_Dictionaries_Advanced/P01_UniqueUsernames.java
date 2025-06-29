package JavaAdvanced.L03_Sets_And_Dictionaries_Advanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countUsernames = Integer.parseInt(scanner.nextLine());

        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 1; i <= countUsernames ; i++) {
            String currentUsername = scanner.nextLine();
            usernames.add(currentUsername);
        }

        for (String name : usernames){
            System.out.println(name);
        }
    }
}
