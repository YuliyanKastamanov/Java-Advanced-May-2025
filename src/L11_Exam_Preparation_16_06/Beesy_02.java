package L11_Exam_Preparation_16_06;

import java.util.Scanner;

public class Beesy_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой редове = брой колони
        char[][] matrix = new char[n][n];

        //пълним матрицата
        for (int row = 0; row < n; row++) {
            //row = 0 ..... 4
            matrix[row] = scanner.nextLine().toCharArray();
        }

        //намираме пчелата
        int rowBee = 0;
        int colBee = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'B') {
                    rowBee = row;
                    colBee = col;
                }
            }
        }

        //първоначална енергия
        int beeEnergy = 15; //енергия на пчелата за летене
        int nectarCollected = 0; //събран нектар
        int countRecharges = 1; //брой пъти, в които си е възстановила енергията

        //започва движение на пчелата
        String direction = scanner.nextLine();
        while (true) {
            //преди преместване
            matrix[rowBee][colBee] = '-';
            //по време на преместване
            switch (direction) {
                case "down" -> rowBee++;
                case "up" -> rowBee--;
                case "left" -> colBee--;
                case "right" -> colBee++;
            }

            //проверка дали при преместването не излизаме от матрицата
            //проверка за реда
            if (rowBee < 0) {
                rowBee = n - 1;
            } else if (rowBee > n - 1) {
                rowBee = 0;
            }

            //проверка за колоната
            if (colBee < 0) {
                colBee = n - 1;
            } else if (colBee > n - 1) {
                colBee = 0;
            }

            beeEnergy--; //след всяко преместване губим по 1 енергия

            //проверка на какво поле се мести пчелата
            //знаем нашата пчела къде отива: [rowBee, colBee]
            //1. цвете (цяло число)
            if (Character.isDigit(matrix[rowBee][colBee])) {
                //има цвете с нектар
                //'9' -> "9" -> 9
                nectarCollected += Integer.parseInt(matrix[rowBee][colBee] + "");
                //Character.getNumericValue(matrix[rowBee][colBee])
                matrix[rowBee][colBee] = '-';
            }
            //2. кошер ('H')
            if (matrix[rowBee][colBee] == 'H') {
                //има кошер
                matrix[rowBee][colBee] = 'B';
                //прибира в кошера
                //1. събрала достатъчно нектар
                if (nectarCollected >= 30) {
                    System.out.println("Great job, Beesy! The hive is full. Energy left: " + beeEnergy);
                    printMatrix(matrix);
                }
                //3. не е събрала нектар
                else {
                    System.out.println("Beesy did not manage to collect enough nectar.");
                    printMatrix(matrix);
                }
                //прекратяваме движението
                break;
            }

            //3. тире -> празно място
            matrix[rowBee][colBee] = 'B';

            //проверка дали има още енергия
            if (beeEnergy == 0) {
                //спира движение, защото няма енергия
                //проверка дали е събрала достатъчно нектар
                if (nectarCollected <= 30) {
                    System.out.println("This is the end! Beesy ran out of energy.");
                    printMatrix(matrix);
                    break;
                } else {
                    //събрала повече от 30 нектар -> дава възможност да се възстанови един път
                    if (countRecharges == 1) {
                        //за първи път се възстановява
                        int overNectar = nectarCollected - 30; //колко нектар е събрала в повече
                        nectarCollected = 30;
                        beeEnergy += overNectar;
                        countRecharges--; //0 -> няма повече възстановявания
                    } else {
                        //countRecharges = 0 -> няма повече опции за възстановяване
                        System.out.println("This is the end! Beesy ran out of energy.");
                        printMatrix(matrix);
                        break;
                    }
                }
            }

            direction = scanner.nextLine();
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int c = 0; c < matrix[row].length; c++) {
                System.out.print(matrix[row][c]);
            }
            System.out.println();
        }
    }
}
