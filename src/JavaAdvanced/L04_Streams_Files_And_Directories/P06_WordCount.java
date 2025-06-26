package JavaAdvanced.L04_Streams_Files_And_Directories;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P06_WordCount {
    public static void main(String[] args) throws IOException {

        String pathWords = "src/JavaAdvanced.L04_Streams_Files_And_Directories/resourses/words.txt";

        String pathTwo = "src/JavaAdvanced.L04_Streams_Files_And_Directories/resourses/text.txt";

        Map<String, Integer> countWords = new HashMap<>();

        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));

        for (String line : allLinesWithWords){
            //of which The
            Arrays.stream(line.split("\\s+"))
                    .forEach(word -> {
                        countWords.put(word, 0);
                    });

        }

        List<String> allLines = Files.readAllLines(Path.of(pathTwo));

        for (String line : allLines){
            line = line.replaceAll(",", "");
            Arrays.stream(line.split("\\s+"))
                    .forEach(word -> {
                        if(countWords.containsKey(word)){
                            int currentCount = countWords.get(word);
                            countWords.put(word, currentCount + 1);
                        }
                    });
        }

        PrintWriter writer = new PrintWriter("src/JavaAdvanced.L04_Streams_Files_And_Directories/resourses/results.txt");

        countWords.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
        //compareTo > 0 (първият ел. == втория ел), 1 (първия > втория), -1 (втория > първия)
        //sorted -> 0 (не разменя местата), 1(разменя местата на първия и втория елемент), -1 (не разменя местата на елементите)











    }
}
