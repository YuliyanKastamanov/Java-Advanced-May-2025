package OOP.L05_Polymorphism.Demo;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Cat lion = new Lion();
        Cat tiger = new Tiger();
        Cat jaguar = new Jaguar();

        /*List<Integer> list = new ArrayList<>();
        Set<String> set = new TreeSet<>();
        Map<String, Integer> map = new LinkedHashMap<>();*/

        /*Dolittle drDolittle = new Dolittle();
        drDolittle.healCat(lion);
        drDolittle.healCat(tiger);
        drDolittle.healCat(jaguar);*/

        lion.run();
        tiger.run();
        jaguar.run();

        //1. Method overriding (Runtime polymorphism)
        // -> възможността дъщерните класове да дават имплементация на методи, дефинирани в бащините класове


        //2. Method overloading -> Compile time polymorphism
        //Math.abs() -> извикваме метода с различни типове данни(аргументи)

        multiply(5, 10);
        multiply(5.2, 10.4);
        System.out.println(multiply(10, 20, 30));


    }

    private static int multiply(int a, int b, int c) {
       return a * b * c;
    }

    private static void multiply(double a, double b) {
        System.out.println(a * b);
    }

    public static void multiply(int a, int b){
        System.out.println(a * b);
    }
}
