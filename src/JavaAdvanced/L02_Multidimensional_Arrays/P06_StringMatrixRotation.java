package JavaAdvanced.L02_Multidimensional_Arrays;

import java.util.*;

public class P06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine().replace("Rotate(", "").replace(")", ""));


        String matrixLine = scanner.nextLine();

        List<String> words = new ArrayList<>();

        while (!matrixLine.equals("END")){
            words.add(matrixLine);
            matrixLine = scanner.nextLine();
        }


        String longestWord = Collections.max(words, Comparator.comparing(String::length));
        int rows = words.size();
        int cols = longestWord.length();

        char [][] matrix = new char[rows][cols];

        fillMatrix(matrix, words);

        int rotationCount = degrees / 90;

        for (int rotation = 1; rotation <= rotationCount ; rotation++) {

            matrix = rotate90Degrees(matrix);

        }
        printMatrix(matrix);





    }

    private static char[][] rotate90Degrees(char[][] matrix) {

        int newRows = matrix[0].length;
        int newCols = matrix.length;

        char[][] newMatrix = new char[newRows][newCols];

        for (int col = 0; col < matrix[0].length; col++) {
            int counter = 0;
            for (int row =  matrix.length - 1; row >= 0; row--) {
                char currentLetter = matrix[row][col];
                newMatrix[col][counter++] = currentLetter;

                //counter++;
                
            }

        }



        return newMatrix;

    }



    private static void fillMatrix(char[][] matrix, List<String> words) {

        for (int row = 0; row < matrix.length; row++) {
            String word = words.get(row);

            for (int col = 0; col < matrix[row].length; col++) {

                if(col <= word.length() - 1){
                    // hello - 5
                    matrix[row][col] = word.charAt(col);
                }else {
                    matrix[row][col] = ' ';
                }

            }

        }


    }

    private static void printMatrix(char[][] matrix){
        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();

        }
    }


}
