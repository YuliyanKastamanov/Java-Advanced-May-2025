package L04_Streams_Files_And_Directories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {



        //Четене от файлове
        //1. Scanner
        //Обичайна употреба -> четене от конзолата
        Scanner scanner = new Scanner(new File("src/L04_Streams_Files_And_Directories/resourses/input.txt"));
        System.out.println(scanner.nextLine());

        //2. BufferedReader
        //Обичайна употреба -> четем големи по обем файлове ред по ред
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/L04_Streams_Files_And_Directories/resourses/input.txt"));
        System.out.println(bufferedReader.readLine());

        //3. FileReader
        //Обичайна употреба -> четене от малки файлове, чете символ по символ
        FileReader fileReader = new FileReader("src/L04_Streams_Files_And_Directories/resourses/input.txt");
        System.out.println((char) fileReader.read());

        //4. Files.readAllLines()
        List<String> allLines = Files.readAllLines(Path.of("src/L04_Streams_Files_And_Directories/resourses/input.txt"));

        //5. Files.readString()
        String fullContent = Files.readString(Path.of("src/L04_Streams_Files_And_Directories/resourses/input.txt"));



        //Писане във файлове
        //1. Писане с PrintWriter
        //.print(), .println(), .printf()
        PrintWriter printWriter = new PrintWriter("output.txt");
        printWriter.println("Hello world!");
        printWriter.println();//добавя нов ред
        printWriter.println("My name is Yuli");
        printWriter.println("One more Line");
        //Затваряме потока от информация към този файл и всички наши промени се отразяват
        printWriter.close();

        //2. Писане с BufferedWriter -> използва буферната памет
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        bufferedWriter.write("Hello world!");
        bufferedWriter.newLine();//добавя нов ред
        //Затваряме потока от информация към този файл и всички наши промени се отразяват
        bufferedWriter.close();

        //3. Писане с FileWriter -> не използва буферната памет
        FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write("Hello world!");
        fileWriter.write("Hello world!\n" +
                "new line \n" +
                "final line ");
        fileWriter.close();





    }
}
