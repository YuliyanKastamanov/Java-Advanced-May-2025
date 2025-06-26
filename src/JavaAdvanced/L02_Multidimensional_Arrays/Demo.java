package JavaAdvanced.L02_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[3][3];

        int counter = 1;

        /*for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = counter;
                counter++;
            }

        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();

        }*/

        int rows =Integer.parseInt(scanner.nextLine());

        int[][] exampleMatrix = new int[rows][];

        fillMatrixExample(rows, exampleMatrix);




    }

    private static void fillMatrixExample(int rows, int[][] exampleMatrix) {


        for (int row = 0; row < rows ; row++) {
            exampleMatrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
    }

    private static boolean isInRange (int row, int col, int [][] matrix){

        //matrix.length - броя на редовете
        //matrix[row].length - броя колони в даден ред
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;

    }
}
