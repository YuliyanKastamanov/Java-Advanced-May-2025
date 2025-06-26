package JavaAdvanced.L04_Streams_Files_And_Directories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class P05_LineNumbers {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Java-Advanced-May-2025\\src\\JavaAdvanced.L04_Streams_Files_And_Directories\\resourses\\inputLineNumbers.txt";

        List<String> lines = Files.readAllLines(Path.of(path));

        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Java-Advanced-May-2025\\src\\JavaAdvanced.L04_Streams_Files_And_Directories\\resourses\\output.txt"));

        int rowNumber = 1;
        for (String line : lines){
            writer.write(rowNumber + ". " + line);
            writer.write("\n");
            rowNumber++;
        }

        writer.flush();

    }
}
