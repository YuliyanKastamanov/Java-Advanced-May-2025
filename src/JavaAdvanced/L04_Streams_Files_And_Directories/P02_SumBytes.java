package JavaAdvanced.L04_Streams_Files_And_Directories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class P02_SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Java-Advanced-May-2025\\src\\JavaAdvanced.L04_Streams_Files_And_Directories\\resourses\\input.txt";
        int sum = 0;
        /*BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line = bufferedReader.readLine();



        while (line != null){
            for (char symbol : line.toCharArray()){
                sum += symbol;
            }

            line = bufferedReader.readLine();
        }

        ;*/

        Scanner scanner = new Scanner(new FileReader(path));
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            for (char symbol : line.toCharArray()){
                sum += symbol;
            }
        }

        System.out.println(sum);


    }
}
