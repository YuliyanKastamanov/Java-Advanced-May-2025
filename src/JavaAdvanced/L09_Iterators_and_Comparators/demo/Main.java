package JavaAdvanced.L09_Iterators_and_Comparators.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Varargs
        /*printName("Yuli");
        printName("Yuli", "Georgi");

        List<String> names = new ArrayList<>();
        names.add("Yuli");
        names.add("Georgi");
        names.add("Stanislav");
        names.add("Yana");


        printName(names);

        //Varargs -> (String... names)
        //1. Varargs винаги са последен аргумен
        //2. В един метод можем да имаме само 1 Varargs
        printData("Bulgaria","Sofia","Yuli", "Ivan", "Georgi", "Yana");*/



        Movie movie1 = new Movie("Sinners", 50.00, 7.8);
        Movie movie2 = new Movie("Ballerina", 20.00, 7.3);
        Movie movie3 = new Movie("The last of us", 80.00, 8.6);

        movie1.compareTo(movie2);

        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        Collections.sort(movies);//филмите ще бъдат сравнени спрямо дефолтния метод

        movies.forEach(System.out::println);

        Collections.sort(movies, new MovieRatingComparator());
        System.out.println();

        movies.forEach(System.out::println);

        //Comparator -> дава ни възможност да разпишем външна логика, която да срявнява 2 обекта

        //Comparable -> позволява даден обект да бъде сравняван с друг обект от същия клас






    }




    public static void printData(String country, String... data){

        for (String name : data){
            System.out.println(name);
        }


    }

    private static void printName(List<String> names) {

        names.forEach(System.out::println);
    }

    private static void printName(String name1, String name2) {
        System.out.println(name1);
        System.out.println(name2);
    }

    private static void printName(String name) {

        System.out.println(name);
    }
}
