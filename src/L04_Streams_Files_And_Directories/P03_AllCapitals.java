package L04_Streams_Files_And_Directories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class P03_AllCapitals {
    public static void main(String[] args) throws IOException {


        String path = "src/L04_Streams_Files_And_Directories/resourses/input.txt";

        String content = Files.readString(Path.of(path));
        content = content.toUpperCase();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Java-Advanced-May-2025\\src\\L04_Streams_Files_And_Directories\\resourses\\output.txt"));
        bufferedWriter.write(content);
        System.out.println();
        bufferedWriter.flush();





    }
}
