package OOP.L01_WorkingWithAbstraction.P03_CardWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       /* RankPower cardName = RankPower.valueOf(scanner.nextLine());
        SuitPower cardSuit = SuitPower.valueOf(scanner.nextLine());
        Card card = new Card(cardName, cardSuit);*/

        String cardName = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        int cardPower = RankPower.valueOf(cardName).getPower() + SuitPower.valueOf(cardSuit).getPower();

        System.out.printf("Card name: %s of %s; Card power: %d", cardName, cardSuit, cardPower);


        
    }
}
