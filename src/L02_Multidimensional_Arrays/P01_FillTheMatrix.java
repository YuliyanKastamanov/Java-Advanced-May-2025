package L02_Multidimensional_Arrays;

import java.util.Scanner;

public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int dimensions = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int[][] matrix = new int[dimensions][dimensions];

        if (pattern.equals("A")){
            fillTheMatrixPatternA(matrix);
        } else if (pattern.equals("B")) {
            fillTheMatrixPatternB(matrix);
        }

        printMatrix(matrix);


    }

    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

        }

    }

    private static void fillTheMatrixPatternB(int[][] matrix) {

        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if(col % 2 == 0){
                for (int row = 0; row < matrix.length ; row++) {
                    matrix[row][col] = startNumber++;

                }
            }else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber++;

                }
            }

        }
    }

    private static void fillTheMatrixPatternA(int[][] matrix) {

        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber++;
                
            }
            
        }
    }
}
