package L10_Exam_Preparation_13_06;

import java.util.Scanner;

public class P02_StickyFingers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[] movingCommands = scanner.nextLine().split(",");
        String[][] field = new String[fieldSize][fieldSize];

        int rowIndex = -1;
        int colIndex = -1;

        for (int row = 0; row < fieldSize; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int col = 0; col < fieldSize; col++) {
                field[row][col] = currentRow[col];
                if(field[row][col].equals("D")){
                    rowIndex = row;
                    colIndex = col;
                }
            }

        }

        int totalMoney = 0;
        boolean isCaught = false;

        for (int commandIndex = 0; commandIndex < movingCommands.length; commandIndex++) {
            //придвижваме се по матрицата в зависимост от командата
            switch (movingCommands[commandIndex]){
                case "up" -> {
                    if(rowIndex - 1 >= 0){
                        field[rowIndex][colIndex] = "+";
                        rowIndex--;
                    }else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                }
                case "down" -> {
                    if(rowIndex + 1 < fieldSize){
                        field[rowIndex][colIndex] = "+";
                        rowIndex++;
                    }else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }

                }
                case "left" -> {
                    if(colIndex - 1 >= 0){
                        field[rowIndex][colIndex] = "+";
                        colIndex--;
                    }else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }

                }
                case "right" -> {
                    if(colIndex + 1 < fieldSize){
                        field[rowIndex][colIndex] = "+";
                        colIndex++;
                    }else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }

                }
            }

            //Когато попаднем на полицейско управление
            if(field[rowIndex][colIndex].equals("P")){
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoney);
                field[rowIndex][colIndex] = "#";
                isCaught = true;
                break;
            }

            //Когато попаднем на Къща, която можем да оберем
            if(field[rowIndex][colIndex].equals("$")){
                System.out.printf("You successfully stole %d$.%n", rowIndex * colIndex);
                totalMoney += rowIndex * colIndex;
            }

            field[rowIndex][colIndex] = "D";

        }

        if(!isCaught){
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoney);
        }

        for (int row = 0; row < fieldSize; row++) {
            System.out.println(String.join(" ", field[row]));

        }


    }
}
