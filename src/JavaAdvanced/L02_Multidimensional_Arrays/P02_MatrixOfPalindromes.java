package JavaAdvanced.L02_Multidimensional_Arrays;

import java.util.Scanner;

public class P02_MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);

        String [][] matrix = new String[rows][cols];

        fillMatrix(matrix, rows, cols);

        printMatrix(matrix);



    }

    private static void fillMatrix(String[][] matrix, int rows, int cols) {

        for (int row = 0; row < rows ; row++) {

            char char1And3 = (char) (97 + row);

            for (int col = 0; col < cols; col++) {
                char char2 = (char) (97 + col + row);
                String stringToFill = new StringBuilder().append(char1And3).append(char2).append(char1And3).toString();
                matrix[row][col] = stringToFill;

            }
        }
    }

    private static void printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

        }

    }
}
