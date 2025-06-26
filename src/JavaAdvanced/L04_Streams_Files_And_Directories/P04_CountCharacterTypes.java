package JavaAdvanced.L04_Streams_Files_And_Directories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P04_CountCharacterTypes {
    public static void main(String[] args) throws IOException {


        String path = "src/JavaAdvanced.L04_Streams_Files_And_Directories/resourses/input.txt";

        String content = Files.readString(Path.of(path));
        content = content.replaceAll("\\s+", "");

        Set<Character> vowels = new HashSet<>();
        //•	a, e, i, o, u
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');

        Set<Character> punctuation = new HashSet<>();
        //! , . ?
        Collections.addAll(punctuation, '!', ',', '.', '?');

        int countVowels = 0;
        int countPunctuation = 0;
        int countOtherSymbols = 0;

        for (char symbol : content.toCharArray()){
            if(vowels.contains(symbol)){
                countVowels++;
            } else if (punctuation.contains(symbol)) {
                countPunctuation++;
            }else {
                countOtherSymbols++;
            }

        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/JavaAdvanced.L04_Streams_Files_And_Directories/resourses/output.txt"));
        writer.write("Vowels: " + countVowels);
        writer.newLine();
        writer.write("Other symbols: " + countOtherSymbols);
        writer.newLine();
        writer.write("Punctuation: " + countPunctuation);
        writer.close();










    }
}
