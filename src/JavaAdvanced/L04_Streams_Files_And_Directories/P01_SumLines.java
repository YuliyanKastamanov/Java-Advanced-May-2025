package JavaAdvanced.L04_Streams_Files_And_Directories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class P01_SumLines {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Java-Advanced-May-2025\\src\\JavaAdvanced.L04_Streams_Files_And_Directories\\resourses\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(path));

        allLines.stream()
                .map(line -> line.toCharArray())
                .forEach(array -> {
                    int sum = 0;
                    for (char symbol: array){
                        sum += symbol;
                    }
                    System.out.println(sum);
                });





    }
}
