package Exam_Examples;

import java.util.Scanner;

public class P02_ThroneConquering {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        int rows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][];

        fillMatrix(rows, matrix, scanner);


        int parisRow = 0;
        int parisCol = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if(matrix[row][col] == 'P'){
                    parisRow = row;
                    parisCol = col;
                    break;
                }

            }
        }

        while (true){
            String[] input = scanner.nextLine().split("\\s+");

            String direction = input[0];
            int enemyRow = Integer.parseInt(input[1]);
            int enemyCol = Integer.parseInt(input[2]);

            matrix[parisRow][parisCol] = '-';
            matrix[enemyRow][enemyCol] = 'S';
            //преместване
            //"up", "down", "left", "right".
            switch (direction){
                case "up" -> {
                    if(parisRow - 1 >= 0){
                        parisRow --;
                    }
                }
                case "down" -> {
                    if(parisRow + 1 < matrix.length){
                        parisRow++;
                    }

                }
                case "right" -> {
                    if(parisCol + 1 < matrix.length){
                        parisCol++;
                    }

                }
                case "left" -> {
                    if(parisCol - 1 >= 0){
                        parisCol--;
                    }

                }

            }
            energy--;

            //проверяваме дали Парис е умрял
            if(energy <= 0){
                parisDead(matrix, parisRow, parisCol);
                return;
            }

            //дали има спартанец там където се е преместил Парис
            if(matrix[parisRow][parisCol] == 'S'){
                //победа над спартанеца
                energy -= 2;
                //проверяваме дали Парис е умрял
                if(energy <= 0){
                    parisDead(matrix, parisRow, parisCol);
                    return;
                }else {
                    matrix[parisRow][parisCol] = '-';

                }
            }

            //проверяваме дали Елена е там където се намира Парис след придвижването
            else if (matrix[parisRow][parisCol] == 'H') {
                //достигнали сме Елена
                matrix[parisRow][parisCol] = '-';
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                printField(matrix);
                return;
                
            }


        }




    }

    private static void parisDead(char[][] matrix, int parisRow, int parisCol) {

        //Парис умира
        //1. Там където се намира да принтираме X
        matrix[parisRow][parisCol] = 'X';
        //отпечатваме къде е умрял
        System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        //принтираме матрицата
        printField(matrix);


    }

    private static void printField(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }

    private static void fillMatrix(int rows, char[][] matrix, Scanner scanner){
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}
