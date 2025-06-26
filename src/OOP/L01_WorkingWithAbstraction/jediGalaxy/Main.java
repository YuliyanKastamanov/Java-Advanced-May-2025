package OOP.L01_WorkingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = readPositions(scanner.nextLine());

        Galaxy galaxy = new Galaxy(new Field(matrixDimensions[0], matrixDimensions[1] ));

        String positions = scanner.nextLine();
        long starPowerCollection = 0;

        while (!positions.equals("Let the Force be with you")) {

            int[] jediPositions = readPositions(positions);
            int[] evilPositions = readPositions(scanner.nextLine());


            int evilRow = evilPositions[0];
            int evilCol = evilPositions[1];
            int jediRow = jediPositions[0];
            int jediCow = jediPositions[1];

           galaxy.moveEvil(evilRow, evilCol);


           starPowerCollection += galaxy.moveJedi(jediRow, jediCow);

            positions = scanner.nextLine();
        }

        System.out.println(starPowerCollection);


    }

    private static int[] readPositions(String positions) {
        return Arrays.stream(positions.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
