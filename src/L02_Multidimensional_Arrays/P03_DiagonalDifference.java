package L02_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int [][] matrix = readMatrix(size, scanner);
        System.out.println();

        int rows = 0;
        int cols = 0;

        int firstDiagonalSum = 0;

        for (int row = 0; row < size; row++) {

            firstDiagonalSum += matrix[rows][cols];
            rows++;
            cols++;

        }

        rows = 0;
        cols = size - 1;
        int secondDiagonal = 0;

        for (int row = 0; row < size; row++) {

            secondDiagonal += matrix[rows][cols];
            rows++;
            cols--;

        }

        System.out.println(Math.abs(firstDiagonalSum - secondDiagonal));




    }

    private static int[][] readMatrix(int size, Scanner scanner) {

        int [][] matrixToReturn = new int[size][];

        for (int row = 0; row < size ; row++) {
            matrixToReturn[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
        return matrixToReturn;

    }
}
