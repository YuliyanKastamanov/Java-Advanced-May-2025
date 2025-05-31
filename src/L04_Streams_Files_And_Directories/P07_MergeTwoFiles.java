package L04_Streams_Files_And_Directories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        List<String> linesOne = Files.readAllLines(Path.of("src/L04_Streams_Files_And_Directories/resourses/inputOne.txt"));
        List<String> linesTwo = Files.readAllLines(Path.of("src/L04_Streams_Files_And_Directories/resourses/inputTwo.txt"));

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/L04_Streams_Files_And_Directories/resourses/output.txt"));

        linesOne.forEach(line -> {

            try {
                writer.write(line);
                writer.newLine();
            }catch (IOException exception){
                exception.printStackTrace();
            }

        });

        linesTwo.forEach(line -> {
            try {
                writer.write(line);
                writer.newLine();
            }catch (IOException exception){
                exception.printStackTrace();
            }
        });

        writer.close();




    }
}